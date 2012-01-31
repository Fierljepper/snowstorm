package net.snowstorm.wow.beans;

/**
 * Created by IntelliJ IDEA. User: developer Date: 1/31/12 Time: 4:23 PM To change this template use File | Settings |
 * File Templates.
 */
public class Character {

    private float lastModified;
    private String name;
    private String realm;
    private int clazz;
    private int race;
    private int gender;
    private int level;
    private int achievementPoints;
    private String thumbnail;
    private int[] quests;

    public float getLastModified() {
        return lastModified;
    }

    public void setLastModified(final float lastModified) {
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

    public int[] getQuests() {
        return quests;
    }

    public void setQuests(final int[] quests) {
        this.quests = quests;
    }
}
