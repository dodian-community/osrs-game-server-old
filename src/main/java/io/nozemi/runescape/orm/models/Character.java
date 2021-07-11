package io.nozemi.runescape.orm.models;

import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.Player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int userId;
    private String username;
    private int posX;
    private int posY;
    private int posZ;
    private double runEnergy;
    private double specialEnergy;

    public Character() {

    }

    public Character(Player player) {
        this.id = (int) player.id();
        this.username = player.username();
        this.posX = player.tile().x;
        this.posY = player.tile().z;
        this.posZ = player.tile().level;
        this.runEnergy = player.attribOr(AttributeKey.RUN_ENERGY, 0.0);
    }

    public Player getPlayer(Player player) {
        player.id(this.id);
        player.username(this.username);
        player.tile(new Tile(this.posX, this.posY, this.posZ));
        player.setRunningEnergy(this.runEnergy, true);
        return player;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosZ() {
        return posZ;
    }

    public void setPosZ(int posZ) {
        this.posZ = posZ;
    }

    public void setPos(Tile tile) {
        this.posX = tile.x;
        this.posY = tile.z;
        this.posZ = tile.level;
    }

    public double getRunEnergy() {
        return runEnergy;
    }

    public void setRunEnergy(double runEnergy) {
        this.runEnergy = runEnergy;
    }

    public double getSpecialEnergy() {
        return specialEnergy;
    }

    public void setSpecialEnergy(double specialEnergy) {
        this.specialEnergy = specialEnergy;
    }
}
