package net.snowstorm.wow.beans.characterresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
* Created by IntelliJ IDEA. User: developer Date: 2/18/12 Time: 1:06 PM To change this template use File | Settings |
* File Templates.
*/
public class Tree extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("21c1467c-9d91-4d63-8bc7-7bebc49b4716");

    private String points;
    private int total;

    public String getPoints() {
        return points;
    }

    public void setPoints(final String points) {
        this.points = points;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(final int total) {
        this.total = total;
    }
}
