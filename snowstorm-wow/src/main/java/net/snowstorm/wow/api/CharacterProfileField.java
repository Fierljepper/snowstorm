package net.snowstorm.wow.api;

/**
 * Created by IntelliJ IDEA. User: developer Date: 1/31/12 Time: 3:45 PM To change this template use File | Settings |
 * File Templates.
 */
public enum CharacterProfileField {
    GUILD,
    STATS,
    TALENTS,
    ITEMS,
    REPUTATION,
    TITLES,
    PROFESSIONS,
    APPEARANCE,
    COMPANIONS,
    MOUNTS,
    PETS,
    ACHIEVEMENTS,
    PROGRESSION,
    PVP,
    QUESTS;

    @Override
    public String toString(){
        return super.toString().substring(0, 1).toUpperCase() + super.toString().substring(1).toLowerCase();
    }
}
