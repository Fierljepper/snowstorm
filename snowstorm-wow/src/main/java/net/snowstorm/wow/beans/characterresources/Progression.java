package net.snowstorm.wow.beans.characterresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User: developer Date: 2/18/12 Time: 2:35 PM To change this template use File | Settings |
 * File Templates.
 */
public class Progression extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("808fce5b-ccc6-42fc-bbb6-daab4828371f");

    private Collection<Raid> raids;

    public Collection<Raid> getRaids() {
        return raids;
    }

    public void setRaids(final Collection<Raid> raids) {
        this.raids = raids;
    }
}
