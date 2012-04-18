package net.snowstorm.wow.beans.itemresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/18/12 Time: 10:20 AM To change this template use File | Settings
 * | File Templates.
 */
public class Socket extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("8bfa441e-0f8c-4815-97f1-74d7ae8f1722");

    private String[] type;

    public String[] getType() {
        return type;
    }

    public void setType(final String[] type) {
        this.type = type;
    }
}
