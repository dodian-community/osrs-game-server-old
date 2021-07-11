package io.nozemi.runescape.net.codec.game;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.nozemi.runescape.handlers.impl.DataHandler;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.ServerHandler;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.action.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ActionDecoder extends ByteToMessageDecoder implements BeanFactoryAware {
	
	private static final Logger logger = LogManager.getLogger(ActionDecoder.class);
	
	@SuppressWarnings("unchecked")
	private Action[] actionRepository = new Action[256];

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

	private BeanFactory beanFactory;

	@Autowired
	public ActionDecoder(ButtonAction buttonAction, DataHandler dataHandler) {
		actionRepository[84] = new WalkMap();
		actionRepository[97] = new WalkMap();

		actionRepository[44] = new PublicChat(dataHandler);

		actionRepository[62] = new WindowStateChanged();
		actionRepository[80] = new ChangeDisplayMode();

		actionRepository[92] = new DialogueContinue();

		actionRepository[69] = new CloseMainInterface();
		actionRepository[15] = new IntegerInput();
		actionRepository[1] = new StringInput();

		actionRepository[38] = new SetLooks();

		actionRepository[17] = new PingPacket();

		actionRepository[90] = new CommandAction();

		Arrays.stream(ButtonAction.OPCODES).forEach(i -> actionRepository[i] = buttonAction);


		/* Fill repo, maybe through xml/json? */
		//actionRepository[232] = GrandExchangeSearch.class;

		//actionRepository[135] = ClientCrash.class;
//		actionRepository[123] = UniqueButton1.class;
//		actionRepository[200] = UniqueButton2.class;
		
		// Ignore a few classes
		ignored.put(93, -1); // Mouse history
		ignored.put(83, -2); // Key history
		ignored.put(53, 6); // Mouse click
		//ignored.put(114, 4); // Camera movement
		ignored.put(50, 4); // Key
		//ignored.put(174, 0); // Sent on login
		//ignored.put(116, 4); //Weird random packet?
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
				opcode = buffer.readByte() /*- player.inrand().nextInt()*/ & 0xFF;
				state = State.SIZE;
				in.markReaderIndex();
			
			case SIZE:
				if (actionRepository[opcode] == null && !ignored.containsKey(opcode)) {
					logger.warn("Unknown action: {}, probable size: {}.", opcode, buffer.get().readableBytes());
					
					size = in.readableBytes();
				} else {
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

				if (!ignored.containsKey(opcode) && actionRepository[opcode] != null) {
					int bufferStart = buffer.get().readerIndex();
					Action a = actionRepository[opcode];

					try {
						a.decode(new RSBuffer(buffer.get().slice(bufferStart, size)), ctx, opcode, size, player);
						player.pendingActions().add(a);
					} catch (Exception e) {
						logger.error(e);
					}

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
	
	public Action[] repository() {
		return actionRepository;
	}

	@Override
	public void setBeanFactory(@NotNull BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	enum State {
		OPCODE,
		SIZE,
		DATA
	}
	
}
