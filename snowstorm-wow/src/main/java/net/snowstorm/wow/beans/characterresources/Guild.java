package net.snowstorm.wow.beans.characterresources;

import net.snowstorm.wow.beans.shared.Emblem;
import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User: developer Date: 2/16/12 Time: 7:13 PM To change this template use File | Settings |
 * File Templates.
 */
public class Guild extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("49fe58e0-f6ff-4caf-80dd-a7cb003b7c53");

    private String name;
    private String realm;
    private int level;
    private int members;
    private int achievementPoints;
    private Emblem emblem;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(final String realm) {
        this.realm = realm;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(final int level) {
        this.level = level;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(final int members) {
        this.members = members;
    }

    public int getAchievementPoints() {
        return achievementPoints;
    }

    public void setAchievementPoints(final int achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    public Emblem getEmblem() {
        return emblem;
    }

    public void setEmblem(final Emblem emblem) {
        this.emblem = emblem;
    }

    @Override
    public String toString(){
        return getName();
    }

}
