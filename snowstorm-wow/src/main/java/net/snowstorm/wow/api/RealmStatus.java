package net.snowstorm.wow.api;

import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.wow.beans.Realm;
import net.snowstorm.wow.beans.Realms;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/19/12
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class RealmStatus extends WowApiImpl implements Serializable {

    private String apiPath = "/realm/status";

    private String realmsParameter = "?realms=";

    private Collection<Realm> realms;

    private UUID uuid = UUID.fromString("a48adaaf-a360-4bb7-952c-69aba971efe7");

    public RealmStatus(){

    }

    public RealmStatus(BattlenetRegion region) {
        super(region);
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

    @Override
    public String getUrl() {
        String realmsParameter = "";
        // FIXME Not the most efficient
        if (realms != null && realms.size() > 0){
            realmsParameter = this.realmsParameter;
            for (Realm realm:realms){
                realmsParameter+= realm.getSlug() + ",";
            }
            realmsParameter = realmsParameter.substring(0, realmsParameter.length() -1);
        }

        return super.getUrl() + getApiPath() + realmsParameter;
    }

    @Override
    public String getApiPath() {
        return apiPath;
    }

    @Override
    public Realms getBeanPayload(String url) throws MalformedURLException {
        return (Realms) getBeanPayload(url, Realms.class);
    }

}
