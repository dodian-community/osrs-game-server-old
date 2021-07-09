package client;

public class TeleportInterface {

	private static String TITLE;
	private static String[] CATEGORIES;
	private static String[] SUBCATEGORIES;
	private static String[] OPTIONS;

	public static void init(String title, final int n, String[] categories, final int n2, String[] subcategories, String[] options) {
		if (title.isEmpty()) {
			title = TITLE;
		} else {
			TITLE = title;
		}
		if (categories.length == 0) {
			categories = CATEGORIES;
		} else {
			CATEGORIES = categories;
		}
		if (subcategories.length == 0) {
			subcategories = SUBCATEGORIES;
		} else {
			SUBCATEGORIES = subcategories;
		}
		if (options.length == 0) {
			options = OPTIONS;
		} else {
			OPTIONS = options;
		}

		Widget.get(583, 14).componentString = title;
		for (int i = 17; i <= 63; ++i) {
			Widget.get(583, i).hidden = true;
		}
		final Widget a = Widget.get(583, 16);
		a.x = 23;
		a.y = 58;
		a.width = 469;
		a.height = 260;
		a.scrollWidth = 0;
		a.scrollHeight = 0;
		int n3 = 18;
		final Widget b = b(n3++);
		b.decodeCs2 = true;
		b.x = 0;
		b.y = 0;
		b.width = 154;
		b.height = 258;
		b.decodeCs2 = true;
		b.onClickListener = new Object[] { 991, -2147483645, -1 };
		final Widget b2 = b(n3++);
		b2.parentHash = b.interfaceHash;
		b2.decodeCs2 = true;
		b2.yAlignment = 1;
		b2.widthAlignment = 1;
		b2.heightAlignment = 1;
		b2.x = 4;
		b2.width = 24;
		b2.height = 8;
		final Widget b3 = b(n3++);
		b3.parentHash = b.interfaceHash;
		b3.decodeCs2 = true;
		b3.xAlignment = 2;
		b3.yAlignment = 1;
		b3.heightAlignment = 1;
		b3.x = 4;
		b3.width = 16;
		b3.height = 8;
		final Widget b4 = b(n3++);
		b4.decodeCs2 = true;
		b4.x = 0;
		b4.y = 175;
		b4.width = 154;
		b4.height = 83;
		b4.decodeCs2 = true;
		b4.onClickListener = new Object[] { 991, -2147483645, -1 };
		final Widget b5 = b(n3++);
		b5.parentHash = b4.interfaceHash;
		b5.decodeCs2 = true;
		b5.yAlignment = 1;
		b5.widthAlignment = 1;
		b5.heightAlignment = 1;
		b5.x = 4;
		b5.width = 24;
		b5.height = 8;
		final Widget b6 = b(n3++);
		b6.parentHash = b4.interfaceHash;
		b6.decodeCs2 = true;
		b6.xAlignment = 2;
		b6.yAlignment = 1;
		b6.heightAlignment = 1;
		b6.x = 4;
		b6.width = 16;
		b6.height = 8;
		a(b5, subcategories, n2);
		scrollBar(b5, b6, subcategories.length * 25);
		b.height = 172;
		a(b2, categories, n);
		scrollBar(b2, b3, categories.length * 25);
		boolean b7 = false;
		boolean b8 = false;
		boolean b9 = false;
		for (final String option : options) {
			if (option.contains("<img=64>")) {
				b7 = true;
			}
			if (option.contains("<img=65>")) {
				b8 = true;
			}
			if (option.contains("<img=14>")) {
				b9 = true;
			}
		}
		int n4 = 0;
		if (b7) {
			final Widget b10 = b(n3++);
			b10.decodeCs2 = true;
			b10.widgetType = 4;
			b10.x = 157;
			b10.y = n4 * 15 + 5;
			b10.width = 310;
			b10.height = 20;
			b10.fontId = 494;
			b10.componentString = "<img=64> Teleport costs blood money to use.";
			b10.fontShadow = true;
			b10.color = 16777215;
			++n4;
		}
		if (b8) {
			final Widget b11 = b(n3++);
			b11.decodeCs2 = true;
			b11.widgetType = 4;
			b11.x = 157;
			b11.y = n4 * 15 + 5;
			b11.width = 310;
			b11.height = 20;
			b11.fontId = 494;
			b11.componentString = "<img=65> Teleport destination is in the wilderness.";
			b11.fontShadow = true;
			b11.color = 16777215;
			++n4;
		}
		if (b9) {
			final Widget b12 = b(n3++);
			b12.decodeCs2 = true;
			b12.widgetType = 4;
			b12.x = 157;
			b12.y = n4 * 15 + 5;
			b12.width = 310;
			b12.height = 20;
			b12.fontId = 494;
			b12.componentString = "<img=14> Teleport destination is a multi combat zone.";
			b12.fontShadow = true;
			b12.color = 16777215;
			++n4;
		}
		final Widget b13 = b(n3++);
		b13.decodeCs2 = true;
		b13.x = 157;
		b13.width = 310;
		if (n4 == 0) {
			b13.y = 0;
			b13.height = 241;
		} else {
			b13.y = n4 * 15 + 5;
			b13.height = 241 - (n4 * 15 + 5);
		}
		b13.decodeCs2 = true;
		b13.onClickListener = new Object[] { 991, -2147483645, -1 };
		final Widget b14 = b(63);
		b14.parentHash = b13.interfaceHash;
		b14.decodeCs2 = true;
		b14.yAlignment = 1;
		b14.widthAlignment = 1;
		b14.heightAlignment = 1;
		b14.x = 4;
		b14.width = 24;
		b14.height = 8;
		final Widget b15 = b(n3++);
		b15.parentHash = b13.interfaceHash;
		b15.decodeCs2 = true;
		b15.xAlignment = 2;
		b15.yAlignment = 1;
		b15.heightAlignment = 1;
		b15.x = 4;
		b15.width = 16;
		b15.height = 8;
		a(b14, options, -1);
		scrollBar(b14, b15, options.length * 25);
	}

