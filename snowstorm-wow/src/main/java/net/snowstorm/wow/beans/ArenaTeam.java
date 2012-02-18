package net.snowstorm.wow.beans;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User;
 * File Templates.
 */
public class ArenaTeam extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("6a0db243-9357-4884-95ae-06e358cd9711");

    private String name;
    private int personalRating;
    private int teamRating;
    private String size;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getPersonalRating() {
        return personalRating;
    }

    public void setPersonalRating(final int personalRating) {
        this.personalRating = personalRating;
    }

    public int getTeamRating() {
        return teamRating;
    }

    public void setTeamRating(final int teamRating) {
        this.teamRating = teamRating;
    }

    public String getSize() {
        return size;
    }

    public void setSize(final String size) {
        this.size = size;
    }

    @Override
    public String toString(){
        return getName();
    }
}
