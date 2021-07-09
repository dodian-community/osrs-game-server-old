package client;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ShopInterface {

	public static int[][] ITEMS;
	private static final String[] OPTIONS = new String[] { "Value", "Buy-1", "Buy-5", "Buy-10", "Buy-50", "Buy-X" };;
	private static final TreeMap<Long, String> a = new TreeMap<Long, String>();

	static {
		a.put(1000L, "k");
		a.put(1000000L, "M");
	}

	public static void init(final String title, final int[][] items) {
		Widget.get(100, 1).cs2Triggers[2] = title;
		InterfaceEdits.unlock(6553603, -1, items.length, 0, 1, 2, 3, 4, 5, 9);
		ShopInterface.ITEMS = items;
		final Widget b = Custom.addChild(6553602, 4, 0);
		b.decodeCs2 = true;
		b.y = -5;
		b.int447 = -5;
		b.width = 438;
		b.int472 = 438;
		b.height = 25;
		b.int466 = 25;
		b.fontHorizontalAlignment = 1;
		b.fontId = 494;
		b.componentString = "";
		b.fontVerticalAlignment = 1;
		b.fontShadow = true;
		b.color = 16777215;
	}

	public static void e(final Widget em) {
		if (ITEMS == null || em.interfaceHash >> 16 != 100) {
			return;
		}
		final Widget a = Widget.get(100, 3);
		final ArrayList<Widget> list = new ArrayList<>();
		int n = 0;
		for (final Widget em2 : a.children) {
			if (em2.widgetType != 4) {
				em2.childId = n++;
				list.add(em2);
			}
		}
		a.children = list.toArray(new Widget[0]);
		int length2 = a.children.length;
		int n2 = 0;
		int n3 = 0;
		for (final Widget em3 : a.children) {
			if (em3.itemId != -1 && !em3.hidden) {
				final ItemDef a2 = ItemDef.loadItemDef(em3.itemId);
				if (a2.int641 != -1 && a2.int638 != -1) {
					em.alpha = 120;
				}
				if(em3.childId >= ITEMS.length)
					return;
				final Widget b3 = Custom.addChild(a.interfaceHash, 4, length2++);
				b3.decodeCs2 = true;
				b3.widgetType = 4;
				b3.x = em3.x;
				b3.y = em3.y + 4;
				b3.width = em3.width;
				b3.height = em3.height;
				b3.fontId = 494;
				final int n4 = ITEMS[em3.childId][1];
				if (n4 == 0) {
					++n2;
					b3.componentString = "";
				}
				else {
					++n3;
					b3.componentString = "<col=ffff00>" + format(n4);
				}
				b3.fontShadow = true;
				b3.fontHorizontalAlignment = 2;
				b3.fontVerticalAlignment  = 2;
				b3.color = 16777215;
				GameClient.requestRedraw(b3);
				Stream.client.method506(b3);
			}
		}
		a.y += 20;
		a.height += 20;
		a.scrollHeight += 10;
		final Widget a3 = Widget.get(100, 2);
		if (a3 == null || a3.children == null) {
			return;
		}
		final Widget em7 = a3.children[0];
		if (em7 == null) {
			return;
		}
		if (n2 > 0) {
			if (n3 > 0) {
				em7.componentString = "Prices are displayed at the bottom right of each item. Items without a price are <col=4dff4d>free</col>!";
			}
			else {
				em7.componentString = "All items in this shop are <col=4dff4d>free</col>!";
			}
			return;
		}
		em7.componentString = "Prices are displayed at the bottom right of each item.";
	}

	public static void updateItem(final Widget widget) {
		if (ITEMS == null || widget.interfaceHash >> 16 != 100) {
			return;
		}
		for (int i = 0; i < OPTIONS.length; ++i) {
			//   final String s = OPTIONS[i];
			//   Widget.get(i, s.isEmpty() ? null : s);
		}
	}

	static String format(final long n) {
		if (n == Long.MIN_VALUE) {
			return format(-9223372036854775807L);
		}
		if (n < 0L) {
			return "-" + format(-n);
		}
		if (n < 1000L) {
			return Long.toString(n);
		}
		final Map.Entry<Long, String> floorEntry = ShopInterface.a.floorEntry(n);
		final Long n2 = floorEntry.getKey();
		final String s = floorEntry.getValue();
		final long n3 = n / (n2 / 10L);
		return (n3 < 100L && n3 / 10.0 != n3 / 10L) ? (n3 / 10.0 + s) : (n3 / 10L + s);
	}

	static {

	}
}
