package net.snowstorm.core.url;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/19/12
 * Time: 5:38 PM
 * To change this template use File | Settings | File Templates.
 */
public enum BattlenetRegion {
    CN,
    EU,
    KR,
    TW,
    US;


    public String getHost(){
        switch (this){
            case CN:
                return BattlenetDomain.CN_BATTLENET_DOMAIN + this.toString().toLowerCase();
            case EU:
            case KR:
            case TW:
            case US:
            default:
                return this.toString().toLowerCase() + BattlenetDomain.DEFAULT_BATTLENET_DOMAIN;
        }
    }


    public Map<String, String> getLocales() {
        switch (this){
            case CN:
                return new CnLocales().getLocales();
            case EU:
                return new EuLocales().getLocales();
            case KR:
                return new KrLocales().getLocales();
            case TW:
                return new TwLocales().getLocales();
            case US:
                return new UsLocales().getLocales();
            default:
                return null;
        }
    }

}
