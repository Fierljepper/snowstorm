package net.snowstorm.wow.api.auctionresources;

import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.wow.api.AbstractWowApi;
import net.snowstorm.wow.beans.auctionresources.CurrentAuctions;
import net.snowstorm.wow.beans.realmresources.Realm;

import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/14/12 Time: 4:40 PM To change this template use File | Settings |
 * File Templates.
 */
public class CurrentAuctionsApi extends AbstractWowApi implements Serializable {

    private UUID uuid = UUID.fromString("6426953f-01fc-41c7-9f80-02c3c8c4bf19");

    private static final transient String API_PATH = "/auction/data";

    private Realm realm;

    public CurrentAuctionsApi(){

    }

    public CurrentAuctionsApi(BattlenetRegion region, Realm realm){
        super(region);
        this.realm = realm;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Realm getRealm() {
        return realm;
    }

    public void setRealm(final Realm realm) {
        this.realm = realm;
    }

    @Override
    public String getApiPath() {
        return API_PATH;
    }

    @Override
    public String getUrl() {
        return super.getUrl() + getApiPath() + "/" + realm.getSlug();
    }

    @Override
    public CurrentAuctions getBeanPayload(final String url) throws MalformedURLException {
        return getBeanPayload(url, CurrentAuctions.class);
    }

    @Override
    public CurrentAuctions getBeanPayload(final InputStream inputStream) {
        return getBeanPayload(inputStream, CurrentAuctions.class);
    }
}
