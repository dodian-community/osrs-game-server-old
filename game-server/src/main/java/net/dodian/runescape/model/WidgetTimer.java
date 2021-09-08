package net.dodian.runescape.model;

public enum WidgetTimer {

    BARRAGE(68, "Frozen", "You are frozen and cannot move"),
    TELEBLOCK(69, "Teleblocked", "You cannot teleport"),
    VENGEANCE(70, "Vengeance cooldown", "Vengeance spell is on cooldown and cannot be casted again"),
    STAMINA(71, "Stamina potion", "Run energy consumption reduced by 70%"),
    OVERLOAD(72, "Overload", "Your stats are boosted every 15 seconds"),
    ANTIFIRE(73, "Antifire", "Partial protection against dragon fire"),
    EXTENDED_ANTIFIRE(74, "Extended antifire", "Partial protection against dragon fire"),
    ANTI_VENOM(75, "Anti-venom", "You are immune to venom");

    private final int spriteId;

    private final String name;
    private final String description;

    WidgetTimer(int spriteId, String name, String description) {
        this.spriteId = spriteId;
        this.name = name;
        this.description = description;
    }

    public int getSpriteId() {
        return spriteId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
