package net.snowstorm.wow.beans.guildresources;

import net.snowstorm.wow.beans.WowBean;
import net.snowstorm.wow.beans.shared.Achievements;
import net.snowstorm.wow.beans.shared.Emblem;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User: developer Date: 4/14/12 Time: 10:03 AM To change this template use File | Settings |
 * File Templates.
 */
public class GuildProfile extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("2acee7b6-569f-4b21-b69a-3f34357b6e33");

    private long lastModified;
    private String name;
    private String realm;
    private int level;
    private int side;
    private int achievementPoints;
    private Achievements achievements;
    private Collection<Member> members;
    private Emblem emblem;

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(final long lastModified) {
        this.lastModified = lastModified;
    }

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

    public int getSide() {
        return side;
    }

    public void setSide(final int side) {
        this.side = side;
    }

    public int getAchievementPoints() {
        return achievementPoints;
    }

    public void setAchievementPoints(final int achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    public Achievements getAchievements() {
        return achievements;
    }

    public void setAchievements(final Achievements achievements) {
        this.achievements = achievements;
    }

    public Collection<Member> getMembers() {
        return members;
    }

    public void setMembers(final Collection<Member> members) {
        this.members = members;
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
