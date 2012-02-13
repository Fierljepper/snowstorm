package net.snowstorm.wow.api;

import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.wow.beans.Realm;
import net.snowstorm.wow.beans.Character;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. User: developer Date: 1/31/12 Time: 3:07 PM To change this template use File | Settings |
 * File Templates.
 */
public class CharacterProfile extends WowApiImpl implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(CharacterProfile.class);

    private static transient String apiPath = "/character";

    private static transient String fieldsParameter = "?fields=";

    private Realm realm;

    private String characterName;
    
    private Collection<CharacterProfileField> characterProfileFields;

    private UUID uuid = UUID.fromString("46fc7341-fb6c-4413-b07c-c0272aafe4cf");
    
    public CharacterProfile(){
        
    }

    public CharacterProfile(BattlenetRegion region, Realm realm, String characterName){
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

    public void setCharacterProfileFields(Collection<CharacterProfileField> characterProfileFields) {
        this.characterProfileFields = characterProfileFields;
    }

    @Override
    public String getApiPath() {
        return this.apiPath;
    }

    @Override
    public String getUrl() {
        String fieldsParameter = "";
        // FIXME Not the most efficient
        // fields
        if (characterProfileFields != null && characterProfileFields.size() > 0){
            fieldsParameter = this.fieldsParameter;
            for (CharacterProfileField characterProfileField:characterProfileFields){
                fieldsParameter+= characterProfileField.toString().toLowerCase() + ",";
            }
            fieldsParameter = fieldsParameter.substring(0, fieldsParameter.length() -1);
        }

        return super.getUrl() + getApiPath() + "/" + realm.getSlug() + "/" + urlEncodedString(characterName) + fieldsParameter;
    }
    
    private String urlEncodedString(String unencodedString){
        try {
            if (unencodedString != null){
                return URLEncoder.encode(unencodedString, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            LOG.error("Character encoding is set to UTF-8, this exception should not be thrown.",
                    e);
        }
        return null;
    }

    @Override
    public Character getBeanPayload(String url) throws MalformedURLException {
        return (Character) getBeanPayload(url, Character.class);
    }
}
