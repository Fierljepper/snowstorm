package net.snowstorm.wow.beans.currentauctions;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/14/12 Time: 5:10 PM To change this template use File | Settings |
 * File Templates.
 */
public class CurrentAuctions extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("6da737fb-aa6f-4e27-8d77-10911c92641b");

    private File[] files;

    public UUID getUuid() {
        return uuid;
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(final File[] files) {
        this.files = files;
    }
}
