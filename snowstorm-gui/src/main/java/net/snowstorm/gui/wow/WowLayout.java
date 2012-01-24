package net.snowstorm.gui.wow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import net.snowstorm.wow.RealmStatusApiUrl;
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


    final ComboBox regionComboBox = new ComboBox("Region");
    final ComboBox localeComboBox = new ComboBox("Locale");
    final TwinColSelect realmTwinColSelect = new TwinColSelect();


    SnowstormApplication snowstormApplication;

    private Label plainText;
    private BattlenetRegion battlenetRegion;
    // FIXME for now we only have one API implemented
    private BattlenetApiUrl battlenetApiUrl = new RealmStatusApiUrl();

    Label urlLabel = new Label();

    @Override
    public void attach(){
        super.attach();
        snowstormApplication = (SnowstormApplication) getApplication();
    }

    public WowLayout(){
        RealmStatusLayout realmStatusLayout = new RealmStatusLayout();
        addComponent(realmStatusLayout);


//        for (BattlenetRegion regionValue: regionValues){
//            regionComboBox.addItem(regionValue);
//        }
//
//        regionComboBox.setInputPrompt("Please select a region");
//        regionComboBox.setImmediate(true);
//        regionComboBox.addListener(new RegionComboboxValueChangeListener());
//        addComponent(regionComboBox);
//
//        realmTwinColSelect.setRows(10);
//        realmTwinColSelect.setNullSelectionAllowed(true);
//        realmTwinColSelect.setMultiSelect(true);
//        realmTwinColSelect.setImmediate(true);
//        realmTwinColSelect.setLeftColumnCaption("Available realms");
//        realmTwinColSelect.setRightColumnCaption("Selected realms");
//        realmTwinColSelect.setWidth("450px");
//        addComponent(realmTwinColSelect);

//        localeComboBox.setInputPrompt("Please select a locale");
//        localeComboBox.setImmediate(true);
//        localeComboBox.addListener(new LocaleComboboxValueChangeListener());
//        localeComboBox.setEnabled(false);
//        addComponent(localeComboBox);


//        addComponent(urlLabel);
    }

    public class RealmTwinColSelectValueChangeListener implements Property.ValueChangeListener {

        @Override
        public void valueChange(ValueChangeEvent event) {

        }
    }

    public class RegionComboboxValueChangeListener implements Property.ValueChangeListener {
        @Override
        public void valueChange(ValueChangeEvent event) {
            // Reset components
            resetComponents();
            battlenetRegion = (BattlenetRegion)regionComboBox.getValue();
            if (battlenetRegion != null){
                battlenetApiUrl.setRegion(battlenetRegion);
                List<Realm> realms =  regionRealmsMap.get(battlenetRegion);
                for (Realm realm: realms) {
                    realmTwinColSelect.addItem(realm.getName());
                }
//                setPayload();

                // Fill the localeCombobox with the current region
//                Map<String, String> locales = battlenetRegion.getLocales();
//                for (String locale: locales.values()){
//                    localeComboBox.addItem(locale);
//                }
//                localeComboBox.setEnabled(true);
            }
        }
    }

//    public class LocaleComboboxValueChangeListener implements Property.ValueChangeListener {
//        @Override
//        public void valueChange(ValueChangeEvent event) {
//            String locale = (String)localeComboBox.getValue();
//            battlenetApiUrl.setLocale(locale);
//            setPayload();
//        }
//    }

    private String inputStringAsString(InputStream in) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line = null;

        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        br.close();
        return sb.toString();
    }


    private void setPayload(){
        urlLabel.setValue(battlenetApiUrl.getUrl());
        UrlConnectionReader urlConnectionReader = new UrlConnectionReader();
        try {
            InputStream inputStream = urlConnectionReader.fetch(new URL(battlenetApiUrl.getUrl()));

//            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
//            Gson gsonIn = new Gson();
//            Realms realms = gsonIn.fromJson(reader, Realms.class);
//            Gson gsonOut = new GsonBuilder().setPrettyPrinting().create();

            snowstormApplication.getPayloadTextAre().setValue(inputStringAsString(inputStream));
        } catch (MalformedURLException e) {
            LOG.error("Malformed URL", e);
        } catch (IOException e) {
            LOG.error("Failed to convert InputStream to String", e);
        }
    }

    private void resetComponents(){
        localeComboBox.removeAllItems();
        snowstormApplication.getPayloadTextAre().setValue("");
        urlLabel.setValue("");
        realmTwinColSelect.removeAllItems();
    }


    private static void fillRegionRealmsMap(){
        BattlenetApiUrl battlenetApiUrl = new RealmStatusApiUrl();
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
