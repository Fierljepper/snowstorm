package net.snowstorm.wow.beans.itemresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/18/12 Time: 10:40 AM To change this template use File | Settings
 * | File Templates.
 */
public class Spell extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("4d49dd12-01bb-4b06-a1eb-637547756155");

    private int id;
    private String name;
    private String icon;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
