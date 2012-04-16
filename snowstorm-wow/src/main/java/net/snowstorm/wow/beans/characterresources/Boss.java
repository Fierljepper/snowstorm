package net.snowstorm.wow.beans.characterresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User;
 * File Templates.
 */
public class Boss extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("6a40f8be-ebc1-4d44-a83d-9e6889d1c0d7");

    private String name;
    private int normalKills;
    private int heroicKills;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getNormalKills() {
        return normalKills;
    }

    public void setNormalKills(final int normalKills) {
        this.normalKills = normalKills;
    }

    public int getHeroicKills() {
        return heroicKills;
    }

    public void setHeroicKills(final int heroicKills) {
        this.heroicKills = heroicKills;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return getName();
    }
}
