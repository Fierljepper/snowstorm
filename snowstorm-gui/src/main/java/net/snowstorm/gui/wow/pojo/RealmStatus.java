package net.snowstorm.gui.wow.pojo;

import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.wow.Realm;

import java.io.Serializable;
import java.util.List;
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
    private List<Realm> realmList;
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

    public List<Realm> getRealmList() {
        return realmList;
    }

    public void setRealmList(List<Realm> realmList) {
        this.realmList = realmList;
    }

    public UUID getUuid() {
        return uuid;
    }
}
