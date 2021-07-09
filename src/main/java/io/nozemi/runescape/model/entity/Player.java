package io.nozemi.runescape.model.entity;

import io.netty.channel.Channel;
import io.nozemi.runescape.crypto.IsaacRand;
import io.nozemi.runescape.model.Area;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.player.Looks;
import io.nozemi.runescape.model.entity.player.PlayerSyncInfo;
import io.nozemi.runescape.model.entity.player.Privilege;
import io.nozemi.runescape.net.message.game.command.PlaySound;
import io.nozemi.runescape.net.message.game.command.SendWidgetTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.InetSocketAddress;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Player extends Entity {

    /**
     * Networking
     */
    private Channel channel;
    private IsaacRand inRand;
    private IsaacRand outRand;
    private boolean discardWrites;
    private String ip;

    /**
     * Character Information
     */
    private String username;
    private Privilege privilege = Privilege.PLAYER;
    private Looks looks;

    /**
     * Location Information
     */
    private Tile remoteLocation;
    private Tile activeMap;

    /**
     * Other
     */
    private Object id;
    private int gameTime;

    @Autowired
    public Player() {
        InetSocketAddress socketAddress;
        InetAddress inetaddress = null;
        if (channel != null) {
            socketAddress = (InetSocketAddress) channel.remoteAddress();
            inetaddress = socketAddress.getAddress();
        }
        ip = inetaddress == null ? "127.0.0.1" : inetaddress.getHostAddress();
    }

    public void id(Object id) {
        this.id = id;
    }

    public Object id() {
        return id; // Temporary!
    }

    public Channel channel() {
        return this.channel;
    }

    public Player channel(Channel channel) {
        this.channel = channel;
        return this;
    }

    public String username() {
        return this.username;
    }

    public Player username(String username) {
        this.username = username;
        return this;
    }

    public String ip() {
        return ip;
    }

    public Tile remoteLocation() {
        return remoteLocation;
    }

    public void updateRemoteLocation() {
        remoteLocation = tile;
    }

    public Tile activeMap() {
        return activeMap;
    }

    public void activeMap(Tile t) {
        activeMap = t;
    }

    public Area activeArea() {
        if (activeMap == null) {
            return new Area(tile.x - 52, tile.z - 52, tile.x + 52, tile.z + 52, tile().level);
        }

        return new Area(activeMap.x, activeMap.z, activeMap.x + 104, activeMap.z + 104, activeMap.level);
    }

    public boolean busy() {
        return (attribOr(AttributeKey.BUSY, false));
    }

    public void busy(boolean isBusy) {
        putattrib(AttributeKey.BUSY, isBusy);
    }

    public void write(Object... o) {
        // TODO: Fix this later? Causes a disconnect
        if(o[0] instanceof SendWidgetTimer) {
            return;
        }

        if (!discardWrites) {
            if (channel.isActive()) {
                for (Object msg : o) {
                    channel.write(msg);
                }
            }
        }
    }

    public int gameTime() {
        return gameTime;
    }

    public void gameTime(int t) {
        gameTime = t;
    }

    public Looks looks() {
        return looks;
    }

    public Privilege privilege() {
        return privilege;
    }

    @Override
    public boolean isPlayer() {
        return true;
    }

    @Override
    public boolean isNpc() {
        return false;
    }

    @Override
    public void hp(int hp, int exceed) {

    }

    @Override
    public int hp() {
        return 1;
    }

    @Override
    public int maxHp() {
        return 1;
    }

    @Override
    protected void die() {

    }

    @Override
    public int attackAnimation() {
        return 0;
    }

    @Override
    public void post_cycle_movement() {

    }

    @Override
    public PlayerSyncInfo sync() {
        return (PlayerSyncInfo) sync;
    }

    public void sound(int id) {
        write(new PlaySound(id, 0));
    }

    public void sound(int id, int delay) {
        write(new PlaySound(id, delay));
    }

    public void sound(int id, int delay, int times) {
        write(new PlaySound(id, delay, times));
    }
}
