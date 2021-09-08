package net.dodian.runescape.net.codec.pregame;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import net.dodian.runescape.net.message.HandshakeResponse;

/**
 * Created by Bart on 8/4/2014.
 */
public class HandshakeResponseEncoder extends MessageToByteEncoder<HandshakeResponse> {
	
	@Override
	protected void encode(ChannelHandlerContext ctx, HandshakeResponse msg, ByteBuf out) throws Exception {
		out.writeByte(msg.value());
	}
	
}
