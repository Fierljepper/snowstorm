package net.snowstorm.gui.wow.pojo;

import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.wow.Realm;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/23/12
 * Time: 10:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class RealmStatus implements Serializable {

    private BattlenetRegion battlenetRegion;
    private Collection<Realm> realms;
    private UUID uuid;

    public RealmStatus(){
        uuid = UUID.randomUUID();
    }

    public BattlenetRegion getBattlenetRegion() {
        return battlenetRegion;
    }

    public void setBattlenetRegion(BattlenetRegion battlenetRegion) {
        this.battlenetRegion = battlenetRegion;
    }

    public Collection<Realm> getRealms() {
        return realms;
    }

    public void setRealms(Collection<Realm> realms) {
        this.realms = realms;
    }

    public UUID getUuid() {
        return uuid;
    }
}
