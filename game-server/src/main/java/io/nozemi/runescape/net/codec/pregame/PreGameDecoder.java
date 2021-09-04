package io.nozemi.runescape.net.codec.pregame;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.nozemi.runescape.net.future.ClosingChannelFuture;
import io.nozemi.runescape.net.message.HandshakeMessage;
import io.nozemi.runescape.net.message.Js5DataRequest;
import io.nozemi.runescape.net.message.LoginRequestMessage;
import io.nozemi.runescape.util.BufferUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Bart on 8/4/2014.
 */
public class PreGameDecoder extends ByteToMessageDecoder {
	
	/**
	 * Logging instance for this class.
	 */
	private static final Logger logger = LogManager.getLogger(PreGameDecoder.class);
	
	private static final int HANDSHAKE_OPCODE = 15;
	
	private static final int INITIALIZATION_OPCODE_1 = 2;
	private static final int INITIALIZATION_OPCODE_2 = 3;
	private static final int INITIALIZATION_OPCODE_3 = 6;
	
	private static final int PRIORITY_FETCH = 0;
	private static final int DELAYABLE_FETCH = 1;
	
	private static final int PRE_LOGIN = 14;
	private static final int LOGIN = 16;
	private static final int RECONNECT = 18;
	
	private int revision;
	
	public PreGameDecoder(int revision) {
		this.revision = revision;
	}
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		if (!in.isReadable())
			return;
		
		in.markReaderIndex();
		int opcode = in.readByte();
		
		if (opcode == HANDSHAKE_OPCODE) {
			int revision = in.readInt();
			out.add(new HandshakeMessage(revision));
		} else if (opcode == INITIALIZATION_OPCODE_1 || opcode == INITIALIZATION_OPCODE_2 || opcode == INITIALIZATION_OPCODE_3) {
			in.skipBytes(3);
		} else if (opcode == PRIORITY_FETCH || opcode == DELAYABLE_FETCH) {
			if (in.readableBytes() < 3) {
				in.resetReaderIndex();
				return;
			}
			
			int index = in.readUnsignedByte();
			int container = in.readUnsignedShort();
			
			logger.trace("Container fetch request for index {}, container {}.", index, container);
			out.add(new Js5DataRequest(index, container, opcode == PRIORITY_FETCH));
		} else if (opcode == PRE_LOGIN) {
			ctx.writeAndFlush(ctx.alloc().buffer(1).writeByte(0));
		} else if (opcode == LOGIN || opcode == RECONNECT) {
			/* Make sure all data is here */
			int size = in.readUnsignedShort();
			int end = in.readerIndex() + size;
			if (in.readableBytes() < size) {
				in.resetReaderIndex();
				return;
			}

			/* Decode login now that we're sure this is a full packet */
			LoginRequestMessage lrm = decodeLogin(ctx, in);
			if (lrm != null)
				out.add(lrm);
			
			// Skip to end of message
			in.readerIndex(end);
		} else if (opcode == 23) {
			in.readInt();
			ByteBuf o = Unpooled.buffer();
			o.writeByte(0);
			o.writeShort(28); // sz
			o.writeByte(1); // all okay
			o.writeByte(1); // whole packet
			
			o.writeByte(1);
			{// Num worlds
				o.writeByte(0); // flag
				o.writeByte(0).writeBytes("Hi".getBytes()).writeByte(0); // name
			}
			
			o.writeByte(0);
			o.writeByte(1);
			o.writeByte(1);
			
			o.writeByte(0);
			o.writeByte(0);
			o.writeInt(0);
			o.writeByte(0).writeByte(0); // activity
			o.writeByte(0).writeByte(0); // address
			o.writeInt(0);
			
			o.writeByte(0);
			o.writeShort(0);
			
			ctx.writeAndFlush(o);
		} else {
			logger.info("Unknown incoming pregame opcode: {}", opcode);
			in.resetReaderIndex();
		}
	}
	
	private LoginRequestMessage decodeLogin(ChannelHandlerContext ctx, ByteBuf in) {
		int revision = in.readInt();
		
		int unknown_1 = in.readByte();
		int authtype = in.readByte();  // 1 and 3 are PIN auth (3 is reauth? 1 is commonly used)
		
		// Make sure revision matches!
		if (this.revision != revision) {
			ByteBuf resp = ctx.channel().alloc().buffer(1).writeByte(6);
			ctx.channel().writeAndFlush(resp).addListener(new ClosingChannelFuture());
			return null;
		}

		/* Isaac key */
		int[] isaacSeed = new int[4];
		for (int i = 0; i < 4; i++) {
			isaacSeed[i] = in.readInt();
		}
		
		// 6-digit auth code
		int authcode = in.readUnsignedMedium();
		if (authtype != 1 && authtype != 3) {
			authcode = -1;
		}
		
		in.skipBytes(5);
		
		String password = BufferUtilities.readString(in);
		String username = BufferUtilities.readString(in);
		
		int settings = in.readByte(); // Byte
		boolean resizable = settings >> 1 == 1;
		in.skipBytes(2); // Short
		in.skipBytes(2); // Short
		//int unknownshort1 = in.readShort();
		//int unknownshort2 = in.readShort();
//
		///* Contents from the random.dat file (probably used to ban a computer) */
		//byte[] random_dat = new byte[24];
		//in.readBytes(random_dat);
		in.skipBytes(24);
		BufferUtilities.readString(in);
		in.skipBytes(4);
		byte[] uuid = new byte[16];
		in.readBytes(uuid);
		
		in.skipBytes(18);
		
		BufferUtilities.readJagString(in);
		BufferUtilities.readJagString(in);
		BufferUtilities.readJagString(in);
		BufferUtilities.readJagString(in);
		
		in.skipBytes(3);
		
		BufferUtilities.readJagString(in);
		BufferUtilities.readJagString(in);
		
		in.skipBytes(2);
		in.skipBytes(4 * 3);
		in.skipBytes(4);
		
		in.readInt();//no idea always 0
		
		int[] crcs = new int[17];
		for (int i = 0; i < crcs.length; i++) {
			crcs[i] = in.readInt();
		}
		
		byte[] hwid = new byte[20];
		in.readBytes(hwid);
		
		boolean realUID = false;
		for (byte b : hwid) {
			if (b != 0) {
				realUID = true;
				break;
			}
		}
		
		String hwidSha = realUID ? String.format("%040x", new BigInteger(1, hwid)) : null;
		
		logger.info("User login from {} Auth pin: {}.", username, authcode);
		
		return new LoginRequestMessage(ctx.channel(), username, password, isaacSeed, crcs, revision, new byte[24], resizable,
				new BigInteger(uuid).toString(16).toUpperCase(), authcode, hwidSha, "");
	}
	
}
