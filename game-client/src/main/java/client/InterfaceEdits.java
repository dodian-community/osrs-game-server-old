package client;

public class InterfaceEdits {

    public static void childLoaded(Widget inter) {
        int parentId = inter.interfaceHash >> 16;
        int childId = inter.interfaceHash & 0xffff;
        inter.componentString = inter.componentString.replace("RuneScape", "OS-Scape");
        if(parentId == 275) { //quest scroll
            if(childId >= 4 && childId <= 133)
                inter.componentString = "";
        }
    }

    public static void optionSet(Widget inter, int index, String option) {
        int parentId = inter.interfaceHash >> 16;
        if(option.equals("Quest List")) {
            inter.setOption(index, (String) JournalInterface.ACTIVE_JOURNAL[0]);
            return;
        }
        if(parentId == 320) {
            inter.setOption(0, option.replace("View", "Set").replace("guide", "level"));
        }
    }

    public static void unlock(int interfaceHash, int minChildId, int maxChildId, int... optionIndexes) {
        int mask = 0;
        for(int i : optionIndexes)
            mask |= 2 << i;
        for(int slot = minChildId; slot <= maxChildId; slot++) {
            long l = (((long) interfaceHash << 32) + (long) slot);
            class204 var60 = GameClient.interfaceSettings.get(l);
            if (var60 != null) {
                var60.unlink();
            }

            GameClient.interfaceSettings.method4016(new class211(mask), l);
        }
    }

}