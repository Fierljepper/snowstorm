package net.snowstorm.wow.beans.guildresources;

import net.snowstorm.wow.beans.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User: developer Date: 4/14/12 Time: 11:12 AM To change this template use File | Settings |
 * File Templates.
 */
public class Member extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("b370ce24-583f-49a6-a9ca-d22d650c0f3b");
    
    private Character character;
    private int rank;

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(final Character character) {
        this.character = character;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(final int rank) {
        this.rank = rank;
    }
}
