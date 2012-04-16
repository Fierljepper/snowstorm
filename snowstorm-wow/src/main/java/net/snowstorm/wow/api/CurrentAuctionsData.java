package net.snowstorm.wow.api;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/14/12 Time: 4:51 PM To change this template use File | Settings |
 * File Templates.
 */
public class CurrentAuctionsData extends AbstractWowApi implements Serializable {

    private UUID uuid = UUID.fromString("6426953f-01fc-41c7-9f80-02c3c8c4bf19");

    private String url;

    public CurrentAuctionsData(){

    }

    public CurrentAuctionsData(String url){
        this.url = url;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    @Override
    public String getApiPath() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getUrl() {
        if (this.url == null){
            return null;
        }
        return this.url;
    }

    @Override
    public net.snowstorm.wow.beans.auctionresources.CurrentAuctionsData getBeanPayload(final String url) throws MalformedURLException {
        return (net.snowstorm.wow.beans.auctionresources.CurrentAuctionsData) getBeanPayload(url, net.snowstorm.wow.beans.auctionresources.CurrentAuctionsData.class);
    }
}
