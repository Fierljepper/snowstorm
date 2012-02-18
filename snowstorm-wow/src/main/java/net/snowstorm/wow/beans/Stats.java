package net.snowstorm.wow.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User;
 * File Templates.
 */
public class Stats extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("063d42be-7ba9-4a5f-a7dc-0453b3bd29ba");

    private int health;
    private String powerType;
    private int power;
    private int str;
    private int agi;
    private int sta;
    @SerializedName("int")
    private int intelect;
    private int spr;
    private int attackPower;
    private int rangedAttackPower;
    private double mastery;
    private int masteryRating;
    private double crit;
    private int critRating;
    private double hitPercent;
    private int hitRating;
    private int hasteRating;
    private int expertiseRating;
    private int spellPower;
    private int spellPen;
    private double spellCrit;
    private int spellCritRating;
    private double spellHitPercent;
    private int spellHitRating;
    private double mana5;
    private double mana5Combat;
    private int armor;
    private double dodge;
    private int dodgeRating;
    private double parry;
    private int parryRating;
    private double block;
    private int blockRating;
    private int resil;
    private double mainHandDmgMin;
    private double mainHandDmgMax;
    private double mainHandSpeed;
    private double mainHandDps;
    private int mainHandExpertise;
    private double offHandDmgMin;
    private double offHandDmgMax;
    private double offHandSpeed;
    private double offHandDps;
    private int offHandExpertise;
    private double rangedDmgMin;
    private double rangedDmgMax;
    private double rangedSpeed;
    private double rangedDps;
    private double rangedCrit;
    private int rangedCritRating;
    private double rangedHitPercent;
    private int rangedHitRating;

    public int getHealth() {
        return health;
    }

    public void setHealth(final int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(final int attackPower) {
        this.attackPower = attackPower;
    }

    public String getPowerType() {
        return powerType;
    }

    public void setPowerType(final String powerType) {
        this.powerType = powerType;
    }

    public int getPower() {
        return power;
    }

    public void setPower(final int power) {
        this.power = power;
    }

    public int getStr() {
        return str;
    }

    public void setStr(final int str) {
        this.str = str;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(final int agi) {
        this.agi = agi;
    }

    public int getSta() {
        return sta;
    }

    public void setSta(final int sta) {
        this.sta = sta;
    }

    public int getInt() {
        return intelect;
    }

    public void setInt(final int intelect) {
        this.intelect = intelect;
    }

    public int getSpr() {
        return spr;
    }

    public void setSpr(final int spr) {
        this.spr = spr;
    }

    public int getRangedAttackPower() {
        return rangedAttackPower;
    }

    public void setRangedAttackPower(final int rangedAttackPower) {
        this.rangedAttackPower = rangedAttackPower;
    }

    public double getMastery() {
        return mastery;
    }

    public void setMastery(final double mastery) {
        this.mastery = mastery;
    }

    public int getMasteryRating() {
        return masteryRating;
    }

    public void setMasteryRating(final int masteryRating) {
        this.masteryRating = masteryRating;
    }

    public double getCrit() {
        return crit;
    }

    public void setCrit(final double crit) {
        this.crit = crit;
    }

    public int getCritRating() {
        return critRating;
    }

    public void setCritRating(final int critRating) {
        this.critRating = critRating;
    }

    public double getHitPercent() {
        return hitPercent;
    }

    public void setHitPercent(final double hitPercent) {
        this.hitPercent = hitPercent;
    }

    public int getHitRating() {
        return hitRating;
    }

    public void setHitRating(final int hitRating) {
        this.hitRating = hitRating;
    }

    public int getHasteRating() {
        return hasteRating;
    }

    public void setHasteRating(final int hasteRating) {
        this.hasteRating = hasteRating;
    }

    public int getExpertiseRating() {
        return expertiseRating;
    }

    public void setExpertiseRating(final int expertiseRating) {
        this.expertiseRating = expertiseRating;
    }

    public int getSpellPower() {
        return spellPower;
    }

    public void setSpellPower(final int spellPower) {
        this.spellPower = spellPower;
    }

    public int getSpellPen() {
        return spellPen;
    }

    public void setSpellPen(final int spellPen) {
        this.spellPen = spellPen;
    }

    public double getSpellCrit() {
        return spellCrit;
    }

    public void setSpellCrit(final double spellCrit) {
        this.spellCrit = spellCrit;
    }

    public int getSpellCritRating() {
        return spellCritRating;
    }

    public void setSpellCritRating(final int spellCritRating) {
        this.spellCritRating = spellCritRating;
    }

    public double getSpellHitPercent() {
        return spellHitPercent;
    }

    public void setSpellHitPercent(final double spellHitPercent) {
        this.spellHitPercent = spellHitPercent;
    }

    public int getSpellHitRating() {
        return spellHitRating;
    }

    public void setSpellHitRating(final int spellHitRating) {
        this.spellHitRating = spellHitRating;
    }

    public double getMana5() {
        return mana5;
    }

    public void setMana5(final double mana5) {
        this.mana5 = mana5;
    }

    public double getMana5Combat() {
        return mana5Combat;
    }

    public void setMana5Combat(final double mana5Combat) {
        this.mana5Combat = mana5Combat;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(final int armor) {
        this.armor = armor;
    }

    public double getDodge() {
        return dodge;
    }

    public void setDodge(final double dodge) {
        this.dodge = dodge;
    }

    public int getDodgeRating() {
        return dodgeRating;
    }

    public void setDodgeRating(final int dodgeRating) {
        this.dodgeRating = dodgeRating;
    }

    public double getParry() {
        return parry;
    }

    public void setParry(final double parry) {
        this.parry = parry;
    }

    public int getParryRating() {
        return parryRating;
    }

    public void setParryRating(final int parryRating) {
        this.parryRating = parryRating;
    }

    public double getBlock() {
        return block;
    }

    public void setBlock(final double block) {
        this.block = block;
    }

    public int getBlockRating() {
        return blockRating;
    }

    public void setBlockRating(final int blockRating) {
        this.blockRating = blockRating;
    }

    public int getResil() {
        return resil;
    }

    public void setResil(final int resil) {
        this.resil = resil;
    }

    public double getMainHandDmgMin() {
        return mainHandDmgMin;
    }

    public void setMainHandDmgMin(final double mainHandDmgMin) {
        this.mainHandDmgMin = mainHandDmgMin;
    }

    public double getMainHandDmgMax() {
        return mainHandDmgMax;
    }

    public void setMainHandDmgMax(final double mainHandDmgMax) {
        this.mainHandDmgMax = mainHandDmgMax;
    }

    public double getMainHandSpeed() {
        return mainHandSpeed;
    }

    public void setMainHandSpeed(final double mainHandSpeed) {
        this.mainHandSpeed = mainHandSpeed;
    }

    public double getMainHandDps() {
        return mainHandDps;
    }

    public void setMainHandDps(final double mainHandDps) {
        this.mainHandDps = mainHandDps;
    }

    public int getMainHandExpertise() {
        return mainHandExpertise;
    }

    public void setMainHandExpertise(final int mainHandExpertise) {
        this.mainHandExpertise = mainHandExpertise;
    }

    public double getOffHandDmgMin() {
        return offHandDmgMin;
    }

    public void setOffHandDmgMin(final double offHandDmgMin) {
        this.offHandDmgMin = offHandDmgMin;
    }

    public double getOffHandDmgMax() {
        return offHandDmgMax;
    }

    public void setOffHandDmgMax(final double offHandDmgMax) {
        this.offHandDmgMax = offHandDmgMax;
    }

    public double getOffHandSpeed() {
        return offHandSpeed;
    }

    public void setOffHandSpeed(final double offHandSpeed) {
        this.offHandSpeed = offHandSpeed;
    }

    public double getOffHandDps() {
        return offHandDps;
    }

    public void setOffHandDps(final double offHandDps) {
        this.offHandDps = offHandDps;
    }

    public int getOffHandExpertise() {
        return offHandExpertise;
    }

    public void setOffHandExpertise(final int offHandExpertise) {
        this.offHandExpertise = offHandExpertise;
    }

    public double getRangedDmgMin() {
        return rangedDmgMin;
    }

    public void setRangedDmgMin(final double rangedDmgMin) {
        this.rangedDmgMin = rangedDmgMin;
    }

    public double getRangedDmgMax() {
        return rangedDmgMax;
    }

    public void setRangedDmgMax(final double rangedDmgMax) {
        this.rangedDmgMax = rangedDmgMax;
    }

    public double getRangedSpeed() {
        return rangedSpeed;
    }

    public void setRangedSpeed(final double rangedSpeed) {
        this.rangedSpeed = rangedSpeed;
    }

    public double getRangedDps() {
        return rangedDps;
    }

    public void setRangedDps(final double rangedDps) {
        this.rangedDps = rangedDps;
    }

    public double getRangedCrit() {
        return rangedCrit;
    }

    public void setRangedCrit(final double rangedCrit) {
        this.rangedCrit = rangedCrit;
    }

    public int getRangedCritRating() {
        return rangedCritRating;
    }

    public void setRangedCritRating(final int rangedCritRating) {
        this.rangedCritRating = rangedCritRating;
    }

    public double getRangedHitPercent() {
        return rangedHitPercent;
    }

    public void setRangedHitPercent(final double rangedHitPercent) {
        this.rangedHitPercent = rangedHitPercent;
    }

    public int getRangedHitRating() {
        return rangedHitRating;
    }

    public void setRangedHitRating(final int rangedHitRating) {
        this.rangedHitRating = rangedHitRating;
    }
}
