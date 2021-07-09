package io.nozemi.skript;

import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import io.nozemi.runescape.content.npcs.NpcFacingPlayerPolicy;
import io.nozemi.runescape.fs.NpcDefinition;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.command.*;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Bart on 1/6/2017.
 */
public class Script {
	
	private boolean started;
	private boolean interrupted;
	private Object context;
	private WaitReason waitReason;
	private Object waitParam;
	private int lastTick;
	private Object waitReturnVal;
	public Function1<Script, ?> interruptCall;
	private Function1<Script, ?> executedFunction;
	
	public final boolean hasStarted() {
		return this.started;
	}
	
	public final void setStarted(boolean x) {
		this.started = x;
	}
	
	public final boolean interrupted() {
		return this.interrupted;
	}
	
	public final void interrupt() {
		if (interruptCall != null) {
			interruptCall.invoke(this);
		}
		interrupted = true;
	}
	
	
	public final <T> T ctx() {
		return (T) this.context;
	}
	
	public final void onInterrupt(Function1<Script, ?> func) {
		this.interruptCall = func;
	}
	
	public int hashCode() {
		return super.hashCode();
	}
	
	public final Object getContext() {
		return this.context;
	}
	
	public final void setContext(Object x) {
		this.context = x;
	}
	
	public final WaitReason getWaitReason() {
		return this.waitReason;
	}
	
	public final void setWaitReason(WaitReason x) {
		this.waitReason = x;
	}
	
	public final <T> T getWaitParam() {
		return (T) this.waitParam;
	}
	
	public final void setWaitParam(Object x) {
		this.waitParam = x;
	}
	
	public final int getLastTick() {
		return this.lastTick;
	}
	
	public final void setLastTick(int x) {
		this.lastTick = x;
	}
	
	public final Object getWaitReturnVal() {
		return this.waitReturnVal;
	}
	
	public final void setWaitReturnVal(Object x) {
		this.waitReturnVal = x;
	}
	
	public final void setInterruptCall(Function1 x) {
		this.interruptCall = x;
	}
	
	public Script(Object context, WaitReason waitReason, Object waitParam, int lastTick, Object waitReturnVal, Function1 interruptCall, Function1<Script, ?> executedFunction) {
		super();
		this.context = context;
		this.waitReason = waitReason;
		this.waitParam = waitParam;
		this.lastTick = lastTick;
		this.waitReturnVal = waitReturnVal;
		this.executedFunction = executedFunction;
		this.interruptCall = interruptCall;
	}
	
	public final Object component2() {
		return this.context;
	}
	
	public final WaitReason component3() {
		return this.waitReason;
	}
	
	public final Object component4() {
		return this.waitParam;
	}
	
	public final int component5() {
		return this.lastTick;
	}
	
	public final Object component6() {
		return this.waitReturnVal;
	}
	
	public final Function1 component7() {
		return this.interruptCall;
	}
	
	public void setExecutedFunction(Function1<Script, ?> fn) {
		executedFunction = fn;
	}
	
	public Function1<Script, ?> getExecutedFunction() {
		return executedFunction;
	}
	
	// Server-specific functions
	public void message(String msg) {
		((Player) context).message(msg);
	}
	
	public void message(String msg, Object... args) {
		((Player) context).message(msg, args);
	}
	
	public Entity entity() {
		return (Entity) context;
	}
	
	public Player player() {
		return (Player) context;
	}
	
	public Npc npc() {
		return (Npc) context;
	}
	
	public Entity target() {
		WeakReference<Entity> holder = entity().attrib(AttributeKey.TARGET);
		
		if (holder != null)
			return holder.get();
		
		return null;
	}
	
	public Npc targetNpc() {
		return (Npc) entity().<WeakReference<Entity>>attrib(AttributeKey.TARGET).get();
	}
	
}
