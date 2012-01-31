package net.snowstorm.wow;

import net.snowstorm.core.url.BattlenetApiUrl;
import net.snowstorm.core.url.UrlConnectionReader;

import java.net.MalformedURLException;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/19/12
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface WowApi extends BattlenetApiUrl {

    public String getUrl();
    
    public String getApiPath();

    public String getJsonPayload(String url) throws MalformedURLException;

    public UrlConnectionReader getUrlConnectionReader();
}
