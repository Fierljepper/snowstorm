package net.snowstorm.wow.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.core.url.BattlenetApiUrlImpl;
import net.snowstorm.core.url.UrlConnectionReader;
import net.snowstorm.wow.WowApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/19/12
 * Time: 5:48 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class WowApiImpl extends BattlenetApiUrlImpl implements WowApi {

    private static final Logger LOG = LoggerFactory.getLogger(WowApiImpl.class);

    private String wowPath = "/wow";

    private UrlConnectionReader urlConnectionReader = new UrlConnectionReader();

    public WowApiImpl(){

    }

    public WowApiImpl(BattlenetRegion region) {
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
    @Override
    public String getJsonPayload(String url) throws MalformedURLException {
        InputStream inputStream = urlConnectionReader.fetch(new URL(url));
        JsonReader reader = getJsonReader(inputStream, "UTF-8");
        return prettyPrint(reader);
    }

    // TODO move to snowstorm-core if API's from other Blizz games deliver a JSON payload
    private JsonReader getJsonReader(InputStream json, String characterEncoding) {
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
