package net.snowstorm.wow.beans.itemresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/18/12 Time: 10:38 AM To change this template use File | Settings
 * | File Templates.
 */
public class WeaponInfo extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("48f56be2-894c-48f8-ba4b-14d318b40581");

    private Damage damage;
    private double weaponSpeed;
    private double dps;
}
