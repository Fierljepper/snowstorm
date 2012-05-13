package net.snowstorm.wow.beans.characterresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
* Created by IntelliJ IDEA. User: developer Date: 2/18/12 Time: 12:29 PM To change this template use File | Settings |
* File Templates.
*/
public class TooltipParams extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("dd6a3cb9-6394-4d22-bd3d-03da28176507");

    private int enchant = -1;
    private int gem0 = -1;
    private int gem1 = -1;
    private int gem2 = -1;
    private int gem3 = -1;
    private int[] set;
    private int reforge = -1;
    private int transmogItem;

    public int getEnchant() {
        return enchant;
    }

    public void setEnchant(final int enchant) {
        this.enchant = enchant;
    }

    public int getGem0() {
        return gem0;
    }

    public void setGem0(final int gem0) {
        this.gem0 = gem0;
    }

    public int getGem1() {
        return gem1;
    }

    public void setGem1(final int gem1) {
        this.gem1 = gem1;
    }

    public int getGem2() {
        return gem2;
    }

    public void setGem2(final int gem2) {
        this.gem2 = gem2;
    }

    public int getGem3() {
        return gem3;
    }

    public void setGem3(final int gem3) {
        this.gem3 = gem3;
    }

    public int[] getSet() {
        return set;
    }

    public void setSet(final int[] set) {
        this.set = set;
    }

    public int getReforge() {
        return reforge;
    }

    public void setReforge(final int reforge) {
        this.reforge = reforge;
    }

    public int getTransmogItem() {
        return transmogItem;
    }

    public void setTransmogItem(final int transmogItem) {
        this.transmogItem = transmogItem;
    }
}
