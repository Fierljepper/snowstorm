package net.snowstorm.wow.beans.characterresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
* Created by IntelliJ IDEA. User: developer Date: 2/18/12 Time: 11:30 AM To change this template use File | Settings |
* File Templates.
*/
public class Glyph extends WowBean implements Serializable {


    private UUID uuid = UUID.fromString("4e486d29-55e7-4839-895f-deba3d283838");

    private int glyph;
    private int item;
    private String name;
    private String icon;

    public int getGlyph() {
        return glyph;
    }

    public void setGlyph(final int glyph) {
        this.glyph = glyph;
    }

    public int getItem() {
        return item;
    }

    public void setItem(final int item) {
        this.item = item;
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

    @Override
    public String toString(){
        return getName();
    }

}
