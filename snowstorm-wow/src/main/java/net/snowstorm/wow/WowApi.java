package net.snowstorm.wow;

import net.snowstorm.core.url.BattlenetApiUrl;
import net.snowstorm.core.url.UrlConnectionReader;
import net.snowstorm.wow.beans.WowBean;

import java.io.InputStream;
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

    public String getJsonPayload(InputStream inputStream);

    public <T extends WowBean> T getBeanPayload(String url, Class<T> type) throws MalformedURLException ;

    public <T extends WowBean> T getBeanPayload(InputStream inputStream, Class<T> type);

    public WowBean getBeanPayload(String url) throws MalformedURLException ;

    public WowBean getBeanPayload(InputStream inputStream);

    public UrlConnectionReader getUrlConnectionReader();
}
