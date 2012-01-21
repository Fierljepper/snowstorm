package net.snowstorm.gui.wow;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.*;
import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.core.url.BattlenetUrl;
import net.snowstorm.wow.RealmStatusApi;
import net.snowstorm.wow.WowApi;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/18/12
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class WowLayout extends VerticalLayout {

    private static final BattlenetRegion[] regionValues = BattlenetRegion.values();
    final ComboBox regionComboBox = new ComboBox("Region");

    final ComboBox localeComboBox = new ComboBox("Locale");

    private BattlenetRegion battlenetRegion;
    private BattlenetUrl battlenetUrl;

    Label urlLabel = new Label();

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
            battlenetRegion = (BattlenetRegion)regionComboBox.getValue();
            urlLabel.setValue(battlenetRegion.getHost());

            // Reset the localeCombobox
            localeComboBox.removeAllItems();
            // Fill the localeCombobox with the current region
            Map<String, String> locales = battlenetRegion.getLocales();
            for (String locale: locales.values()){
                localeComboBox.addItem(locale);
            }
            localeComboBox.setEnabled(true);
        }
    }

    public class LocaleComboboxValueChangeListener implements Property.ValueChangeListener {

        @Override
        public void valueChange(ValueChangeEvent event) {

            String locale = (String)localeComboBox.getValue();

            // FIXME for now we only have one API implemented
            battlenetUrl = new RealmStatusApi(battlenetRegion);
            battlenetUrl.setLocale(locale);

            if (battlenetRegion != null && locale != null){
                urlLabel.setValue(battlenetUrl.getUrl());
            }

        }
    }
}
