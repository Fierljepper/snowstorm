package net.snowstorm.wow.beans.characterresources;

import com.google.gson.annotations.SerializedName;
import net.snowstorm.wow.beans.*;
import net.snowstorm.wow.beans.shared.Achievements;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User: developer Date: 1/31/12 Time: 4:23 PM To change this template use File | Settings |
 * File Templates.
 */
public class CharacterProfile extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("7b1d27b1-76b8-43b3-97b3-07759ae8a8d6");

    private long lastModified;
    private String name;
    private String realm;
    @SerializedName("class")
    private int clazz;
    private int race;
    private int gender;
    private int level;
    private int achievementPoints;
    private String thumbnail;
    private Guild guild;
    private Stats stats;
    private Collection<Talent> talents;
    private Items items;
    private Collection<Reputation> reputation;
    private Collection<Title> titles;
    private Professions professions;
    private Appearance appearance;
    private int[] companions;
    private int[] mounts;
    private Collection<Pet> pets;
    private Achievements achievements;
    private Progression progression;
    private Pvp pvp;
    private int[] quests;

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

    public Guild getGuild() {
        return guild;
    }

    public void setGuild(final Guild guild) {
        this.guild = guild;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(final Stats stats) {
        this.stats = stats;
    }

    public Collection<Talent> getTalents() {
        return talents;
    }

    public void setTalents(final Collection<Talent> talents) {
        this.talents = talents;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(final Items items) {
        this.items = items;
    }

    public Collection<Reputation> getReputation() {
        return reputation;
    }

    public void setReputation(final Collection<Reputation> reputation) {
        this.reputation = reputation;
    }

    public Collection<Title> getTitles() {
        return titles;
    }

    public void setTitles(final Collection<Title> titles) {
        this.titles = titles;
    }

    public Professions getProfessions() {
        return professions;
    }

    public void setProfessions(final Professions professions) {
        this.professions = professions;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(final Appearance appearance) {
        this.appearance = appearance;
    }

    public int[] getCompanions() {
        return companions;
    }

    public void setCompanions(final int[] companions) {
        this.companions = companions;
    }

    public int[] getMounts() {
        return mounts;
    }

    public void setMounts(final int[] mounts) {
        this.mounts = mounts;
    }

    public Collection<Pet> getPets() {
        return pets;
    }

    public void setPets(final Collection<Pet> pets) {
        this.pets = pets;
    }

    public Achievements getAchievements() {
        return achievements;
    }

    public void setAchievements(final Achievements achievements) {
        this.achievements = achievements;
    }

    public Progression getProgression() {
        return progression;
    }

    public void setProgression(final Progression progression) {
        this.progression = progression;
    }

    public Pvp getPvp() {
        return pvp;
    }

    public void setPvp(final Pvp pvp) {
        this.pvp = pvp;
    }

    public int[] getQuests() {
        return quests;
    }

    public void setQuests(final int[] quests) {
        this.quests = quests;
    }

    @Override
    public String toString(){
        return getName();
    }
}
