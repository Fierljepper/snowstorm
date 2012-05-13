package net.snowstorm.wow.api.characterresources;

import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.core.utils.StringHelper;
import net.snowstorm.wow.api.AbstractWowApi;
import net.snowstorm.wow.beans.characterresources.CharacterProfile;
import net.snowstorm.wow.beans.realmresources.Realm;

import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User: developer Date: 1/31/12 Time: 3:07 PM To change this template use File | Settings |
 * File Templates.
 */
public class CharacterProfileApi extends AbstractWowApi implements Serializable {

    private UUID uuid = UUID.fromString("46fc7341-fb6c-4413-b07c-c0272aafe4cf");

    private static final transient String API_PATH = "/character";

    private static transient String fieldsParameter = "?fields=";

    private Realm realm;

    private String characterName;
    
    private Collection<CharacterProfileField> characterProfileFields = new HashSet<CharacterProfileField>();
    
    public CharacterProfileApi(){
        
    }

    public CharacterProfileApi(BattlenetRegion region, Realm realm, String characterName){
        super(region);
        this.realm = realm;
        this.characterName = characterName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Realm getRealm() {
        return realm;
    }

    public void setRealm(final Realm realm) {
        this.realm = realm;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(final String characterName) {
        this.characterName = characterName;
    }

    public Collection<CharacterProfileField> getCharacterProfileFields() {
        return characterProfileFields;
    }

    public void setCharacterProfileField(CharacterProfileField characterProfileField) {
        this.characterProfileFields.add(characterProfileField);
    }

    public void setCharacterProfileFields(Collection<CharacterProfileField> characterProfileFields) {
        this.characterProfileFields = characterProfileFields;
    }

    @Override
    public String getApiPath() {
        return API_PATH;
    }

    @Override
    public String getUrl() {
        String fieldsParameter = "";
        // fields
        if (characterProfileFields != null && characterProfileFields.size() > 0){
            fieldsParameter = this.fieldsParameter;
            for (CharacterProfileField characterProfileField:characterProfileFields){
                fieldsParameter+= characterProfileField.toString().toLowerCase() + ",";
            }
            fieldsParameter = fieldsParameter.substring(0, fieldsParameter.length() -1);
        }

        return super.getUrl() + getApiPath() + "/" + realm.getSlug() + "/" + StringHelper.urlEncodeString
                (characterName) + fieldsParameter;
    }
    


    @Override
    public CharacterProfile getBeanPayload(String url) throws MalformedURLException {
        return getBeanPayload(url, CharacterProfile.class);
    }

    @Override
    public CharacterProfile getBeanPayload(final InputStream inputStream) {
        return getBeanPayload(inputStream, CharacterProfile.class);
    }

    public enum CharacterProfileField {
        GUILD,
        STATS,
        TALENTS,
        ITEMS,
        REPUTATION,
        TITLES,
        PROFESSIONS,
        APPEARANCE,
        COMPANIONS,
        MOUNTS,
        PETS,
        ACHIEVEMENTS,
        PROGRESSION,
        PVP,
        QUESTS;

        @Override
        public String toString(){
            return StringHelper.capitalize(super.toString());
        }
    }
}
