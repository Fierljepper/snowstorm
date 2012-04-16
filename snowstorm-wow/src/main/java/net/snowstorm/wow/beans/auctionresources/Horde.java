package net.snowstorm.wow.beans.auctionresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/16/12 Time: 10:07 PM To change this template use File | Settings
 * | File Templates.
 */
public class Horde extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("25388168-85ee-4a98-8fa8-7c6e031e0316");

    private Auction[] auctions;

    public Auction[] getAuctions() {
        return auctions;
    }

    public void setAuctions(final Auction[] auctions) {
        this.auctions = auctions;
    }
}
