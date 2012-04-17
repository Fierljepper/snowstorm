package net.snowstorm.wow.beans.auctionresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/16/12 Time: 9:47 PM To change this template use File | Settings |
 * File Templates.
 */
public class File extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("28223dae-7fd3-4070-bdbd-279d4b791c5b");

    private String url;
    private long lastModified;

    public UUID getUuid() {
        return uuid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(final long lastModified) {
        this.lastModified = lastModified;
    }
}
