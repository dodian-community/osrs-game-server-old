package io.nozemi.runescape.events;

/**
 * Created by Bart on 1/7/2017.
 */
public class FunctionFiber {
	
	private Script script;
	
	public FunctionFiber(Script script) {
		this.script = script;
	}

	public final Object run() {
		script.getExecutedFunction().invoke(script);
		return null;
	}
	
}
