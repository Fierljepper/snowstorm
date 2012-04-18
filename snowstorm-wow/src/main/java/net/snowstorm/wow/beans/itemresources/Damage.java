package net.snowstorm.wow.beans.itemresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/18/12 Time: 10:47 AM To change this template use File | Settings
 * | File Templates.
 */
public class Damage extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("b4dcc97b-02d3-4f1a-8710-92a0b0022ecc");

    private int min;
    private int max;


    public int getMin() {
        return min;
    }

    public void setMin(final int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(final int max) {
        this.max = max;
    }
}
