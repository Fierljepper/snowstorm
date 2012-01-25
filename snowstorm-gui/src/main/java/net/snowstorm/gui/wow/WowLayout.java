package net.snowstorm.gui.wow;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.*;
import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.core.url.BattlenetApiUrl;
import net.snowstorm.core.url.UrlConnectionReader;
import net.snowstorm.gui.SnowstormApplication;
import net.snowstorm.gui.wow.components.RealmStatusLayout;
import net.snowstorm.wow.Realm;
import net.snowstorm.wow.api.RealmStatus;
import net.snowstorm.wow.Realms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/18/12
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class WowLayout extends VerticalLayout {

    private static final Logger LOG = LoggerFactory.getLogger(WowLayout.class);

    private static final BattlenetRegion[] regionValues = BattlenetRegion.values();
    public static final Map<BattlenetRegion, List<Realm>> regionRealmsMap = new HashMap<BattlenetRegion, List<Realm>>();

    static {
        fillRegionRealmsMap();
    }


    SnowstormApplication snowstormApplication;

    @Override
    public void attach(){
        super.attach();
        snowstormApplication = (SnowstormApplication) getApplication();
    }

    public WowLayout(){
        RealmStatusLayout realmStatusLayout = new RealmStatusLayout();
        addComponent(realmStatusLayout);

    }

    private static void fillRegionRealmsMap(){
        BattlenetApiUrl battlenetApiUrl = new RealmStatus();
        UrlConnectionReader urlConnectionReader = new UrlConnectionReader();
        for(BattlenetRegion region: regionValues){
            List<Realm> realmsList = new ArrayList<Realm>();
            battlenetApiUrl.setRegion(region);
            InputStream inputStream = null;
            try {
                inputStream = urlConnectionReader.fetch(new URL(battlenetApiUrl.getUrl()));
                JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
                Gson gson = new Gson();
                Realms realms = gson.fromJson(reader, Realms.class);
                for(Realm realm: realms.getRealms()){
                    realmsList.add(realm);
                }
                regionRealmsMap.put(region, realmsList);
            } catch (MalformedURLException e) {
                LOG.error("Malformed URL", e);
            } catch (IOException e) {
                LOG.error("Failed to convert InputStream to String", e);
            }
        }
    }
}
