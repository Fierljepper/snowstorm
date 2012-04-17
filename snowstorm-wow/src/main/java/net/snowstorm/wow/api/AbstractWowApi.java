package net.snowstorm.wow.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import net.snowstorm.core.url.BattlenetApiUrlImpl;
import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.core.url.UrlConnectionReader;
import net.snowstorm.wow.WowApi;
import net.snowstorm.wow.beans.WowBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/19/12
 * Time: 5:48 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractWowApi extends BattlenetApiUrlImpl implements WowApi, Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractWowApi.class);

    private static transient String wowPath = "/wow";

    UrlConnectionReader urlConnectionReader = new UrlConnectionReader();

    private UUID uuid = UUID.fromString("b043009c-93d6-438c-9bb6-1a76dd12bf7f");

    public AbstractWowApi(){

    }

    public AbstractWowApi(BattlenetRegion region) {
        super(region);
    }

    public String getWowPath() {
        return wowPath;
    }

    public void setWowPath(String wowPath) {
        this.wowPath = wowPath;
    }
    
    @Override
    public String getUrl(){
        return super.getUrl() + getWowPath();
    }

    @Override
    abstract public String getApiPath();

    @Override
    public UrlConnectionReader getUrlConnectionReader() {
        return urlConnectionReader;
    }


    // TODO move to snowstorm-core if API's from other Blizz games deliver a JSON payload
    // Convenience method
    @Override
    public String getJsonPayload(String url) throws MalformedURLException {
        InputStream inputStream = urlConnectionReader.fetch(new URL(url));
        return getJsonPayload(inputStream);
    }

    // TODO move to snowstorm-core if API's from other Blizz games deliver a JSON payload
    @Override
    public String getJsonPayload(InputStream inputStream){
        if (inputStream != null){
            JsonReader reader = getJsonReader(inputStream, "UTF-8");
            return prettyPrint(reader);
        }
        return null;
    }

    // Convenience method
    public WowBean getBeanPayload(String url, Class type) throws MalformedURLException {
        InputStream inputStream = urlConnectionReader.fetch(new URL(url));
        return getBeanPayload(inputStream, type);
    }

    public WowBean getBeanPayload(InputStream inputStream, Class type){
        if (inputStream != null){
            JsonReader reader = getJsonReader(inputStream, "UTF-8");
            Gson gson = new Gson();
            return gson.fromJson(reader, type);
        }
        return null;
    }

    // TODO move to snowstorm-core if API's from other Blizz games deliver a JSON payload
    JsonReader getJsonReader(InputStream json, String characterEncoding) {
        JsonReader reader = null;
        try {
            reader = new JsonReader(new InputStreamReader(json, characterEncoding));
        } catch (UnsupportedEncodingException e) {
            LOG.error(characterEncoding +" not supported", e);
        }
        return reader;
    }


    // TODO move to snowstorm-core if API's from other Blizz games deliver a JSON payload
    private String prettyPrint(JsonReader reader) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(reader);
        return gson.toJson(jsonElement);
    }
}
