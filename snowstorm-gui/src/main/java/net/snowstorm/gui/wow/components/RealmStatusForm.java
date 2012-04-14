package net.snowstorm.gui.wow.components;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.gui.wow.WowLayout;
import net.snowstorm.wow.api.RealmStatusApi;
import net.snowstorm.wow.beans.Realm;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA. User: developer Date: 1/28/12 Time: 10:20 PM To change this template use File | Settings |
 * File Templates.
 */
public class RealmStatusForm extends Form {

    private GridLayout layout;
    private WowLayout wowLayout;

    @Override
    public void attach(){
        super.attach();
        wowLayout = (WowLayout) getParent();
    }

    public RealmStatusForm(BeanItem<RealmStatusApi> realmStatusBeanItem){

        setCaption(WowLayout.REALM_STATUS_API_CAPTION);
        layout = new GridLayout(3, 3);
        layout.setMargin(true, false, false, true);
        layout.setSpacing(true);
        setLayout(layout);
        setWriteThrough(false);
        setInvalidCommitted(false);
        setFormFieldFactory(new RealmStatusFieldFactory());
        setItemDataSource(realmStatusBeanItem);
        setVisibleItemProperties(Arrays.asList(new String[]{
                "region", "realms"}));
    }

    @Override
    protected void attachField(Object propertyId, Field field) {
        if (propertyId.equals("region")) {
            layout.addComponent(field, 0, 0);
        } else if (propertyId.equals("realms")) {
            layout.addComponent(field, 0, 1);
        }
    }

    private class RealmStatusFieldFactory extends DefaultFieldFactory {

        final BattlenetRegion[] regionValues = BattlenetRegion.values();

        final ComboBox regionComboBox = new ComboBox("Region");
        final TwinColSelect realmTwinColSelect = new TwinColSelect();

        public RealmStatusFieldFactory(){
            regionComboBox.setRequired(true);
            regionComboBox.setInputPrompt("Region");
            regionComboBox.setWidth("6em");
            regionComboBox.addListener(new RegionComboboxValueChangeListener());
            for (BattlenetRegion regionValue: regionValues){
                regionComboBox.addItem(regionValue);
            }
            regionComboBox.setFilteringMode(ComboBox.FILTERINGMODE_STARTSWITH);
            regionComboBox.setImmediate(true);

            realmTwinColSelect.setRows(10);
            realmTwinColSelect.setNullSelectionAllowed(true);
            realmTwinColSelect.setMultiSelect(true);
            realmTwinColSelect.setImmediate(true);
            realmTwinColSelect.setLeftColumnCaption("Available realms");
            realmTwinColSelect.setRightColumnCaption("Selected realms");
            realmTwinColSelect.setWidth("30em");
        }

        @Override
        public Field createField(Item item, Object propertyId, Component uiContext) {
            Field f;
            if ("region".equals(propertyId)) {
                return regionComboBox;
            } else if ("realms".equals(propertyId)) {
                return realmTwinColSelect;
            } else {
                f = super.createField(item, propertyId, uiContext);
            }
            if ("uuid".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setWidth("20em");
            }
            return f;
        }

        public class RegionComboboxValueChangeListener implements Property.ValueChangeListener {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                // Reset components
                realmTwinColSelect.removeAllItems();
                BattlenetRegion battlenetRegion = (BattlenetRegion)regionComboBox.getValue();
                if (battlenetRegion != null){
                    List<Realm> realms =  wowLayout.regionRealmsMap.get(battlenetRegion);
                    for (Realm realm: realms) {
                        realmTwinColSelect.addItem(realm);
                        realmTwinColSelect.setItemCaption(realm, realm.getName());
                    }
                }
            }
        }
    }
}
