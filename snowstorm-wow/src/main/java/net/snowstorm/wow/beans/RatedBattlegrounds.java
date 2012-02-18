package net.snowstorm.wow.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User: developer Date: 2/18/12 Time: 2:55 PM To change this template use File | Settings |
 * File Templates.
 */
public class RatedBattlegrounds extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("e7c12cd2-3e56-4228-bd93-6138aea6d9fe");

    private int personalRating;
    private Collection<Battleground> battlegrounds;

    public int getPersonalRating() {
        return personalRating;
    }

    public void setPersonalRating(final int personalRating) {
        this.personalRating = personalRating;
    }

    public Collection<Battleground> getBattlegrounds() {
        return battlegrounds;
    }

    public void setBattlegrounds(final Collection<Battleground> battlegrounds) {
        this.battlegrounds = battlegrounds;
    }
}
