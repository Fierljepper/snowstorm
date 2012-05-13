package net.snowstorm.wow.beans.itemresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 5/13/12 Time: 2:25 PM To change this template use File | Settings |
 * File Templates.
 */
public class SetBonus extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("e036852f-7a99-4c79-a251-a35deec4b37e");

    private String description;
    private int threshold;

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(final int threshold) {
        this.threshold = threshold;
    }
}
