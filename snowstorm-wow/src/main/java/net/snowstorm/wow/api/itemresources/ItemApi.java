package net.snowstorm.wow.api.itemresources;

import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.wow.api.AbstractWowApi;
import net.snowstorm.wow.beans.itemresources.Item;

import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/18/12 Time: 9:36 AM To change this template use File | Settings |
 * File Templates.
 */
public class ItemApi  extends AbstractWowApi implements Serializable {

    private UUID uuid = UUID.fromString("6d65b948-fc00-40c6-91a4-93d6b74af8d7");

    private static transient String apiPath = "/item";

    private int itemId;

    public ItemApi(){

    }

    public ItemApi(BattlenetRegion region){
        super(region);
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(final int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String getUrl() {
        return super.getUrl() + getApiPath() + "/" + getItemId();
    }

    @Override
    public String getApiPath() {
        return this.apiPath;
    }

    @Override
    public Item getBeanPayload(final String url) throws MalformedURLException {
        return (Item) getBeanPayload(url, Item.class);
    }

    @Override
    public Item getBeanPayload(final InputStream inputStream) {
        return (Item) getBeanPayload(inputStream, Item.class);
    }
}
