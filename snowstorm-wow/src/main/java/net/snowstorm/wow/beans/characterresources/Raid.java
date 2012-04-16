package net.snowstorm.wow.beans.characterresources;

import net.snowstorm.wow.beans.WowBean;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User;
 * File Templates.
 */
public class Raid extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("7fecb4c2-8eaf-462a-b240-b9f1b3e947b4");

    private String name;
    private int normal;
    private int heroic;
    private int id;
    private Collection<Boss> bosses;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(final int normal) {
        this.normal = normal;
    }

    public int getHeroic() {
        return heroic;
    }

    public void setHeroic(final int heroic) {
        this.heroic = heroic;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Collection<Boss> getBosses() {
        return bosses;
    }

    public void setBosses(final Collection<Boss> bosses) {
        this.bosses = bosses;
    }

    @Override
    public String toString(){
        return getName();
    }
}
