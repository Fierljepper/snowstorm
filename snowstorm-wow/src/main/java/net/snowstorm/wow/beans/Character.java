package net.snowstorm.wow.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User: developer Date: 4/14/12 Time: 11:17 AM To change this template use File | Settings |
 * File Templates.
 */
public class Character extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("55ebf1fe-6cca-4aa3-9a32-c25f9173f44b");

    private String name;
    private String realm;
    @SerializedName("class")
    private int clazz;
    private int race;
    private int gender;
    private int level;
    private int achievementPoints;
    private String thumbnail;

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

    public int getClazz() {
        return clazz;
    }

    public void setClazz(final int clazz) {
        this.clazz = clazz;
    }

    public int getRace() {
        return race;
    }

    public void setRace(final int race) {
        this.race = race;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(final int gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(final int level) {
        this.level = level;
    }

    public int getAchievementPoints() {
        return achievementPoints;
    }

    public void setAchievementPoints(final int achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(final String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
