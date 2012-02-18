package net.snowstorm.wow.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User: developer Date: 2/18/12 Time: 1:48 PM To change this template use File | Settings |
 * File Templates.
 */
public class Professions extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("c2a212b8-b7dd-4502-a9b1-17e8a0021b24");
    
    private Collection<Profession> primary;
    private Collection<Profession> secondary;

    public Collection<Profession> getPrimary() {
        return primary;
    }

    public void setPrimary(final Collection<Profession> primary) {
        this.primary = primary;
    }

    public Collection<Profession> getSecondary() {
        return secondary;
    }

    public void setSecondary(final Collection<Profession> secondary) {
        this.secondary = secondary;
    }
}
