package net.snowstorm.wow.beans.auctionresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/16/12 Time: 10:12 PM To change this template use File | Settings
 * | File Templates.
 */
public class Auction extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("cabcd243-548d-42cd-89be-711c1541f616");

    private long auc;
    private int item;
    private String owner;
    private long bid;
    private long buyout;
    private int quantity;
    private String timeLeft;

    public UUID getUuid() {
        return uuid;
    }

    public long getAuc() {
        return auc;
    }

    public void setAuc(final long auc) {
        this.auc = auc;
    }

    public int getItem() {
        return item;
    }

    public void setItem(final int item) {
        this.item = item;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    public long getBid() {
        return bid;
    }

    public void setBid(final int bid) {
        this.bid = bid;
    }

    public long getBuyout() {
        return buyout;
    }

    public void setBuyout(final int buyout) {
        this.buyout = buyout;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(final String timeLeft) {
        this.timeLeft = timeLeft;
    }
}
