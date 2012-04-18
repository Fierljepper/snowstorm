package net.snowstorm.wow.beans.itemresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/18/12 Time: 10:09 AM To change this template use File | Settings
 * | File Templates.
 */
public class ItemSpell extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("01890ee9-af59-4412-b838-143895e4f03b");

    private int spellId;
    private Spell spell;
    private int nCharges;
    private boolean consumable;
    private int categoryId;

    public int getSpellId() {
        return spellId;
    }

    public void setSpellId(final int spellId) {
        this.spellId = spellId;
    }

    public Spell getSpell() {
        return spell;
    }

    public void setSpell(final Spell spell) {
        this.spell = spell;
    }

    public int getnCharges() {
        return nCharges;
    }

    public void setnCharges(final int nCharges) {
        this.nCharges = nCharges;
    }

    public boolean isConsumable() {
        return consumable;
    }

    public void setConsumable(final boolean consumable) {
        this.consumable = consumable;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(final int categoryId) {
        this.categoryId = categoryId;
    }
}
