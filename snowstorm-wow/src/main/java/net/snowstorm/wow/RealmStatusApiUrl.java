package net.snowstorm.wow;

import net.snowstorm.core.url.BattlenetRegion;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/19/12
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class RealmStatusApiUrl extends WowApiUrl implements WowApi{

    private String apiPath = "/realm/status";


    public RealmStatusApiUrl(){

    }

    public RealmStatusApiUrl(BattlenetRegion region) {
        super(region);
    }

    @Override
    public String getUrl() {
        return super.getUrl() + getApiPath();
    }

    @Override
    public String getApiPath() {
        return apiPath;
    }
}
