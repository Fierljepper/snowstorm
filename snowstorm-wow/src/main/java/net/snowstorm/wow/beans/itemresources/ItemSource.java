package net.snowstorm.wow.beans.itemresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/18/12 Time: 10:27 AM To change this template use File | Settings
 * | File Templates.
 */
public class ItemSource extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("2e301193-a038-4154-b922-66e84f50cf66");

    private int sourceId;
    private String sourceType;

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(final int sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(final String sourceType) {
        this.sourceType = sourceType;
    }
}
