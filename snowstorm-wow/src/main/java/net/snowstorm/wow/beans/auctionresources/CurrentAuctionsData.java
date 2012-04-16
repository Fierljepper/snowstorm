package net.snowstorm.wow.beans.auctionresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/16/12 Time: 9:57 PM To change this template use File | Settings |
 * File Templates.
 */
public class CurrentAuctionsData extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("09905807-810b-413f-aada-010e21b4a247");

    private Realm realm;
    private Alliance alliance;
    private Horde horde;
    private Neutral neutral;

    public UUID getUuid() {
        return uuid;
    }

    public Realm getRealm() {
        return realm;
    }

    public void setRealm(final Realm realm) {
        this.realm = realm;
    }

    public Alliance getAlliance() {
        return alliance;
    }

    public void setAlliance(final Alliance alliance) {
        this.alliance = alliance;
    }

    public Horde getHorde() {
        return horde;
    }

    public void setHorde(final Horde horde) {
        this.horde = horde;
    }

    public Neutral getNeutral() {
        return neutral;
    }

    public void setNeutral(final Neutral neutral) {
        this.neutral = neutral;
    }
}
