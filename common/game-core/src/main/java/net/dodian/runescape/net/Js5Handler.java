package net.dodian.runescape.net;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.typesafe.config.Config;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;
import net.dodian.runescape.GameInitializer;
import net.dodian.runescape.net.future.ClosingChannelFuture;
import net.dodian.runescape.net.message.HandshakeMessage;
import net.dodian.runescape.net.message.HandshakeResponse;
import net.dodian.runescape.net.message.Js5DataMessage;
import net.dodian.runescape.net.message.Js5DataRequest;
import nl.bartpelle.dawnguard.DataStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

@ChannelHandler.Sharable
public class Js5Handler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LogManager.getLogger(Js5Handler.class);

    private byte[] cachedIndexInfo;

    private final DataStore store;
    private final Config config;

    /**
     * Timed cache for requests to prevent DDoS through amplified cache responses.
     */
    private static final AttributeKey<Cache<Long, Long>> JS5_REQ_CACHE_KEY = AttributeKey.newInstance("JS5_REQS");

    public Js5Handler() {
        this.config = GameInitializer.config();
        this.store = GameInitializer.store();

        if(config == null) {
            throw new RuntimeException("Failed to get config...");
        }

        if(store == null) {
            throw new RuntimeException("Failed to get data store...");
        }
    }

    private static Cache<Long, Long> requestsCacheFor(Channel channel) {
        Cache<Long, Long> cache = channel.attr(JS5_REQ_CACHE_KEY).get();

        if (cache == null) {
            cache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.SECONDS).build();
            channel.attr(JS5_REQ_CACHE_KEY).set(cache);
        }

        return cache;
    }

    private void throttle(Channel c, long dataSize) {
        Cache<Long, Long> cache = requestsCacheFor(c);
        cache.put(System.nanoTime(), dataSize);
    }

    private boolean isThrottled(Channel c) {
        Cache<Long, Long> cache = requestsCacheFor(c);
        cache.cleanUp();

        return cache.asMap().values().stream().mapToLong(l -> l).sum() >= 5_000_000;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);

        if(msg instanceof HandshakeMessage) {
            HandshakeMessage mes = (HandshakeMessage) msg;

            if(mes.revision() != config.getInt("server.revision")) {
                if(config.getBoolean("server.forcerevision")) {
                    logger.trace("Rejected incoming js5 channel because their revision ({}) was not {}", mes.revision(), config.getInt("server.revision"));

                    ctx.writeAndFlush(HandshakeResponse.OUT_OF_DATE).addListener(new ClosingChannelFuture());
                    return;
                } else {
                    logger.trace("Accepted js5 connection with invalid revision ({}, wanted {})", mes.revision(), config.getInt("server.revision"));
                }
            } else {
                logger.trace("Accepted js5 handshake from {}", ctx.channel());
            }

            ctx.writeAndFlush(HandshakeResponse.ALL_OK);
        } else if (msg instanceof Js5DataRequest) {
            if (isThrottled(ctx.channel())) {
                String ip = ((InetSocketAddress) ctx.channel().remoteAddress()).getAddress().getHostAddress();
                logger.error("Throttling JS5 from {} - exceeded 5MB/s.", ip);
                return;
            }

            Js5DataRequest req = ((Js5DataRequest) msg);
            byte[] data;

            if (req.index() == 255 && req.container() == 255) {
                data = getIndexInfo();
            } else if (req.index() == 255) {
                data = getDescriptorData(req.container());
            } else {
                data = getFileData(req.index(), req.container());
            }

            ctx.writeAndFlush(new Js5DataMessage(req.index(), req.container(), data, req.priority()));
            throttle(ctx.channel(), data.length);
        }
    }

    private byte[] getDescriptorData(int index) {
        return trim(store.getDescriptorIndex().getArchive(index));
    }

    private byte[] getFileData(int index, int file) {
        return trim(store.getIndex(index).getArchive(file));
    }

    private byte[] getIndexInfo() {
        if (cachedIndexInfo != null)
            return cachedIndexInfo;

        cachedIndexInfo = new byte[5 + store.getIndexCount() * 8];
        ByteBuffer buffer = ByteBuffer.wrap(cachedIndexInfo);
        buffer.put((byte) 0);
        buffer.putInt(store.getIndexCount() * 8);

        for (int index = 0; index < store.getIndexCount(); index++) {
            buffer.putInt(store.getIndex(index).getCRC());
            buffer.putInt(store.getIndex(index).getDescriptor().getRevision());
        }
        return cachedIndexInfo;
    }

    private byte[] trim(byte[] b) {
        if (b == null || b.length <= 5) {
            return new byte[5];
        }

        ByteBuffer buffer = ByteBuffer.wrap(b);
        int compression = buffer.get();
        int size = buffer.getInt();

        byte[] n = new byte[size + (compression == 0 ? 5 : 9)];
        System.arraycopy(b, 0, n, 0, size + (compression == 0 ? 5 : 9));
        return n;
    }
}
