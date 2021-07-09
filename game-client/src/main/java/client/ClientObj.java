package client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientObj {

	private static final Map<Integer, List<ClientObj>> REMOVE_MAP = new HashMap<Integer, List<ClientObj>>(), SPAWN_MAP = new HashMap<Integer, List<ClientObj>>();

	private int id;
	private int x, y, z;
	private int type, direction;

	private void remove() {
		toMap(REMOVE_MAP);
	}

	private void spawn() {
		toMap(SPAWN_MAP);
	}

	private void toMap(Map<Integer, List<ClientObj>> map) {
		int hash = y + (x << 14) + (z << 28);
		List<ClientObj> objs = map.get(hash);
		if (objs == null) map.put(hash, objs = new ArrayList<ClientObj>());
		objs.add(this);
	}


	private static ClientObj obj(int id, int x, int y, int z, int type, int direction) {
		ClientObj obj = new ClientObj();
		obj.id = id;
		obj.x = x;
		obj.y = y;
		obj.z = z;
		obj.type = type;
		obj.direction = direction;
		return obj;
	}

	public static boolean isRemoved(int id, int localX, int localY, int z, int type, int direction) {
		int x = class62.baseX + localX;
		int y = GameClient.baseY + localY;
		int hash = y + (x << 14) + (z << 28);

		List<ClientObj> objs = REMOVE_MAP.get(hash);
		if (objs != null) {
			for (ClientObj obj : objs) {
				if (obj.id != id || obj.x != x || obj.y != y || obj.type != type || obj.direction != direction)
					continue;

				return true;
			}
		}
		return false;
	}

	public static void spawn(int localX, int localY, int z) {
		int x = class62.baseX + localX;
		int y = GameClient.baseY + localY;
		int hash = y + (x << 14) + (z << 28);
		List<ClientObj> objs = SPAWN_MAP.get(hash);
		if (objs != null) {
			for (ClientObj obj : objs) {
				class171.method3450(z, localX, localY, obj.id, obj.direction, obj.type, class28.field248, GameClient.field642[z]);
			}
		}
	}

	/**
	 * Remove (Make sure server code matches this!)
	 */

	static {
		//edgeville misc
		obj(29005, 3077, 3503, 0, 10, 2).remove(); //ugly clue bush
		obj(884, 3084, 3502, 0, 10, 1).remove(); //well
		obj(2771, 3084, 3502, 0, 22, 0).remove(); //well water icon
		obj(1276, 3076, 3516, 0, 11, 0).remove(); //annoying tree lol
		obj(1276, 3082, 3516, 0, 11, 0).remove(); //annoying tree lol
		obj(1278, 3090, 3516, 0, 11, 0).remove(); //annoying tree lol
		obj(1276, 3097, 3516, 0, 10, 0).remove(); //annoying tree lol
		obj(1276, 3103, 3511, 0, 11, 0).remove(); //annoying tree lol
		obj(1276, 3090, 3503, 0, 10, 0).remove(); //annoying tree lol
		obj(27269, 3095, 3502, 0, 0, 1).remove(); //no idea what this even is
		obj(673, 3096, 3504, 0, 22, 0).remove(); //emblem trader icon
		obj(23590, 3121, 3517, 0, 22, 0).remove(); //east achievements icon
		obj(307, 3088, 3509, 0, 10, 0).remove(); //cart
		//edgeville general store
		obj(1823, 3075, 3508, 0, 5, 2).remove();
		obj(1259, 3075, 3509, 0, 22, 0).remove();
		obj(1258, 3075, 3510, 0, 22, 3).remove();
		obj(196, 3076, 3507, 0, 7, 1).remove();
		obj(1823, 3076, 3508, 0, 4, 0).remove();
		obj(1017, 3076, 3509, 0, 10, 0).remove();
		obj(1016, 3076, 3510, 0, 10, 0).remove();
		obj(1015, 3076, 3511, 0, 10, 0).remove();
		obj(1016, 3076, 3512, 0, 10, 0).remove();
		obj(196, 3076, 3513, 0, 7, 2).remove();
		obj(381, 3077, 3507, 0, 10, 3).remove();
		obj(917, 3077, 3511, 0, 22, 3).remove();
		obj(917, 3077, 3512, 0, 22, 0).remove();
		obj(17390, 3077, 3512, 0, 10, 1).remove();
		obj(1018, 3077, 3513, 0, 10, 1).remove();
		obj(1823, 3078, 3506, 0, 5, 1).remove();
		obj(1823, 3078, 3507, 0, 4, 3).remove();
		obj(595, 3078, 3510, 0, 10, 0).remove();
		obj(918, 3078, 3511, 0, 22, 2).remove();
		obj(918, 3078, 3512, 0, 22, 0).remove();
		obj(1017, 3078, 3513, 0, 10, 1).remove();
		obj(205, 3079, 3506, 0, 5, 1).remove();
		obj(381, 3079, 3507, 0, 10, 3).remove();
		obj(918, 3079, 3511, 0, 22, 2).remove();
		obj(918, 3079, 3512, 0, 22, 0).remove();
		obj(1018, 3079, 3513, 0, 10, 1).remove();
		obj(1259, 3079, 3514, 0, 22, 3).remove();
		obj(916, 3080, 3507, 0, 22, 2).remove();
		obj(1536, 3080, 3507, 0, 0, 2).remove();
		obj(2733, 3080, 3509, 0, 22, 0).remove();
		obj(356, 3080, 3510, 0, 10, 0).remove();
		obj(918, 3080, 3511, 0, 22, 2).remove();
		obj(918, 3080, 3512, 0, 22, 0).remove();
		obj(1016, 3080, 3513, 0, 10, 1).remove();
		obj(1258, 3080, 3514, 0, 22, 0).remove();
		obj(196, 3081, 3507, 0, 4, 3).remove();
		obj(595, 3081, 3510, 0, 10, 0).remove();
		obj(918, 3081, 3511, 0, 22, 2).remove();
		obj(918, 3081, 3512, 0, 22, 0).remove();
		obj(887, 3081, 3513, 0, 4, 1).remove();
		obj(1259, 3081, 3514, 0, 22, 0).remove();
		obj(1258, 3082, 3506, 0, 22, 2).remove();
		obj(1823, 3082, 3506, 0, 5, 1).remove();
		obj(1823, 3082, 3507, 0, 4, 3).remove();
		obj(918, 3082, 3511, 0, 22, 2).remove();
		obj(918, 3082, 3512, 0, 22, 0).remove();
		obj(196, 3082, 3513, 0, 4, 1).remove();
		obj(1258, 3083, 3506, 0, 22, 1).remove();
		obj(374, 3083, 3507, 0, 10, 2).remove();
		obj(917, 3083, 3511, 0, 22, 2).remove();
		obj(917, 3083, 3512, 0, 22, 1).remove();
		obj(16683, 3083, 3513, 0, 10, 2).remove();
		obj(196, 3084, 3507, 0, 7, 0).remove();
		obj(1823, 3084, 3508, 0, 4, 2).remove();
		obj(358, 3084, 3509, 0, 10, 2).remove();
		obj(887, 3084, 3509, 0, 4, 2).remove();
		obj(358, 3084, 3510, 0, 10, 2).remove();
		obj(1023, 3084, 3510, 0, 4, 2).remove();
		obj(1023, 3084, 3511, 0, 4, 2).remove();
		obj(357, 3084, 3512, 0, 10, 1).remove();
		obj(1023, 3084, 3512, 0, 4, 2).remove();
		obj(196, 3084, 3513, 0, 7, 3).remove();
		obj(1823, 3085, 3508, 0, 5, 0).remove();
		obj(1258, 3085, 3509, 0, 22, 1).remove();
		obj(1259, 3085, 3510, 0, 22, 0).remove();
		obj(1258, 3085, 3511, 0, 22, 2).remove();

		//edgeville general store (custom wall removals)
		obj(1902, 3085, 3509, 0, 0, 0).remove();
		obj(1902, 3085, 3510, 0, 0, 0).remove();
		obj(1902, 3085, 3511, 0, 0, 0).remove();

		//edgeville house north of bank
		obj(1838, 3090, 3508, 0, 5, 2).remove();
		obj(1838, 3090, 3512, 0, 5, 2).remove();
		obj(362, 3091, 3507, 0, 10, 2).remove();
		obj(362, 3091, 3508, 0, 10, 3).remove();
		obj(1838, 3091, 3508, 0, 4, 0).remove();
		obj(298, 3091, 3510, 0, 10, 1).remove();
		obj(1838, 3091, 3512, 0, 4, 0).remove();
		obj(362, 3091, 3513, 0, 10, 3).remove();
		obj(1258, 3091, 3514, 0, 22, 3).remove();
		obj(1844, 3092, 3506, 0, 5, 1).remove();
		obj(1844, 3092, 3507, 0, 4, 3).remove();
		obj(362, 3092, 3513, 0, 10, 0).remove();
		obj(1838, 3092, 3513, 0, 4, 1).remove();
		obj(1838, 3092, 3514, 0, 5, 3).remove();
		obj(296, 3093, 3507, 0, 10, 2).remove();
		obj(300, 3093, 3509, 0, 10, 1).remove();
		obj(1016, 3093, 3513, 0, 10, 1).remove();
		obj(1258, 3094, 3506, 0, 22, 1).remove();
		obj(1263, 3094, 3511, 0, 22, 3).remove();
		obj(299, 3094, 3513, 0, 10, 0).remove();
		obj(1258, 3094, 3514, 0, 22, 0).remove();
		obj(1259, 3095, 3506, 0, 22, 2).remove();
		obj(1262, 3095, 3510, 0, 22, 0).remove();
		obj(1258, 3095, 3514, 0, 22, 0).remove();
		obj(1259, 3096, 3506, 0, 22, 1).remove();
		obj(1017, 3096, 3507, 0, 10, 3).remove();
		obj(16683, 3096, 3511, 0, 10, 3).remove();
		obj(1015, 3096, 3513, 0, 10, 1).remove();
		obj(1258, 3097, 3506, 0, 22, 3).remove();
		obj(1018, 3097, 3507, 0, 10, 3).remove();
		obj(1263, 3097, 3510, 0, 22, 0).remove();
		obj(1016, 3097, 3513, 0, 10, 1).remove();
		obj(1262, 3097, 3513, 0, 22, 1).remove();
		obj(1258, 3098, 3506, 0, 22, 2).remove();
		obj(1016, 3098, 3507, 0, 10, 3).remove();
		obj(1262, 3098, 3508, 0, 22, 1).remove();
		obj(356, 3098, 3513, 0, 10, 3).remove();
		obj(1259, 3099, 3506, 0, 22, 1).remove();
		obj(1838, 3099, 3506, 0, 5, 1).remove();
		obj(356, 3099, 3507, 0, 10, 0).remove();
		obj(1838, 3099, 3507, 0, 4, 3).remove();
		obj(1262, 3099, 3511, 0, 22, 2).remove();
		obj(357, 3099, 3512, 0, 10, 2).remove();
		obj(357, 3099, 3513, 0, 10, 3).remove();
		obj(1844, 3099, 3513, 0, 4, 1).remove();
		obj(1844, 3099, 3514, 0, 5, 3).remove();
		obj(1259, 3100, 3506, 0, 22, 2).remove();
		obj(358, 3100, 3507, 0, 10, 3).remove();
		obj(356, 3100, 3508, 0, 10, 3).remove();
		obj(1838, 3100, 3508, 0, 4, 2).remove();
		obj(357, 3100, 3512, 0, 10, 1).remove();
		obj(1838, 3100, 3512, 0, 4, 2).remove();
		obj(358, 3100, 3513, 0, 10, 3).remove();
		obj(1259, 3101, 3506, 0, 22, 1).remove();
		obj(1259, 3101, 3507, 0, 22, 0).remove();
		obj(1838, 3101, 3508, 0, 5, 0).remove();
		obj(1521, 3101, 3509, 0, 0, 0).remove();
		obj(1524, 3101, 3510, 0, 0, 0).remove();
		obj(205, 3101, 3511, 0, 5, 0).remove();
		obj(1259, 3101, 3511, 0, 22, 0).remove();
		obj(1259, 3101, 3512, 0, 22, 3).remove();
		obj(1838, 3101, 3512, 0, 5, 0).remove();
		obj(1258, 3101, 3513, 0, 22, 1).remove();

		//edgeville house north of bank (custom wall removals)
		obj(1902, 3090, 3511, 0, 0, 2).remove();
		obj(1902, 3090, 3510, 0, 0, 2).remove();
		obj(1902, 3090, 3509, 0, 0, 2).remove();

		obj(1902, 3094, 3506, 0, 0, 1).remove();
		obj(1902, 3095, 3506, 0, 0, 1).remove();
		obj(1902, 3096, 3506, 0, 0, 1).remove();
		obj(1902, 3097, 3506, 0, 0, 1).remove();

		obj(1902, 3094, 3514, 0, 0, 3).remove();
		obj(1902, 3095, 3514, 0, 0, 3).remove();
		obj(1902, 3096, 3514, 0, 0, 3).remove();
		obj(1902, 3097, 3514, 0, 0, 3).remove();

		//New edgeville house
		obj(1257, 3111, 3495, 0, 22, 2).remove();
		obj(1259, 3106, 3495, 0, 22, 1).remove();
		obj(1259, 3107, 3495, 0, 22, 1).remove();
		obj(1259, 3109, 3495, 0, 22, 1).remove();
		obj(1259, 3111, 3496, 0, 22, 0).remove();
		obj(1259, 3111, 3498, 0, 22, 0).remove();
		obj(1299, 3111, 3500, 0, 10, 2).remove();
		obj(2275, 3105, 3500, 0, 22, 2).remove();
		obj(2275, 3105, 3501, 0, 22, 2).remove();
		obj(2275, 3106, 3500, 0, 22, 2).remove();
		obj(2275, 3108, 3498, 0, 22, 2).remove();
		obj(2275, 3108, 3499, 0, 22, 2).remove();
		obj(2275, 3109, 3498, 0, 22, 2).remove();
		obj(2276, 3108, 3497, 0, 22, 2).remove();
		obj(2276, 3109, 3497, 0, 22, 2).remove();
		obj(2277, 3105, 3496, 0, 22, 2).remove();
		obj(2277, 3107, 3499, 0, 22, 2).remove();
		obj(2277, 3108, 3500, 0, 22, 2).remove();
		obj(2277, 3109, 3501, 0, 22, 2).remove();
		obj(2278, 3105, 3498, 0, 22, 2).remove();
		obj(2278, 3106, 3497, 0, 22, 2).remove();
		obj(2278, 3106, 3499, 0, 22, 2).remove();
		obj(2742, 3109, 3499, 0, 22, 1).remove();
		obj(5098, 3110, 3499, 1, 10, 0).remove();
		obj(6809, 3106, 3496, 0, 22, 2).remove();
		obj(12707, 3106, 3497, 1, 22, 0).remove();
		obj(12707, 3106, 3500, 1, 22, 1).remove();
		obj(12707, 3107, 3499, 1, 22, 3).remove();
		obj(12707, 3109, 3497, 1, 22, 3).remove();
		obj(12707, 3109, 3500, 1, 22, 2).remove();
		obj(12708, 3107, 3498, 1, 22, 3).remove();
		obj(12708, 3108, 3499, 1, 22, 3).remove();
		obj(12708, 3109, 3498, 1, 22, 0).remove();
		obj(16469, 3110, 3499, 0, 10, 2).remove();
		obj(16470, 3108, 3496, 0, 10, 2).remove();
		obj(16471, 3110, 3500, 0, 10, 1).remove();
		obj(16472, 3105, 3496, 0, 10, 2).remove();
		obj(16473, 3106, 3498, 0, 10, 2).remove();
		obj(16473, 3106, 3501, 0, 10, 3).remove();
		obj(16473, 3107, 3496, 0, 10, 2).remove();
		obj(16474, 3105, 3501, 0, 10, 2).remove();
		obj(16474, 3109, 3500, 0, 10, 2).remove();
		obj(16474, 3110, 3496, 0, 11, 3).remove();
		obj(16475, 3110, 3498, 0, 10, 2).remove();
		obj(16476, 3109, 3496, 0, 5, 3).remove();
		obj(16512, 3110, 3497, 0, 5, 2).remove();
		obj(23748, 3105, 3496, 0, 2, 3).remove();
		obj(23748, 3105, 3497, 0, 0, 0).remove();
		obj(23748, 3105, 3501, 0, 2, 0).remove();
		obj(23748, 3106, 3496, 0, 0, 3).remove();
		obj(23748, 3106, 3501, 0, 0, 1).remove();
		obj(23748, 3107, 3496, 0, 0, 3).remove();
		obj(23748, 3108, 3496, 0, 0, 3).remove();
		obj(23748, 3109, 3496, 0, 0, 3).remove();
		obj(23748, 3110, 3496, 0, 2, 2).remove();
		obj(23748, 3110, 3497, 0, 0, 2).remove();
		obj(23748, 3110, 3498, 0, 0, 2).remove();
		obj(23748, 3110, 3499, 0, 0, 2).remove();
		obj(23748, 3110, 3500, 0, 0, 2).remove();
		obj(23748, 3110, 3501, 0, 2, 1).remove();
		obj(23750, 3105, 3500, 0, 0, 0).remove();
		obj(23750, 3109, 3501, 0, 0, 1).remove();
		obj(23751, 3105, 3498, 0, 0, 0).remove();
		obj(23751, 3107, 3501, 0, 0, 1).remove();
		obj(23752, 3105, 3499, 0, 0, 0).remove();
		obj(23752, 3108, 3501, 0, 0, 1).remove();
		obj(23753, 3105, 3496, 1, 2, 3).remove();
		obj(23753, 3105, 3497, 1, 0, 0).remove();
		obj(23753, 3105, 3498, 1, 0, 0).remove();
		obj(23753, 3105, 3499, 1, 0, 0).remove();
		obj(23753, 3105, 3500, 1, 0, 0).remove();
		obj(23753, 3105, 3501, 1, 2, 0).remove();
		obj(23753, 3106, 3496, 1, 0, 3).remove();
		obj(23753, 3106, 3501, 1, 0, 1).remove();
		obj(23753, 3107, 3496, 1, 0, 3).remove();
		obj(23753, 3107, 3501, 1, 0, 1).remove();
		obj(23753, 3108, 3496, 1, 0, 3).remove();
		obj(23753, 3108, 3501, 1, 0, 1).remove();
		obj(23753, 3109, 3496, 1, 0, 3).remove();
		obj(23753, 3109, 3501, 1, 0, 1).remove();
		obj(23753, 3110, 3496, 1, 2, 2).remove();
		obj(23753, 3110, 3497, 1, 0, 2).remove();
		obj(23753, 3110, 3498, 1, 0, 2).remove();
		obj(23753, 3110, 3499, 1, 0, 2).remove();
		obj(23753, 3110, 3500, 1, 0, 2).remove();
		obj(23753, 3110, 3501, 1, 2, 1).remove();

		//edgeville house west of bank (misc)
		obj(1558, 3080, 3501, 0, 0, 3).remove(); //gate
		obj(1560, 3079, 3501, 0, 0, 3).remove(); //gate
		obj(2772, 3077, 3496, 0, 22, 0).remove(); //cooking icon
		obj(2771, 3077, 3489, 0, 22, 0).remove(); //sink water icon

		//edgeville house west of bank (grass)
		obj(9489, 3076, 3492, 0, 22, 2).remove();
		obj(9489, 3082, 3492, 0, 22, 0).remove();
		obj(9489, 3082, 3494, 0, 22, 0).remove();
		obj(9489, 3077, 3497, 0, 22, 3).remove();
		obj(9488, 3081, 3500, 0, 22, 2).remove();
		obj(9487, 3081, 3499, 0, 22, 2).remove();
		obj(9487, 3077, 3499, 0, 22, 2).remove();
		obj(9487, 3078, 3500, 0, 22, 1).remove();
		obj(9488, 3077, 3500, 0, 22, 3).remove();
		obj(9485, 3078, 3499, 0, 22, 0).remove();
		obj(9491, 3082, 3488, 0, 22, 2).remove();
		obj(9492, 3082, 3487, 0, 22, 3).remove();
		obj(9488, 3076, 3488, 0, 22, 3).remove();
		obj(9488, 3076, 3487, 0, 22, 0).remove();
		obj(9489, 3080, 3497, 0, 22, 3).remove();
		obj(9485, 3077, 3498, 0, 22, 3).remove();
		obj(9485, 3081, 3498, 0, 22, 1).remove();
		obj(9491, 3081, 3487, 0, 22, 3).remove();

		//edgeville house west of bank (1st floor)
		obj(12278, 3076, 3488, 0, 3, 1).remove();
		obj(12278, 3076, 3489, 0, 0, 2).remove();
		obj(12278, 3076, 3490, 0, 0, 2).remove();
		obj(12278, 3076, 3491, 0, 0, 2).remove();
		obj(12278, 3076, 3492, 0, 0, 2).remove();
		obj(12278, 3076, 3493, 0, 0, 2).remove();
		obj(12278, 3076, 3494, 0, 0, 2).remove();
		obj(1838, 3076, 3495, 0, 5, 2).remove();
		obj(12278, 3076, 3495, 0, 0, 2).remove();
		obj(12278, 3076, 3496, 0, 0, 2).remove();
		obj(12278, 3076, 3497, 0, 3, 2).remove();
		obj(12278, 3077, 3488, 0, 0, 1).remove();
		obj(12279, 3077, 3489, 0, 10, 2).remove();
		obj(12291, 3077, 3491, 0, 4, 0).remove();
		obj(12266, 3077, 3493, 0, 22, 3).remove();
		obj(1838, 3077, 3495, 0, 4, 0).remove();
		obj(12269, 3077, 3495, 0, 10, 0).remove();
		obj(12278, 3077, 3497, 0, 0, 3).remove();
		obj(12278, 3078, 3488, 0, 0, 1).remove();
		obj(5610, 3078, 3489, 0, 10, 0).remove();
		obj(12292, 3078, 3489, 0, 4, 3).remove();
		obj(917, 3078, 3491, 0, 22, 3).remove();
		obj(918, 3078, 3492, 0, 22, 3).remove();
		obj(918, 3078, 3493, 0, 22, 3).remove();
		obj(917, 3078, 3494, 0, 22, 0).remove();
		obj(1838, 3078, 3496, 0, 4, 1).remove();
		obj(1838, 3078, 3497, 0, 5, 3).remove();
		obj(12278, 3078, 3497, 0, 0, 3).remove();
		obj(1838, 3079, 3488, 0, 5, 1).remove();
		obj(12278, 3079, 3488, 0, 0, 1).remove();
		obj(1838, 3079, 3489, 0, 4, 3).remove();
		obj(917, 3079, 3491, 0, 22, 2).remove();
		obj(918, 3079, 3492, 0, 22, 1).remove();
		obj(918, 3079, 3493, 0, 22, 1).remove();
		obj(917, 3079, 3494, 0, 22, 1).remove();
		obj(916, 3079, 3496, 0, 22, 0).remove();
		obj(1535, 3079, 3497, 0, 0, 3).remove();
		obj(12278, 3080, 3488, 0, 0, 1).remove();
		obj(5497, 3080, 3489, 0, 10, 1).remove();
		obj(5497, 3080, 3493, 0, 10, 1).remove();
		obj(1838, 3080, 3496, 0, 4, 1).remove();
		obj(1838, 3080, 3497, 0, 5, 3).remove();
		obj(12278, 3080, 3497, 0, 0, 3).remove();
		obj(12278, 3081, 3488, 0, 0, 1).remove();
		obj(12293, 3081, 3490, 0, 10, 1).remove();
		obj(1838, 3081, 3491, 0, 4, 2).remove();
		obj(12281, 3081, 3492, 0, 10, 0).remove();
		obj(12282, 3081, 3494, 0, 10, 2).remove();
		obj(1838, 3081, 3495, 0, 4, 2).remove();
		obj(12278, 3081, 3497, 0, 0, 3).remove();
		obj(12278, 3082, 3488, 0, 3, 0).remove();
		obj(12278, 3082, 3489, 0, 0, 0).remove();
		obj(12278, 3082, 3490, 0, 0, 0).remove();
		obj(1838, 3082, 3491, 0, 5, 0).remove();
		obj(12278, 3082, 3491, 0, 0, 0).remove();
		obj(12278, 3082, 3492, 0, 0, 0).remove();
		obj(12278, 3082, 3493, 0, 0, 0).remove();
		obj(12278, 3082, 3494, 0, 0, 0).remove();
		obj(1838, 3082, 3495, 0, 5, 0).remove();
		obj(12278, 3082, 3495, 0, 0, 0).remove();
		obj(12278, 3082, 3496, 0, 0, 0).remove();
		obj(12278, 3082, 3497, 0, 3, 3).remove();

		//edgeville house west of bank (2nd floor)
		obj(12289, 3076, 3488, 1, 21, 2).remove();
		obj(12287, 3076, 3489, 1, 18, 2).remove();
		obj(12287, 3076, 3490, 1, 18, 2).remove();
		obj(12287, 3076, 3491, 1, 18, 2).remove();
		obj(12287, 3076, 3492, 1, 18, 2).remove();
		obj(12287, 3076, 3493, 1, 18, 2).remove();
		obj(12287, 3076, 3494, 1, 18, 2).remove();
		obj(12287, 3076, 3495, 1, 18, 2).remove();
		obj(12287, 3076, 3496, 1, 18, 2).remove();
		obj(12288, 3076, 3497, 1, 21, 2).remove();
		obj(12285, 3077, 3488, 1, 18, 1).remove();
		obj(12283, 3077, 3489, 1, 12, 2).remove();
		obj(12283, 3077, 3490, 1, 12, 2).remove();
		obj(12283, 3077, 3491, 1, 12, 2).remove();
		obj(12283, 3077, 3492, 1, 12, 2).remove();
		obj(12283, 3077, 3493, 1, 12, 2).remove();
		obj(12283, 3077, 3494, 1, 12, 2).remove();
		obj(12283, 3077, 3495, 1, 12, 2).remove();
		obj(12283, 3077, 3496, 1, 12, 2).remove();
		obj(12283, 3077, 3497, 1, 18, 3).remove();
		obj(12286, 3078, 3488, 1, 18, 1).remove();
		obj(12284, 3078, 3489, 1, 12, 2).remove();
		obj(12284, 3078, 3490, 1, 12, 2).remove();
		obj(12284, 3078, 3491, 1, 12, 2).remove();
		obj(12284, 3078, 3492, 1, 12, 2).remove();
		obj(12284, 3078, 3493, 1, 12, 2).remove();
		obj(12284, 3078, 3494, 1, 12, 2).remove();
		obj(12284, 3078, 3495, 1, 12, 2).remove();
		obj(12284, 3078, 3496, 1, 12, 2).remove();
		obj(12284, 3078, 3497, 1, 18, 3).remove();
		obj(12290, 3079, 3488, 1, 18, 1).remove();
		obj(12284, 3079, 3489, 1, 17, 2).remove();
		obj(12284, 3079, 3490, 1, 17, 2).remove();
		obj(12284, 3079, 3491, 1, 17, 2).remove();
		obj(12284, 3079, 3492, 1, 17, 2).remove();
		obj(12284, 3079, 3493, 1, 17, 2).remove();
		obj(12284, 3079, 3494, 1, 17, 2).remove();
		obj(12284, 3079, 3495, 1, 17, 2).remove();
		obj(12284, 3079, 3496, 1, 17, 2).remove();
		obj(12290, 3079, 3497, 1, 18, 3).remove();
		obj(12284, 3080, 3488, 1, 18, 1).remove();
		obj(12284, 3080, 3489, 1, 12, 0).remove();
		obj(12284, 3080, 3490, 1, 12, 0).remove();
		obj(12284, 3080, 3491, 1, 12, 0).remove();
		obj(12284, 3080, 3492, 1, 12, 0).remove();
		obj(12284, 3080, 3493, 1, 12, 0).remove();
		obj(12284, 3080, 3494, 1, 12, 0).remove();
		obj(12284, 3080, 3495, 1, 12, 0).remove();
		obj(12284, 3080, 3496, 1, 12, 0).remove();
		obj(12286, 3080, 3497, 1, 18, 3).remove();
		obj(12283, 3081, 3488, 1, 18, 1).remove();
		obj(12283, 3081, 3489, 1, 12, 0).remove();
		obj(12283, 3081, 3490, 1, 12, 0).remove();
		obj(12283, 3081, 3491, 1, 12, 0).remove();
		obj(12283, 3081, 3492, 1, 12, 0).remove();
		obj(12283, 3081, 3493, 1, 12, 0).remove();
		obj(12283, 3081, 3494, 1, 12, 0).remove();
		obj(12283, 3081, 3495, 1, 12, 0).remove();
		obj(12283, 3081, 3496, 1, 12, 0).remove();
		obj(12285, 3081, 3497, 1, 18, 3).remove();
		obj(12288, 3082, 3488, 1, 21, 0).remove();
		obj(12287, 3082, 3489, 1, 18, 0).remove();
		obj(12287, 3082, 3490, 1, 18, 0).remove();
		obj(12287, 3082, 3491, 1, 18, 0).remove();
		obj(12287, 3082, 3492, 1, 18, 0).remove();
		obj(12287, 3082, 3493, 1, 18, 0).remove();
		obj(12287, 3082, 3494, 1, 18, 0).remove();
		obj(12287, 3082, 3495, 1, 18, 0).remove();
		obj(12287, 3082, 3496, 1, 18, 0).remove();
		obj(12289, 3082, 3497, 1, 21, 0).remove();

		obj(979, 3081, 3501, 0, 0, 3).remove();
		obj(979, 3082, 3501, 0, 1, 3).remove();
		obj(979, 3082, 3500, 0, 0, 0).remove();
		obj(979, 3082, 3499, 0, 0, 0).remove();
		obj(979, 3082, 3498, 0, 9, 3).remove();
		obj(979, 3083, 3498, 0, 1, 3).remove();
		obj(979, 3078, 3487, 0, 0, 3).remove();
		obj(979, 3077, 3487, 0, 0, 3).remove();
		obj(4339, 3079, 3498, 0, 22, 0).remove();
		obj(4339, 3079, 3497, 0, 22, 0).remove();
		obj(4339, 3080, 3500, 0, 22, 0).remove();
		obj(4339, 3079, 3499, 0, 22, 0).remove();
		obj(4339, 3079, 3500, 0, 22, 0).remove();
		obj(4339, 3079, 3501, 0, 22, 0).remove();
		obj(979, 3076, 3498, 0, 9, 2).remove();
		obj(979, 3076, 3499, 0, 0, 2).remove();
		obj(979, 3076, 3500, 0, 0, 2).remove();
		obj(979, 3076, 3501, 0, 1, 2).remove();
		obj(979, 3077, 3501, 0, 0, 3).remove();
		obj(979, 3078, 3501, 0, 0, 3).remove();
		obj(979, 3083, 3492, 0, 0, 0).remove();
		obj(979, 3083, 3493, 0, 0, 0).remove();
		obj(979, 3083, 3494, 0, 0, 0).remove();
		obj(979, 3083, 3491, 0, 0, 0).remove();
		obj(979, 3083, 3490, 0, 0, 0).remove();
		obj(979, 3083, 3495, 0, 0, 0).remove();
	}

	/**
	 * Spawn (Make sure server code matches this!)
	 */

	static {
		//misc
		obj(6045, 3285, 9442, 0, 10, 0).spawn(); //jail mine cart

		//edgeville misc
		obj(864, 3091, 3487, 0, 10, 0).spawn(); //dummy standard
		obj(864, 3098, 3487, 0, 10, 0).spawn(); //dummy standard

		obj(4483, 3099, 3514, 0, 10, 0).spawn(); //wildy edge bank

		obj(4483, 3092, 3514, 0, 10, 0).spawn(); //wildy edge bank

		//edgeville general store
		obj(1902, 3080, 3506, 0, 0, 1).spawn(); //door space to wall
		obj(11508, 3090, 3509, 0, 0, 2).spawn(); //curtain
		obj(11509, 3090, 3511, 0, 0, 2).spawn(); //curtain
		for (int y = 3507; y <= 3513; y++)
			obj(24401, 3077, y, 0, 0, 2).spawn(); //shop ropes
		spawnRedCarpet(3078, 3509, 3084, 3511);

		obj(31379, 3083, 3507, 0, 11, 0).spawn(); //donation table
		//obj(29226, 3079, 3507, 0, 10, 3).spawn(); //pet list

		obj(26714, 3083, 3512, 0, 11, 0).spawn(); //max cape stand
		obj(3624, 3080, 3513, 0, 10, 0).spawn(); //mannequin™

		//edgeville house north of bank
		obj(1902, 3101, 3509, 0, 0, 0).spawn(); //door space to wall
		obj(1902, 3101, 3510, 0, 0, 0).spawn(); //door space to wall
		obj(11508, 3085, 3511, 0, 0, 0).spawn(); //curtain
		obj(11509, 3085, 3509, 0, 0, 0).spawn(); //curtain

		spawnRedCarpet(3091, 3509, 3099, 3511);

		obj(11509, 3094, 3506, 0, 0, 1).spawn(); //curtain
		obj(11508, 3097, 3506, 0, 0, 1).spawn(); //curtain
		obj(25732, 3098, 3507, 0, 10, 3).spawn(); //dragon head
		obj(25732, 3093, 3507, 0, 10, 3).spawn(); //dragon head

		obj(11508, 3094, 3514, 0, 0, 3).spawn(); //curtain
		obj(11509, 3097, 3514, 0, 0, 3).spawn(); //curtain
		obj(31380, 3095, 3513, 0, 10, 0).spawn(); //rejuv pool
		obj(25732, 3098, 3513, 0, 10, 1).spawn(); //dragon head
		obj(25732, 3093, 3513, 0, 10, 1).spawn(); //dragon head

		obj(202, 3100, 3512, 0, 10, 1).spawn(); //candles
		obj(18258, 3100, 3509, 0, 10, 2).spawn(); //altar
		obj(202, 3100, 3508, 0, 10, 1).spawn(); //candles

		// obj(12309, 3092, 3507, 0, 10, 2).spawn(); //rfd chest (Using it for loyalty reward chest!)
		obj(30816, 3091, 3507, 0, 10, 0).spawn(); //boxes

		obj(4483, 3092, 3513, 0, 10, 2).spawn(); //bank chest
		obj(30816, 3091, 3513, 0, 10, 1).spawn(); //boxes

		obj(1902, 3105, 3496, 0, 2, 3).spawn();
		obj(1902, 3105, 3501, 0, 2, 0).spawn();
		obj(1902, 3107, 3501, 0, 0, 1).spawn();
		obj(1902, 3108, 3501, 0, 0, 1).spawn();
		obj(1902, 3109, 3501, 0, 0, 1).spawn();
		obj(1902, 3106, 3496, 0, 0, 3).spawn();
		obj(1902, 3106, 3501, 0, 0, 1).spawn();
		obj(1902, 3107, 3496, 0, 0, 3).spawn();
		obj(1902, 3108, 3496, 0, 0, 3).spawn();
		obj(1902, 3109, 3496, 0, 0, 3).spawn();
		obj(1902, 3110, 3496, 0, 2, 2).spawn();
		obj(1902, 3110, 3497, 0, 0, 2).spawn();
		obj(1902, 3110, 3498, 0, 0, 2).spawn();
		obj(1902, 3110, 3499, 0, 0, 2).spawn();
		obj(1902, 3110, 3500, 0, 0, 2).spawn();
		obj(1902, 3110, 3501, 0, 2, 1).spawn();
		obj(11508, 3105, 3500, 0, 0, 0).spawn();
		obj(11509, 3105, 3497, 0, 0, 0).spawn();

		spawnRedCarpet(3105, 3497, 3110, 3500);
		obj(84, 3110, 3499, 0, 0, 2).spawn();
		obj(26209, 3110, 3499, 0, 10, 0).spawn();
		obj(26274, 3110, 3499, 0, 10, 3).spawn();
		obj(26275, 3110, 3499, 0, 22, 3).spawn();
		obj(29165, 3083, 3507, 0, 10, 0).spawn();

		obj(14986, 3107, 3496, 0, 10, 2).spawn();
		obj(12120, 3107, 3501, 0, 10, 2).spawn();

		//edgeville house west of bank (default)
		obj(979, 3082, 3487, 0, 0, 1).spawn(); //wall
		obj(979, 3083, 3487, 0, 3, 0).spawn(); //wall
		obj(979, 3081, 3487, 0, 0, 1).spawn(); //wall
		obj(979, 3080, 3487, 0, 0, 1).spawn(); //wall
		obj(979, 3079, 3487, 0, 0, 1).spawn(); //wall
		obj(979, 3078, 3487, 0, 0, 1).spawn(); //wall
		obj(979, 3077, 3487, 0, 0, 1).spawn(); //wall

		obj(979, 3076, 3498, 0, 0, 3).spawn(); //wall
		obj(979, 3077, 3498, 0, 0, 3).spawn(); //wall
		obj(979, 3078, 3498, 0, 0, 3).spawn(); //wall
		obj(979, 3079, 3498, 0, 0, 3).spawn(); //wall
		obj(979, 3080, 3498, 0, 0, 3).spawn(); //wall
		obj(979, 3081, 3498, 0, 0, 3).spawn(); //wall
		obj(979, 3082, 3498, 0, 0, 3).spawn(); //wall
		obj(979, 3083, 3498, 0, 3, 3).spawn(); //wall
		obj(5568, 3083, 3489, 0, 0, 0).spawn();
		obj(5567, 3083, 3496, 0, 0, 0).spawn();
		obj(31846, 3083, 3495, 0, 10, 1).spawn();
		obj(26747, 3083, 3490, 0, 10, 0).spawn();
		obj(6882, 3082, 3493, 0, 10, 0).spawn(); //crushed spears
		obj(6882, 3082, 3492, 0, 10, 0).spawn(); //crushed spears

		obj(5568, 3083, 3490, 0, 0, 0).spawn();
		obj(5567, 3083, 3495, 0, 0, 0).spawn();

		//edgeville house west of bank (PVP)
		obj(738, 3079, 3492, 0, 22, 0).spawn(); //minigame icon
		obj(6415, 3076, 3488, 0, 10, 0).spawn(); //torch
		obj(6415, 3076, 3497, 0, 10, 0).spawn(); //torch
		obj(29065, 3083, 3494, 0, 22, 0).spawn(); //Coffer
		obj(29087, 3083, 3494, 0, 10, 3).spawn(); //Coffer

		for (int x = 3077; x <= 3081; x++) {
			obj(5860, x, 3497, 0, 10, 3).spawn(); //spears (north)
			obj(5860, x, 3488, 0, 10, 1).spawn(); //spears (south)
		}
		for (int y = 3489; y <= 3496; y++) {
			obj(5860, 3076, y, 0, 10, 2).spawn(); //spears (west)
		}
		for (int y = 3489; y <= 3496; y++) {
			if (y != 3492 && y != 3493) obj(5860, 3082, y, 0, 10, 0).spawn(); //spears (east)
		}
		obj(28925, 3099, 3506, 0, 10, 0).spawn(); //Fun PVP portal
	}

	private static void spawnRedCarpet(int swX, int swY, int neX, int neY) {
		for (int x = swX; x <= neX; x++) {
			for (int y = swY; y <= neY; y++) {
				if (x == swX) {
					if (y == swY) obj(6812, x, y, 0, 22, 3).spawn();
					else if (y == neY) obj(6812, x, y, 0, 22, 0).spawn();
					else obj(6813, x, y, 0, 22, 3).spawn();
				} else if (x == neX) {
					if (y == swY) obj(6812, x, y, 0, 22, 2).spawn();
					else if (y == neY) obj(6812, x, y, 0, 22, 1).spawn();
					else obj(6813, x, y, 0, 22, 1).spawn();
				} else {
					if (y == swY) obj(6813, x, y, 0, 22, 2).spawn();
					else if (y == neY) obj(6813, x, y, 0, 22, 0).spawn();
					else obj(6814, x, y, 0, 22, 0).spawn();
				}
			}
		}
	}
}
