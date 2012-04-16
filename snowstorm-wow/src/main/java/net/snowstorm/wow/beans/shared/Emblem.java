package net.snowstorm.wow.beans.shared;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
* Created by IntelliJ IDEA. User: developer Date: 2/18/12 Time: 11:30 AM To change this template use File | Settings |
* File Templates.
*/
public class Emblem extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("516c0f61-18f3-49b9-95cd-2498bdf2e67d");

    private int icon;
    private String iconColor;
    private int border;
    private String borderColor;
    private String backgroundColor;

    public int getIcon() {
        return icon;
    }

    public void setIcon(final int icon) {
        this.icon = icon;
    }

    public String getIconColor() {
        return iconColor;
    }

    public void setIconColor(final String iconColor) {
        this.iconColor = iconColor;
    }

    public int getBorder() {
        return border;
    }

    public void setBorder(final int border) {
        this.border = border;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(final String borderColor) {
        this.borderColor = borderColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(final String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
