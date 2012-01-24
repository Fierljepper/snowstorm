package net.snowstorm.wow;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/23/12
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Realm {
    
    private String type;
    private String population;
    private boolean queue;
    private boolean status;
    private String name;
    private String slug;
    private String battlegroup;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public boolean isQueue() {
        return queue;
    }

    public void setQueue(boolean queue) {
        this.queue = queue;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getBattlegroup() {
        return battlegroup;
    }

    public void setBattlegroup(String battlegroup) {
        this.battlegroup = battlegroup;
    }

    @Override
    public String toString(){
        return getName();
    }
}
