package net.snowstorm.wow.beans.characterresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User;
 * File Templates.
 */
public class Appearance extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("347e9315-c8ca-421a-b033-98023b6d36ee");

    private int faceVariation;
    private int skinColor;
    private int hairVariation;
    private int hairColor;
    private int featureVariation;
    private boolean showHelm;
    private boolean showCloak;

    public int getFaceVariation() {
        return faceVariation;
    }

    public void setFaceVariation(final int faceVariation) {
        this.faceVariation = faceVariation;
    }

    public int getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(final int skinColor) {
        this.skinColor = skinColor;
    }

    public int getHairVariation() {
        return hairVariation;
    }

    public void setHairVariation(final int hairVariation) {
        this.hairVariation = hairVariation;
    }

    public int getHairColor() {
        return hairColor;
    }

    public void setHairColor(final int hairColor) {
        this.hairColor = hairColor;
    }

    public int getFeatureVariation() {
        return featureVariation;
    }

    public void setFeatureVariation(final int featureVariation) {
        this.featureVariation = featureVariation;
    }

    public boolean isShowHelm() {
        return showHelm;
    }

    public void setShowHelm(final boolean showHelm) {
        this.showHelm = showHelm;
    }

    public boolean isShowCloak() {
        return showCloak;
    }

    public void setShowCloak(final boolean showCloak) {
        this.showCloak = showCloak;
    }
}
