package net.snowstorm.wow.beans;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User;
 * File Templates.
 */
public class Reputation extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("92aed650-0e9f-4e7b-8e9c-844a6681f074");

    private int id;
    private String name;
    private int standing;
    private int value;
    private int max;

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

    public int getStanding() {
        return standing;
    }

    public void setStanding(final int standing) {
        this.standing = standing;
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public int getMax() {
        return max;
    }

    public void setMax(final int max) {
        this.max = max;
    }

    @Override
    public String toString(){
        return getName();
    }
}
