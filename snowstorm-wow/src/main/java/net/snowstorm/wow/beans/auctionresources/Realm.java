package net.snowstorm.wow.beans.auctionresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/16/12 Time: 10:01 PM To change this template use File | Settings
 * | File Templates.
 */
public class Realm  extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("e1dab4da-f21b-41de-98a1-e127471680f4");

    private String name;
    private String slug;

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(final String slug) {
        this.slug = slug;
    }
}
