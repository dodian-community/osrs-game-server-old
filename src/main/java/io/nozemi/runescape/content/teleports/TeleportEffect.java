package io.nozemi.runescape.content.teleports;

public class TeleportEffect {
    public int duration;
    public int[] animation;
    public int[] graphics;
    public int[] sound;

    public TeleportEffect() {
        this.duration = 0;
        this.animation = new int[]{};
        this.graphics = new int[]{};
        this.sound = new int[]{};
    }

    public TeleportEffect(int duration, int[] animation, int[] graphic, int[] sound) {
        this.animation = animation;
        this.graphics = graphic;
        this.duration = duration;
        this.sound = sound;
    }

    public void setAnimation(int[] animation) {
        this.animation = animation;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setGraphics(int[] graphic) {
        this.graphics = graphic;
    }

    public void setSound(int[] sound) {
        this.sound = sound;
    }
}
