package net.snowstorm.wow.beans;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User;
 * File Templates.
 */
public class Battleground extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("ffb64b2e-d6d6-430f-b798-757ca87dbf6f");

    private String name;
    private int played;
    private int won;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(final int played) {
        this.played = played;
    }

    public int getWon() {
        return won;
    }

    public void setWon(final int won) {
        this.won = won;
    }

    @Override
    public String toString(){
        return getName();
    }
}
