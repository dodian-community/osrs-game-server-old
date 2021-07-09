package io.nozemi.runescape.util;

/**
 * Created by Bart on 8/11/2015.
 */
public class SettingsBuilder {

	private int parentWidget;
	private int childWidget;
	private int value;
	
	public SettingsBuilder option(int opt) {
		value |= 1 << opt + 1;
		return this;
	}

	/**
	 * Defines if an item is able to be dragged on the target widget.
	 * @param enable
	 * @return
	 */
	public SettingsBuilder dragItem(boolean enable) {
		if (enable) {
			this.value |= 1 << 21;
		} else {
			this.value &= ~(1 << 21);
		}
		return this;
	}
	
	public int build() {
		return value;
	}
	
}
