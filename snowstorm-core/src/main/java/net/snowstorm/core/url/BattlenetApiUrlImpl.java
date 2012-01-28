package net.snowstorm.core.url;

import java.util.Map;

public class BattlenetApiUrlImpl implements BattlenetApiUrl {

    private String scheme = "http://";
    private BattlenetRegion region;
    private Map<String, String> locales;
    private String host;
    private String globalApiPath = "/api";
    private String locale;

    public BattlenetApiUrlImpl(){

    }

    public BattlenetApiUrlImpl(BattlenetRegion region){
        setRegion(region);
    }

    @Override
    public String getScheme() {
        return scheme;
    }

    @Override
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @Override
    public BattlenetRegion getRegion() {
        return region;
    }

    @Override
    public void setRegion(BattlenetRegion region) {
        this.region = region;
        this.locales = region.getLocales();
        this.host = region.getHost();
    }

    @Override
    public String getDomain() {
        return host;
    }

    @Override
    public String getLocale() {
        return "/" + locale;
    }

    @Override
    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public Map<String, String> getLocales() {
        return locales;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public String getGlobalApiPath() {
        return globalApiPath;
    }

    @Override
    public void setGlobalApiPath(String globalApiPath) {
        this.globalApiPath = globalApiPath;
    }

    @Override
    public String getUrl(){
        return getScheme() + getHost() + getGlobalApiPath();
    }
}
