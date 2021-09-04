package io.nozemi.runescape.net.codec.pregame;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.nozemi.runescape.net.message.PreLoginResponseMessage;

/**
 * Created by Bart on 7/7/2015.
 */
public class PreGameLoginEncoder extends MessageToByteEncoder<PreLoginResponseMessage> {
	
	@Override
	protected void encode(ChannelHandlerContext ctx, PreLoginResponseMessage msg, ByteBuf out) throws Exception {
		out.writeLong(9223372034707292159L);
	}
	
}
