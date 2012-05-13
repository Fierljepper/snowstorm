package net.snowstorm.wow.beans.itemresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 5/13/12 Time: 2:10 PM To change this template use File | Settings |
 * File Templates.
 */
public class ItemSet extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("c01bb9ba-7626-4c0b-aaf6-fa3a93f324eb");

    private int id;
    private String name;
    private Collection<SetBonus> setBonuses;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Collection<SetBonus> getSetBonuses() {
        return setBonuses;
    }

    public void setSetBonuses(final Collection<SetBonus> setBonuses) {
        this.setBonuses = setBonuses;
    }
}
