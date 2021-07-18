package io.nozemi.runescape.orm.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.item.ItemContainer;
import io.nozemi.runescape.orm.converters.ItemContainerConverter;

import javax.persistence.*;

@Entity
@Table(name = "characters", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
})
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int userId;
    private String username;
    @Column(nullable = true)
    private boolean online;
    private int posX;
    private int posY;
    private int level;
    @Column(columnDefinition = "double default 100.0")
    private double runEnergy;
    @Convert(converter = ItemContainerConverter.class)
    @Column(columnDefinition = "json default '[]'")
    private ItemContainer inventory;
    @Column(columnDefinition = "json default '[]'")
    @Convert(converter = ItemContainerConverter.class)
    private ItemContainer equipment;

    public Character() {

    }

    public Character(Player player) {
        this.update(player);
    }

    public Character(Player player, boolean online) {
        this.update(player, online);
    }

    public void updatePlayer(Player player) {
        player.username(username);
        player.inventory(inventory);
        player.equipment(equipment);
        player.tile(new Tile(posX, posY, level));
        player.putattrib(AttributeKey.RUN_ENERGY, runEnergy);
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getRunEnergy() {
        return runEnergy;
    }

    public void setRunEnergy(double runEnergy) {
        this.runEnergy = runEnergy;
    }

    public ItemContainer getInventory() {
        return inventory;
    }

    public void setInventory(ItemContainer inventory) {
        this.inventory = inventory;
    }

    public ItemContainer getEquipment() {
        return equipment;
    }

    public void setEquipment(ItemContainer equipment) {
        this.equipment = equipment;
    }

    public void setPosition(Tile tile) {
        this.posX = tile.x;
        this.posY = tile.z;
        this.level = tile.level;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isOnline() {
        return online;
    }

    public void update(Player player) {
        update(player, false);
    }

    public void update(Player player, boolean online) {
        this.online = online;
        this.userId = player.userId();
        this.username = player.username();
        this.inventory = player.inventory();
        this.equipment = player.equipment();
        this.posX = player.tile().x;
        this.posY = player.tile().z;
        this.level = player.tile().level;
        this.runEnergy = player.attribOr(AttributeKey.RUN_ENERGY, 0.0);
    }
}
