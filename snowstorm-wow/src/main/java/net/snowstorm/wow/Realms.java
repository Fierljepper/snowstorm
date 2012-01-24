package net.snowstorm.wow;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/23/12
 * Time: 7:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Realms {
    private List<Realm> realms;

    public void setRealms(List<Realm> realms) {
        this.realms = realms;
    }

    public List<Realm> getRealms() {
        return realms;
    }
}
