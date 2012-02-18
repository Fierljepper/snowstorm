package net.snowstorm.wow.beans;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User;
 * File Templates.
 */
public class Items extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("d904490e-01ca-4381-be6a-e185ab8d97b4");

    private int averageItemLevel;
    private int averageItemLevelEquipped;

    private Item head;
    private Item neck;
    private Item shoulder;
    private Item back;
    private Item chest;
    private Item shirt;
    private Item tabard;
    private Item wrist;
    private Item hands;
    private Item waist;
    private Item legs;
    private Item feet;
    private Item finger1;
    private Item finger2;
    private Item trinket1;
    private Item trinket2;
    private Item mainHand;
    private Item offHand;
    private Item ranged;

    public int getAverageItemLevel() {
        return averageItemLevel;
    }

    public void setAverageItemLevel(final int averageItemLevel) {
        this.averageItemLevel = averageItemLevel;
    }

    public int getAverageItemLevelEquipped() {
        return averageItemLevelEquipped;
    }

    public void setAverageItemLevelEquipped(final int averageItemLevelEquipped) {
        this.averageItemLevelEquipped = averageItemLevelEquipped;
    }

    public Item getHead() {
        return head;
    }

    public void setHead(final Item head) {
        this.head = head;
    }

    public Item getNeck() {
        return neck;
    }

    public void setNeck(final Item neck) {
        this.neck = neck;
    }

    public Item getShoulder() {
        return shoulder;
    }

    public void setShoulder(final Item shoulder) {
        this.shoulder = shoulder;
    }

    public Item getBack() {
        return back;
    }

    public void setBack(final Item back) {
        this.back = back;
    }

    public Item getChest() {
        return chest;
    }

    public void setChest(final Item chest) {
        this.chest = chest;
    }

    public Item getShirt() {
        return shirt;
    }

    public void setShirt(final Item shirt) {
        this.shirt = shirt;
    }

    public Item getTabard() {
        return tabard;
    }

    public void setTabard(final Item tabard) {
        this.tabard = tabard;
    }

    public Item getWrist() {
        return wrist;
    }

    public void setWrist(final Item wrist) {
        this.wrist = wrist;
    }

    public Item getHands() {
        return hands;
    }

    public void setHands(final Item hands) {
        this.hands = hands;
    }

    public Item getWaist() {
        return waist;
    }

    public void setWaist(final Item waist) {
        this.waist = waist;
    }

    public Item getLegs() {
        return legs;
    }

    public void setLegs(final Item legs) {
        this.legs = legs;
    }

    public Item getFeet() {
        return feet;
    }

    public void setFeet(final Item feet) {
        this.feet = feet;
    }

    public Item getFinger1() {
        return finger1;
    }

    public void setFinger1(final Item finger1) {
        this.finger1 = finger1;
    }

    public Item getFinger2() {
        return finger2;
    }

    public void setFinger2(final Item finger2) {
        this.finger2 = finger2;
    }

    public Item getTrinket1() {
        return trinket1;
    }

    public void setTrinket1(final Item trinket1) {
        this.trinket1 = trinket1;
    }

    public Item getTrinket2() {
        return trinket2;
    }

    public void setTrinket2(final Item trinket2) {
        this.trinket2 = trinket2;
    }

    public Item getMainHand() {
        return mainHand;
    }

    public void setMainHand(final Item mainHand) {
        this.mainHand = mainHand;
    }

    public Item getOffHand() {
        return offHand;
    }

    public void setOffHand(final Item offHand) {
        this.offHand = offHand;
    }

    public Item getRanged() {
        return ranged;
    }

    public void setRanged(final Item ranged) {
        this.ranged = ranged;
    }

}
