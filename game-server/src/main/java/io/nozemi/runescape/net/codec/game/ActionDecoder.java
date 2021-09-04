package io.nozemi.runescape.net.codec.game;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.ServerHandler;
import io.nozemi.runescape.net.packets.PacketProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ActionDecoder extends ByteToMessageDecoder {

	private Map<Integer, Integer> ignored = new HashMap<>();
	private int[] actionSizes = new int[] { 9, -1, 3, -1, 7, 2, -1, 0, 9, 8, -1, 8, 7, 4, 8, 4, 7, 0, -1, -2, 8, 3, 8,
			8, 7, 8, 7, 15, 3, 16, 2, 8, -2, 2, 7, 9, 7, 13, 13, 8, 8, 10, 8, 11, -1, 8, 3, 7, -1, 14, 4, 7, 4, 6, 11,
			13, 8, 3, 8, -1, 16, 16, 1, 8, 15, 8, -1, 8, -1, 0, 0, 3, 3, 3, -1, -1, 0, 9, 8, 7, 5, 2, 3, -2, -1, 3, -1,
			3, 3, 3, -1, 8, 6, -1, 3, 4, 8, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	
	private State state = State.OPCODE;
	private int opcode;
	private int size;

	private final PacketProvider packetProvider;

	@Autowired
	public ActionDecoder(PacketProvider packetProvider) {
		this.packetProvider = packetProvider;

		// Ignore a few classes
		ignored.put(93, -1); // Mouse history
		ignored.put(83, -2); // Key history
		//ignored.put(53, 6); // Mouse click
		ignored.put(50, 4); // Key
		ignored.put(76, 0); // Ping
	}
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		if (in.readableBytes() < 1) {
			/* Disconnection */
			return;
		}
		
		Player player = ctx.channel().attr(ServerHandler.ATTRIB_PLAYER).get();
		RSBuffer buffer = new RSBuffer(in);
		
		switch (state) {
			case OPCODE:
				if (in.readableBytes() < 1)
					return;
				opcode = buffer.readByte() /*- player.inRand().nextInt()*/ & 0xFF;
				state = State.SIZE;
				in.markReaderIndex();
			
			case SIZE:
				int required = actionSizes[opcode];

				if (required == -1) {
					if (in.readableBytes() < 1) {
						in.resetReaderIndex();
						return;
					}

					size = buffer.readUByte();
				} else if (required == -2) {
					if (in.readableBytes() < 2) {
						in.resetReaderIndex();
						return;
					}

					size = buffer.readUShort();
				} else {
					size = required;
				}
				
				state = State.DATA;
				in.markReaderIndex();
			
			case DATA:
				if (in.readableBytes() < size) {
					// Too much data? Skip it.
					if (size > 25000) {
						in.skipBytes(in.readableBytes());
						state = State.OPCODE;
					}
					
					break;
				}

				if(!ignored.containsKey(opcode)) {
					int bufferStart = buffer.get().readerIndex();
					RSBuffer newBuffer = new RSBuffer(buffer.get().slice(bufferStart, size));
					packetProvider.processBuffer(newBuffer, ctx, opcode, size, player);
					player.lastPing(System.currentTimeMillis());
					buffer.get().readerIndex(bufferStart + size);
				} else {
					buffer.skip(size);
				}
				
				state = State.OPCODE;
				in.markReaderIndex();
				break;
		}
	}

	enum State {
		OPCODE,
		SIZE,
		DATA
	}
	
}
