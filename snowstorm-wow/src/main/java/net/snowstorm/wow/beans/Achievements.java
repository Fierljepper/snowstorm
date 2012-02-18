package net.snowstorm.wow.beans;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User: developer Date: 2/18/12 Time: 2:24 PM To change this template use File | Settings |
 * File Templates.
 */
public class Achievements extends WowBean implements Serializable {

    private UUID uuid = UUID.fromString("816f8009-c071-4890-9421-eddc86f5be30");

    private int[] achievementsCompleted;
    private long[] achievementsCompletedTimestamp;
    private int[] criteria;
    private int[] criteriaQuantity;
    private long[] criteriaTimestamp;
    private long[] criteriaCreated;

    public int[] getAchievementsCompleted() {
        return achievementsCompleted;
    }

    public void setAchievementsCompleted(final int[] achievementsCompleted) {
        this.achievementsCompleted = achievementsCompleted;
    }

    public long[] getAchievementsCompletedTimestamp() {
        return achievementsCompletedTimestamp;
    }

    public void setAchievementsCompletedTimestamp(final long[] achievementsCompletedTimestamp) {
        this.achievementsCompletedTimestamp = achievementsCompletedTimestamp;
    }

    public int[] getCriteria() {
        return criteria;
    }

    public void setCriteria(final int[] criteria) {
        this.criteria = criteria;
    }

    public int[] getCriteriaQuantity() {
        return criteriaQuantity;
    }

    public void setCriteriaQuantity(final int[] criteriaQuantity) {
        this.criteriaQuantity = criteriaQuantity;
    }

    public long[] getCriteriaTimestamp() {
        return criteriaTimestamp;
    }

    public void setCriteriaTimestamp(final long[] criteriaTimestamp) {
        this.criteriaTimestamp = criteriaTimestamp;
    }

    public long[] getCriteriaCreated() {
        return criteriaCreated;
    }

    public void setCriteriaCreated(final long[] criteriaCreated) {
        this.criteriaCreated = criteriaCreated;
    }
}
