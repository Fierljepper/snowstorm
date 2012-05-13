package net.snowstorm.core.url;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: developer
 * Date: 1/28/12
 * Time: 10:37 AM
 * To change this template use File | Settings | File Templates.
 */
public interface BattlenetApiUrl {

    public String getScheme();

    public void setScheme(String scheme);

    public BattlenetRegion getRegion();

    public void setRegion(BattlenetRegion region);

    public String getLocale();

    public void setLocale(String locale);

    public Map<String, String> getLocales();

    public String getHost();

    public String getGlobalApiPath();

    public void setGlobalApiPath(String globalApiPath);

    public String getUrl();
}
