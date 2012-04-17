package net.snowstorm.wow.api.auctionresources;

import net.snowstorm.wow.api.AbstractWowApi;
import net.snowstorm.wow.beans.auctionresources.CurrentAuctionsData;

import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/14/12 Time: 4:51 PM To change this template use File | Settings |
 * File Templates.
 */
public class CurrentAuctionsDataApi extends AbstractWowApi implements Serializable {

    private UUID uuid = UUID.fromString("6426953f-01fc-41c7-9f80-02c3c8c4bf19");

    private String url;

    public CurrentAuctionsDataApi(){

    }

    public CurrentAuctionsDataApi(String url){
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
    public CurrentAuctionsData getBeanPayload(final String url) throws MalformedURLException {
        return (CurrentAuctionsData) getBeanPayload(url, CurrentAuctionsData.class);
    }

    @Override
    public CurrentAuctionsData getBeanPayload(final InputStream inputStream) {
        return (CurrentAuctionsData) getBeanPayload(inputStream, CurrentAuctionsData.class);
    }
}
