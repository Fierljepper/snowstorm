package net.snowstorm.wow.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User: developer Date: 2/18/12 Time: 2:54 PM To change this template use File | Settings |
 * File Templates.
 */
public class Pvp extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("81dd0689-000f-4863-b5d3-2589ab7e7407");

    private RatedBattlegrounds ratedBattlegrounds;
    private Collection<ArenaTeam> arenaTeams;
    private int totalHonorableKills;

    public RatedBattlegrounds getRatedBattlegrounds() {
        return ratedBattlegrounds;
    }

    public void setRatedBattlegrounds(final RatedBattlegrounds ratedBattlegrounds) {
        this.ratedBattlegrounds = ratedBattlegrounds;
    }

    public Collection<ArenaTeam> getArenaTeams() {
        return arenaTeams;
    }

    public void setArenaTeams(final Collection<ArenaTeam> arenaTeams) {
        this.arenaTeams = arenaTeams;
    }

    public int getTotalHonorableKills() {
        return totalHonorableKills;
    }

    public void setTotalHonorableKills(final int totalHonorableKills) {
        this.totalHonorableKills = totalHonorableKills;
    }
}
