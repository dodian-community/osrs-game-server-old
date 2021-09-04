package io.nozemi.runescape.content.teleports;

public class MyTeleports {
    private String name;
    private TeleportEffect[] chain;

    public MyTeleports() {

    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public TeleportEffect[] chain() {
        return chain;
    }

    public void chain(TeleportEffect[] chain) {
        this.chain = chain;
    }
}
