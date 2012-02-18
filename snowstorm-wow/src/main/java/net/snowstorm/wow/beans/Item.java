package net.snowstorm.wow.beans;

import java.io.Serializable;
import java.util.UUID;

/**
* Created by IntelliJ IDEA. User: developer Date: 2/18/12 Time: 12:28 PM To change this template use File | Settings |
* File Templates.
*/
public class Item extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("7e3b4934-bdac-4632-af5b-00dbde130e19");

    private int id;
    private String name;
    private String icon;
    private int quality;
    private TooltipParams tooltipParams;

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

    public int getQuality() {
        return quality;
    }

    public void setQuality(final int quality) {
        this.quality = quality;
    }

    public TooltipParams getTooltipParams() {
        return tooltipParams;
    }

    public void setTooltipParams(final TooltipParams tooltipParams) {
        this.tooltipParams = tooltipParams;
    }

}
