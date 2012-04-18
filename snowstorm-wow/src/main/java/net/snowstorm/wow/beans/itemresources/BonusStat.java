package net.snowstorm.wow.beans.itemresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/18/12 Time: 10:04 AM To change this template use File | Settings
 * | File Templates.
 */
public class BonusStat extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("f3634d78-dc48-4224-8211-b8d9cd9acf75");

    private int stat;
    private int amount;
    private boolean reforged;

    public int getStat() {
        return stat;
    }

    public void setStat(final int stat) {
        this.stat = stat;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(final int amount) {
        this.amount = amount;
    }

    public boolean isReforged() {
        return reforged;
    }

    public void setReforged(final boolean reforged) {
        this.reforged = reforged;
    }
}
