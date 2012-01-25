package net.snowstorm.wow.api;

import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.core.url.BattlenetApiUrl;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/19/12
 * Time: 5:48 PM
 * To change this template use File | Settings | File Templates.
 */
class WowApiUrl extends BattlenetApiUrl {
    
    private String wowPath = "/wow";

    public WowApiUrl(){

    }

    public WowApiUrl(BattlenetRegion region) {
        super(region);
    }

    public String getWowPath() {
        return wowPath;
    }

    public void setWowPath(String wowPath) {
        this.wowPath = wowPath;
    }
    
    @Override
    public String getUrl(){
        return super.getUrl() + getWowPath();
    }
}
