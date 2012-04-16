package net.snowstorm.wow.beans.characterresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User;
 * File Templates.
 */
public class Profession extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("2b661ad9-b73d-457a-afe4-794774b4fb12");

    private int id;
    private String name;
    private String icon;
    private int rank;
    private int max;
    private int[] recipes;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
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

    public int getRank() {
        return rank;
    }

    public void setRank(final int rank) {
        this.rank = rank;
    }

    public int getMax() {
        return max;
    }

    public void setMax(final int max) {
        this.max = max;
    }

    public int[] getRecipes() {
        return recipes;
    }

    public void setRecipes(final int[] recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString(){
        return getName();
    }
}
