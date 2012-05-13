package net.snowstorm.wow.beans.itemresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/18/12 Time: 9:55 AM To change this template use File | Settings |
 * File Templates.
 */
public class Item extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("48b65da2-d50c-48f4-9172-250154d7c108");

    private int id;
    private int disenchantingSkillRank;
    private String description;
    private String name;
    private String icon;
    private int stackable;
    private int[] allowableClasses;
    private int itemBind;
    private Collection<BonusStat> bonusStats;
    private Collection<ItemSpell> itemSpells;
    private long buyPrice;
    private int itemClass;
    private int itemSubClass;
    private int containerSlots;
    private WeaponInfo weaponInfo;
    private int inventoryType;
    private boolean equippable;
    private int itemLevel;
    private ItemSet itemSet;
    private int maxCount;
    private int maxDurability;
    private int minFactionId;
    private int minReputation;
    private int quality;
    private long sellPrice;
    private int requiredSkill;
    private RequiredAbility requiredAbility;
    private int requiredLevel;
    private int requiredSkillRank;
    private SocketInfo socketInfo;
    private ItemSource itemSource;
    private int baseArmor;
    private boolean hasSockets;
    private boolean isAuctionable;
    private int armor;


    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getDisenchantingSkillRank() {
        return disenchantingSkillRank;
    }

    public void setDisenchantingSkillRank(final int disenchantingSkillRank) {
        this.disenchantingSkillRank = disenchantingSkillRank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(final String icon) {
        this.icon = icon;
    }

    public int getStackable() {
        return stackable;
    }

    public void setStackable(final int stackable) {
        this.stackable = stackable;
    }

    public int[] getAllowableClasses() {
        return allowableClasses;
    }

    public void setAllowableClasses(final int[] allowableClasses) {
        this.allowableClasses = allowableClasses;
    }

    public int getItemBind() {
        return itemBind;
    }

    public void setItemBind(final int itemBind) {
        this.itemBind = itemBind;
    }

    public Collection<BonusStat> getBonusStats() {
        return bonusStats;
    }

    public void setBonusStats(final Collection<BonusStat> bonusStats) {
        this.bonusStats = bonusStats;
    }

    public Collection<ItemSpell> getItemSpells() {
        return itemSpells;
    }

    public void setItemSpells(final Collection<ItemSpell> itemSpells) {
        this.itemSpells = itemSpells;
    }

    public long getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(final long buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getItemClass() {
        return itemClass;
    }

    public void setItemClass(final int itemClass) {
        this.itemClass = itemClass;
    }

    public int getItemSubClass() {
        return itemSubClass;
    }

    public void setItemSubClass(final int itemSubClass) {
        this.itemSubClass = itemSubClass;
    }

    public int getContainerSlots() {
        return containerSlots;
    }

    public void setContainerSlots(final int containerSlots) {
        this.containerSlots = containerSlots;
    }

    public WeaponInfo getWeaponInfo() {
        return weaponInfo;
    }

    public void setWeaponInfo(final WeaponInfo weaponInfo) {
        this.weaponInfo = weaponInfo;
    }

    public int getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(final int inventoryType) {
        this.inventoryType = inventoryType;
    }

    public boolean isEquippable() {
        return equippable;
    }

    public void setEquippable(final boolean equippable) {
        this.equippable = equippable;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(final int itemLevel) {
        this.itemLevel = itemLevel;
    }

    public ItemSet getItemSet() {
        return itemSet;
    }

    public void setItemSet(final ItemSet itemSet) {
        this.itemSet = itemSet;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(final int maxCount) {
        this.maxCount = maxCount;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public void setMaxDurability(final int maxDurability) {
        this.maxDurability = maxDurability;
    }

    public int getMinFactionId() {
        return minFactionId;
    }

    public void setMinFactionId(final int minFactionId) {
        this.minFactionId = minFactionId;
    }

    public int getMinReputation() {
        return minReputation;
    }

    public void setMinReputation(final int minReputation) {
        this.minReputation = minReputation;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(final int quality) {
        this.quality = quality;
    }

    public long getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(final long sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getRequiredSkill() {
        return requiredSkill;
    }

    public void setRequiredSkill(final int requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    public RequiredAbility getRequiredAbility() {
        return requiredAbility;
    }

    public void setRequiredAbility(final RequiredAbility requiredAbility) {
        this.requiredAbility = requiredAbility;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(final int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public int getRequiredSkillRank() {
        return requiredSkillRank;
    }

    public void setRequiredSkillRank(final int requiredSkillRank) {
        this.requiredSkillRank = requiredSkillRank;
    }

    public SocketInfo getSocketInfo() {
        return socketInfo;
    }

    public void setSocketInfo(final SocketInfo socketInfo) {
        this.socketInfo = socketInfo;
    }

    public ItemSource getItemSource() {
        return itemSource;
    }

    public void setItemSource(final ItemSource itemSource) {
        this.itemSource = itemSource;
    }

    public int getBaseArmor() {
        return baseArmor;
    }

    public void setBaseArmor(final int baseArmor) {
        this.baseArmor = baseArmor;
    }

    public boolean isHasSockets() {
        return hasSockets;
    }

    public void setHasSockets(final boolean hasSockets) {
        this.hasSockets = hasSockets;
    }

    public boolean isAuctionable() {
        return isAuctionable;
    }

    public void setAuctionable(final boolean auctionable) {
        isAuctionable = auctionable;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(final int armor) {
        this.armor = armor;
    }
}
