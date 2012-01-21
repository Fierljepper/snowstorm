package net.snowstorm.core.url;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/21/12
 * Time: 8:27 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractBattlenetLocales implements BattlenetLocales {

    protected Map<String, String> locales = new HashMap<String, String>();

    @Override
    public Map<String, String> getLocales() {
        return locales;
    }
}
