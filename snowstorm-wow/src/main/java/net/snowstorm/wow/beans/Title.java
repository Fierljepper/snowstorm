package net.snowstorm.wow.beans;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User;
 * File Templates.
 */
public class Title extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("43afea1e-9e96-4cea-9d12-fe969a38c2a6");

    private int id;
    private String name;

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

    @Override
    public String toString(){
        return getName();
    }
}