	private static void a(final Widget em, final String[] array, final int n) {
		int n2 = 0;
		for (int i = 0; i < array.length; ++i) {
			final Widget b = Custom.addChild(em.interfaceHash, 3, n2);
			b.decodeCs2 = true;
			b.x = 0;
			b.y = n2 * 25;
			b.widthAlignment = 1;
			b.height = 25;
			b.filled = true;
			b.string29 = "<col=ff9040>" + array[i].split("\\|")[0] + "</col>";
			b.setOption(0, (n == -1) ? "Teleport" : "Select");
			if (i == n) {
				b.alpha = 125;
				b.mouseEnteredScript = new Object[] { 1015, -2147483645, -2147483643, 0, 80 };
				b.mouseLeftScript = new Object[] { 1015, -2147483645, -2147483643, 0, 125 };
			} else if ((n2 + 1) % 2 != 0) {
				b.alpha = 255;
				b.mouseEnteredScript = new Object[] { 1015, -2147483645, -2147483643, n == -1 ? 0x743BA9 : 0xB03A2E, 0 };
				b.mouseLeftScript = new Object[] { 1015, -2147483645, -2147483643, 16777215, 255 };
			} else {
				b.alpha = 225;
				b.mouseEnteredScript = new Object[] { 1015, -2147483645, -2147483643, n == -1 ? 0x743BA9 : 0xB03A2E, 0 };
				b.mouseLeftScript = new Object[] { 1015, -2147483645, -2147483643, 0, 225 };
			}
			b.decodeCs2 = true;
			++n2;
		}
		if (n == -1) {
			for (int j = 0; j < array.length; ++j) {
				final String[] split = array[j].split("\\|");
				final Widget b2 = Custom.addChild(em.interfaceHash, 4, n2++);
				b2.x = 3;
				b2.y = j * 25;
				b2.width = 277;
				b2.height = 25;
				b2.fontId = 495;
				b2.componentString = split[0];
				b2.fontVerticalAlignment = 1;
				b2.fontHorizontalAlignment = 0;
				b2.fontShadow = true;
				b2.color = 16758847;
				if (split.length > 2) {
					final Widget b3 = Custom.addChild(em.interfaceHash, 4, n2++);
					b3.x = 3;
					b3.y = j * 25;
					b3.width = 277;
					b3.height = 25;
					b3.fontId = 494;
					b3.componentString = split[1];
					b3.fontVerticalAlignment = 1;
					b3.fontHorizontalAlignment = 1;
					b3.fontShadow = true;
					b3.color = 16758847;
					final Widget b4 = Custom.addChild(em.interfaceHash, 4, n2++);
					b4.x = 3;
					b4.y = j * 25;
					b4.width = 277;
					b4.height = 25;
					b4.fontId = 494;
					b4.componentString = split[2];
					b4.fontVerticalAlignment = 1;
					b4.fontHorizontalAlignment = 2;
					b4.fontShadow = true;
					b4.color = 16758847;
				} else if (split.length > 1) {
					final Widget b5 = Custom.addChild(em.interfaceHash, 4, n2++);
					b5.x = 3;
					b5.y = j * 25;
					b5.width = 277;
					b5.height = 25;
					b5.fontId = 494;
					b5.componentString = split[1];
					b5.fontVerticalAlignment = 1;
					b5.fontHorizontalAlignment = 2;
					b5.fontShadow = true;
					b5.color = 16758847;
				}
			}
		} else {
			for (int k = 0; k < array.length; ++k) {
				final Widget b6 = Custom.addChild(em.interfaceHash, 4, n2++);
				b6.x = 3;
				b6.y = k * 25;
				b6.width = 121;
				b6.height = 25;
				b6.fontId = 496;
				b6.componentString = array[k];
				b6.fontVerticalAlignment = 1;
				b6.fontHorizontalAlignment = 1;
				b6.fontShadow = true;
				b6.color = 16758847;
			}
		}
		InterfaceEdits.unlock(em.interfaceHash, 0, n2, 0);
	}

	private static void scrollBar(final Widget list, final Widget parent, final int height) {
		list.scrollY = 0;
		list.scrollHeight = height;
		GameClient.requestRedraw(list);
		ScriptInvocation var82 = new ScriptInvocation();
		var82.parameters = new Object[] { 31, parent.interfaceHash, list.interfaceHash, 792, 789, 790, 791, 773, 788 };
		class68.method1696(var82);
	}

	private static Widget b(final int n) {
		final Widget a = Widget.get(583, n);
		final Widget em = new Widget();
		em.parentHash = a.parentHash;
		em.interfaceHash = a.interfaceHash;
		return Widget.LOADED[583][n] = em;
	}
}
