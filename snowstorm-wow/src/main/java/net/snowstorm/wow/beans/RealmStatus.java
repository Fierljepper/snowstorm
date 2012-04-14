package net.snowstorm.wow.beans;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/23/12
 * Time: 7:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class RealmStatus extends WowBean implements Serializable {
    private List<Realm> realms;

    private UUID uuid = UUID.fromString("7f4f6f23-d49d-4b43-9011-a28877f528b2");

    public void setRealms(List<Realm> realms) {
        this.realms = realms;
    }

    public List<Realm> getRealms() {
        return realms;
    }
}
