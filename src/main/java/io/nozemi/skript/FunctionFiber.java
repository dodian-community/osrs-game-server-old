package io.nozemi.skript;

/**
 * Created by Bart on 1/7/2017.
 */
public class FunctionFiber extends Fiber<Object> {
	
	private Script script;
	
	public FunctionFiber(Script script) {
		this.script = script;
	}

	public final Object run() {
		script.getExecutedFunction().invoke(script);
		return null;
	}

	public void start() {

	}
}
