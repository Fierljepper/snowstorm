package net.snowstorm.wow.api;

import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.core.utils.StringHelper;
import net.snowstorm.wow.beans.GuildProfile;
import net.snowstorm.wow.beans.Realm;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User: developer Date: 2/18/12 Time: 6:41 PM To change this template use File | Settings |
 * File Templates.
 */
public class GuildProfileApi extends AbstractWowApi implements Serializable {

    private UUID uuid = UUID.fromString("96746417-2a98-4757-b2a4-264c56d15ab4");

    private static transient String apiPath = "/guild";

    private static transient String fieldsParameter = "?fields=";

    private Realm realm;
    
    private String guildName;

    private Collection<GuildProfileField> guildProfileFields;


    public GuildProfileApi(){

    }

    public GuildProfileApi(BattlenetRegion region, Realm realm, String guildName){
        super(region);
        this.realm = realm;
        this.guildName = guildName;
    }


    public static String getFieldsParameter() {
        return fieldsParameter;
    }

    public static void setFieldsParameter(final String fieldsParameter) {
        GuildProfileApi.fieldsParameter = fieldsParameter;
    }

    public Realm getRealm() {
        return realm;
    }

    public void setRealm(final Realm realm) {
        this.realm = realm;
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(final String guildName) {
        this.guildName = guildName;
    }

    public Collection<GuildProfileField> getGuildProfileFields() {
        return guildProfileFields;
    }

    public void setGuildProfileFields(final Collection<GuildProfileField> guildProfileFields) {
        this.guildProfileFields = guildProfileFields;
    }

    @Override
    public String getUrl() {
        String fieldsParameter = "";
        // fields
        if (guildProfileFields != null && guildProfileFields.size() > 0){
            fieldsParameter = this.fieldsParameter;
            for (GuildProfileField guildProfileField:guildProfileFields){
                fieldsParameter+= guildProfileField.toString().toLowerCase() + ",";
            }
            fieldsParameter = fieldsParameter.substring(0, fieldsParameter.length() -1);
        }

        return super.getUrl() + getApiPath() + "/" + realm.getSlug() + "/" + StringHelper.urlEncodeString
                (guildName) + fieldsParameter;
    }

    @Override
    public String getApiPath() {
        return this.apiPath;
    }

    @Override
    public GuildProfile getBeanPayload(final String url) throws MalformedURLException {
        return  (GuildProfile)getBeanPayload(url, GuildProfile.class);
    }

    public enum GuildProfileField{
        ACHIEVEMENTS,
        MEMBERS;

        @Override
        public String toString(){
            return StringHelper.capitalize(super.toString());
        }
    }
}
