package io.nozemi.runescape.model.entity.player;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.item.Item;
import io.nozemi.runescape.util.EquipmentInfo;
import io.nozemi.runescape.util.Varbit;

import java.util.Arrays;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public class Looks {

    private static final int[] TRANSLATION_TABLE = new int[]{8, 11, 4, 6, 9, 7, 10};
    private static final int[] TRANSLATION_TABLE_BACK = new int[]{-1, -1, -1, -1, 2, -1, 3, 5, 0, 4, 6, 1};
    private static final int[] WRONG_LOOKS = {18, 26, 36, 7, 33, 42, 10};
    public static final int[] GOOD_LOOKS = {0, 10, 18, 26, 33, 36, 42};

    private byte[] calculated;

    private Player player;
    private int transmog = -1;
    private ByteBuf calcBuffer;
    private int[] renderpairOverride;
    private boolean female;
    private boolean hide;
    private int[] looks = {0, 10, 18, 26, 33, 36, 42};
    private int[] colors = new int[5];
    private boolean invisible = false;

    public Looks(Player player) {
        this.player = player;
        calcBuffer = Unpooled.buffer(128);
    }

    public void colors(int[] c) {
        colors = c;
    }

    public void looks(int[] l) {
        looks = l;

        if (Arrays.equals(looks, WRONG_LOOKS)) {
            System.arraycopy(GOOD_LOOKS, 0, looks, 0, GOOD_LOOKS.length);
        }
    }

    public void female(boolean female) {
        this.female = female;
    }

    public void hide(boolean hide) {
        this.hide = hide;
    }

    public boolean hidden() {
        return hide;
    }

    public boolean female() {
        return female;
    }

    public int[] looks() {
        return looks;
    }

    public int[] colors() {
        return colors;
    }

    public void update() {
        calcBuffer.readerIndex(0);
        calcBuffer.writerIndex(0); // Start at 0

        calcBuffer.writeByte(female ? 1 : 0); // Gender

        int skull = -1;
		/*if (Skulling.skulled(player)) {
			skull = 0; // flag as should render
		}*/

        calcBuffer.writeByte(skull); // Skull

        int prayIcon = -1;
        if (player.varps().varbit(Varbit.PROTECT_FROM_MELEE) == 1)
            prayIcon = 0;
        if (player.varps().varbit(Varbit.PROTECT_FROM_MISSILES) == 1)
            prayIcon = 1;
        if (player.varps().varbit(Varbit.PROTECT_FROM_MAGIC) == 1)
            prayIcon = 2;

        if (player.varps().varbit(Varbit.RETRIBUTION) == 1)
            prayIcon = 3;
        if (player.varps().varbit(Varbit.SMITE) == 1)
            prayIcon = 4;
        if (player.varps().varbit(Varbit.REDEMPTION) == 1)
            prayIcon = 5;


        calcBuffer.writeByte(prayIcon); // Prayer

        if (!invisible) {
            if (transmog >= 0) {
                calcBuffer.writeShort(0xFFFF).writeShort(transmog);
            } else {
                //6 = arms
                //8 = hair
                //9 = hands
                //10 = boots
                //11 = beard
                EquipmentInfo equipInfo = player.world().equipmentInfo();
                for (int i = 0; i < 12; i++) {
                    Item item = player.equipment().get(i);
                    if (i == 6 || i == 8 || i == 11) {
                        item = player.equipment().get(i == 6 ? EquipSlot.BODY : EquipSlot.HEAD);
                        if (item != null) {
                            int equipmentType = equipInfo.typeFor(item.getId());
                            if (female && equipInfo.showBeard(item.getId()) && i == 11) {
                                calcBuffer.writeByte(0);
                                continue;
                            }
                            if ((equipmentType == 6 && i == 6) ||
                                    (i == 8 && (equipmentType == 8 && !equipInfo.showBeard(item.getId())))
                                    || (!equipInfo.showBeard(item.getId()) && i == 11)) {
                                calcBuffer.writeByte(0);
                                continue;
                            }
                            if (i != 8 || equipmentType != 8)
                                item = null;
                        }
                    }
                    if (item != null)
                        calcBuffer.writeShort(0x200 + (item.getId() == 6767 ? 12006 : item.getId()));
                    else {
                        if (TRANSLATION_TABLE_BACK[i] != -1)
                            calcBuffer.writeShort(0x100 + looks[TRANSLATION_TABLE_BACK[i]]);
                        else
                            calcBuffer.writeByte(0);
                    }
                }
            }
        } else {
            for (int i = 0; i < 12; i++) {
                calcBuffer.writeByte(0);
            }
        }

        // Dem colors
        for (int idx = 0; idx < colors.length; idx++) {
            int col = Math.max(0, colors[idx]);
            calcBuffer.writeByte(col);
        }

        int weapon = player.equipment().hasAt(EquipSlot.WEAPON) ? player.equipment().get(EquipSlot.WEAPON).getId() : -1;
        int[] renderpair = renderpairOverride != null ? renderpairOverride : player.world().equipmentInfo().renderPair(weapon);
        // Stand, walk sideways, walk, turn 180, turn 90 cw, turn 90 ccw, run
        for (int renderAnim : renderpair)
            calcBuffer.writeShort(renderAnim); // Renderanim

        /* Str idgaf */
        calcBuffer.writeBytes(player.username().getBytes()).writeByte(0);//with terminator 0

        // TODO: Write combat level...
        if (player.skills() == null) {
            calcBuffer.writeByte(3);
        } else {
            calcBuffer.writeByte(player.skills().combatLevel());
        }
        calcBuffer.writeShort(0);
        calcBuffer.writeByte(0);//removed hidden var - not sure of what this byte does but it certainly doesnt hide the player.

        calculated = new byte[calcBuffer.writerIndex()];
        calcBuffer.readerIndex(0);
        calcBuffer.readBytes(calculated);

        player.sync().calculateLooks();
    }

    public void invisible(boolean invis) {
        this.invisible = invis;
        update();
    }

    public boolean invisible() {
        return invisible;
    }

    public void transmog(int id) {
        transmog = id;
        update();
    }

    public int trans() {
        return transmog;
    }

    public void render(int... pair) {
        renderpairOverride = pair;
        update();
    }

    public void renderData(int[] data) {
        renderpairOverride = data;
        update();
    }

    public void resetRender() {
        renderpairOverride = null;
        update();
    }

    public byte[] get() {
        /* Just in case... */
        if (calculated == null)
            update();

        return calculated;
    }

    private static int[] renderFor(int id) {
        return new int[]{};
    }


    private static final int[][] MALE_VALUES = {
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 129, 130, 131, 132, 133, 134, 142, 144, 145, 146, 147, 148, 149, 150}, // head
            {10, 11, 12, 13, 14, 15, 16, 17, 111, 112, 113, 114, 115, 116, 117}, // jaw
            {18, 19, 20, 21, 22, 23, 24, 25, 105, 106, 107, 108, 109, 110}, // torso
            {26, 27, 28, 29, 30, 31, 32, 84, 85, 86, 87, 88}, // arms
            {33, 34, 35}, // hands
            {36, 37, 38, 39, 40, 41, 100, 101, 102, 103, 104}, // legs
            {42, 43, 44, 82}, // feet
    };

    // 145 IDK - THANK YOU - FROM Stan @ https://www.rune-server.ee/runescape-development/rs2-client/configuration/658137-145-identitykit.html#post5400016

    private static final int[][] FEMALE_VALUES = {
            {45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 141, 143}, // head
            {-1, -1}, // jaw
            {56, 57, 58, 59, 60, 89, 90, 91, 92, 93, 94}, // torso
            {61, 62, 63, 64, 65, 66, 95, 96, 97, 98, 99}, // arms
            {67, 68, 69}, // hands
            {70, 71, 72, 73, 74, 75, 76, 77, 78, 135, 136, 137, 138, 139, 140}, // legs
            {79, 80, 81, 83}, // feet
    };

    private static final int[][] IDK_COLORS = {

            {6798, 107, 10283, 16, 4797, 7744, 5799, 4634, -31839, 22433, 2983, -11343, 8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010},

            {8741, 12, -1506, -22374, 7735, 8404, 1701, -27106, 24094, 10153, -8915, 4783, 1341, 16578, -30533, 25239, 8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010},

            {25238, 8742, 12, -1506, -22374, 7735, 8404, 1701, -27106, 24094, 10153, -8915, 4783, 1341, 16578, -30533, 8, 5281, 10438, 3650, -27322, -21845, 200, 571, 908, 21830, 28946, -15701, -14010},

            {4626, 11146, 6439, 12, 4758, 10270},

            {4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574}}; // 17050, 0, 127 for special colors (green-black-pale)

    private static final int[][] ALLOWED_COLORS = {{0, IDK_COLORS[0].length}, // hair
            // color
            {0, IDK_COLORS[1].length}, // torso color
            {0, IDK_COLORS[2].length}, // legs color
            {0, IDK_COLORS[3].length}, // feet color
            {0, IDK_COLORS[4].length} // skin color
    };

    // TODO: have to use - 8 (exclude the last 8) because the client for some fucking reason doesn't like them!!
    public void randomize() {

        female(player.world().random(1) == 1);

        int[] looks = new int[7];
        for (int i = 0; i < looks.length; i++) {
            looks[i] = Math.max(0, female ? FEMALE_VALUES[i][player.world().random(FEMALE_VALUES[i].length - 8)] : MALE_VALUES[i][player.world().random(MALE_VALUES[i].length - 8)]);
        }
        looks(looks);

        int[] colours = new int[5]; // uk spelling real spelling btw
        for (int i = 0; i < colours.length; i++)
            colours[i] = player.world().random(IDK_COLORS[i].length - 1);
        colors(colours);

        update();
    }
}
