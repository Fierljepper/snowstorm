package net.snowstorm.core.url;

import java.util.Map;

public class BattlenetUrl {

    private String scheme = "http://";
    private BattlenetRegion region;
    private Map<String, String> locales;
    private String host;
    private String locale;

    public BattlenetUrl(BattlenetRegion region){
        setRegion(region);
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public BattlenetRegion getRegion() {
        return region;
    }

    public void setRegion(BattlenetRegion region) {
        this.region = region;
        this.locales = region.getLocales();
        this.host = region.getHost();
    }

    public String getDomain() {
        return host;
    }

    public String getLocale() {
        return "/" + locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Map<String, String> getLocales() {
        return locales;
    }

    public String getHost() {
        return host;
    }

    public String getUrl(){
        return getScheme() + getHost();
    }
}
