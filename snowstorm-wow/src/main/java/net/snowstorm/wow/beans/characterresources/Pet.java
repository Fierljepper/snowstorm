package net.snowstorm.wow.beans.characterresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User;
 * File Templates.
 */
public class Pet extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("5ba1d472-dc3c-4675-af50-96e585e6ac2b");

    private String name;
    private int creature;
    private int slot;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getCreature() {
        return creature;
    }

    public void setCreature(final int creature) {
        this.creature = creature;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(final int slot) {
        this.slot = slot;
    }

    @Override
    public String toString(){
        return getName();
    }
}
