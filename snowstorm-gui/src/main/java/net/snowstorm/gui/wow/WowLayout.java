package net.snowstorm.gui.wow;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.*;
import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.core.url.BattlenetApiUrl;
import net.snowstorm.core.url.UrlConnectionReader;
import net.snowstorm.gui.SnowstormApplication;
import net.snowstorm.wow.RealmStatusApiUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
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

    final ComboBox regionComboBox = new ComboBox("Region");
    final ComboBox localeComboBox = new ComboBox("Locale");

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
        for (BattlenetRegion regionValue: regionValues){
            regionComboBox.addItem(regionValue);
        }

        regionComboBox.setInputPrompt("Please select a region");
        regionComboBox.setImmediate(true);
        regionComboBox.addListener(new RegionComboboxValueChangeListener());
        addComponent(regionComboBox);


        localeComboBox.setInputPrompt("Please select a locale");
        localeComboBox.setImmediate(true);
        localeComboBox.addListener(new LocaleComboboxValueChangeListener());
        localeComboBox.setEnabled(false);
        addComponent(localeComboBox);


        addComponent(urlLabel);
    }

    public class RegionComboboxValueChangeListener implements Property.ValueChangeListener {

        @Override
        public void valueChange(ValueChangeEvent event) {

            // Reset components
            resetComponents();

            battlenetRegion = (BattlenetRegion)regionComboBox.getValue();
            if (battlenetRegion != null){
                battlenetApiUrl.setRegion(battlenetRegion);

                setPayload();

                // Fill the localeCombobox with the current region
                Map<String, String> locales = battlenetRegion.getLocales();
                for (String locale: locales.values()){
                    localeComboBox.addItem(locale);
                }
                localeComboBox.setEnabled(true);
            }
        }
    }

    public class LocaleComboboxValueChangeListener implements Property.ValueChangeListener {

        @Override
        public void valueChange(ValueChangeEvent event) {

            String locale = (String)localeComboBox.getValue();
            battlenetApiUrl.setLocale(locale);

            setPayload();

        }
    }

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
    }
}
