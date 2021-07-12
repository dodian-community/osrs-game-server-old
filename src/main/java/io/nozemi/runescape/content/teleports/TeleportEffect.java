package io.nozemi.runescape.content.teleports;

public class TeleportEffect {
    public int delay;
    public int[] animation;
    public int[] graphics;
    public int[] sound;

    public TeleportEffect() {
        this.delay = 0;
        this.animation = new int[]{};
        this.graphics = new int[]{};
        this.sound = new int[]{};
    }

    public TeleportEffect(int duration, int[] animation, int[] graphic, int[] sound) {
        this.animation = animation;
        this.graphics = graphic;
        this.delay = duration;
        this.sound = sound;
    }

    public void setAnimation(int[] animation) {
        this.animation = animation;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setGraphics(int[] graphic) {
        this.graphics = graphic;
    }

    public void setSound(int[] sound) {
        this.sound = sound;
    }
}
