package net.snowstorm.gui.wow.components;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.gui.wow.WowLayout;
import net.snowstorm.wow.api.CharacterProfile;
import net.snowstorm.wow.beans.Realm;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA. User: developer Date: 1/31/12 Time: 4:33 PM To change this template use File | Settings |
 * File Templates.
 */
public class CharacterProfileForm extends Form {

    private static final String COMMON_FIELD_WIDTH = "12em";

    private GridLayout layout;
    private WowLayout wowLayout;

    @Override
    public void attach(){
        super.attach();
        wowLayout = (WowLayout) getParent();
    }


    public CharacterProfileForm(BeanItem<CharacterProfile> characterProfileBeanItem){
        setCaption(WowLayout.CHARACTER_PROFILE_API_CAPTION);
        layout = new GridLayout(3, 3);
        layout.setMargin(true, false, false, true);
        layout.setSpacing(true);
        setLayout(layout);
        setWriteThrough(false);
        setInvalidCommitted(false);
        setFormFieldFactory(new CharacterProfileFieldFactory());
        setItemDataSource(characterProfileBeanItem);
        setVisibleItemProperties(Arrays.asList(new String[]{
                "region", "realm", "characterName"}));
    }

    @Override
    protected void attachField(Object propertyId, Field field) {
        if (propertyId.equals("region")) {
            layout.addComponent(field, 0, 0);
        } else if (propertyId.equals("realm")) {
            layout.addComponent(field, 0, 1);
        } else if (propertyId.equals("characterName")) {
            layout.addComponent(field, 0, 2);
        }
    }

    private class CharacterProfileFieldFactory extends DefaultFieldFactory {
        final BattlenetRegion[] regionValues = BattlenetRegion.values();

        final ComboBox regionComboBox = new ComboBox("Region");
        final ComboBox realmComboBox = new ComboBox("Realm");

        public CharacterProfileFieldFactory(){
            regionComboBox.setRequired(true);
            regionComboBox.setInputPrompt("Region");
            regionComboBox.setWidth("6em");
            regionComboBox.addListener(new RegionComboboxValueChangeListener());
            for (BattlenetRegion regionValue: regionValues){
                regionComboBox.addItem(regionValue);
            }
            regionComboBox.setFilteringMode(ComboBox.FILTERINGMODE_STARTSWITH);
            regionComboBox.setImmediate(true);

            realmComboBox.setRequired(true);
            realmComboBox.setInputPrompt("Realm");
            realmComboBox.setWidth(COMMON_FIELD_WIDTH);
            realmComboBox.setFilteringMode(ComboBox.FILTERINGMODE_STARTSWITH);
            realmComboBox.setImmediate(true);
        }

        @Override
        public Field createField(Item item, Object propertyId, Component uiContext) {
            Field f;
            if ("region".equals(propertyId)) {
                return regionComboBox;
            } else if ("realm".equals(propertyId)) {
                return realmComboBox;
            } else {
                f = super.createField(item, propertyId, uiContext);
            }

            if("characterName".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setRequired(true);
                tf.setInputPrompt("Character name");
                tf.setWidth(COMMON_FIELD_WIDTH);
            } else if ("uuid".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setWidth("20em");
            }

            return f;
        }

        public class RegionComboboxValueChangeListener implements Property.ValueChangeListener {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                // Reset components
                realmComboBox.removeAllItems();
                BattlenetRegion battlenetRegion = (BattlenetRegion)regionComboBox.getValue();
                if (battlenetRegion != null){
                    List<Realm> realms =  wowLayout.regionRealmsMap.get(battlenetRegion);
                    for (Realm realm: realms) {
                        realmComboBox.addItem(realm);
                        realmComboBox.setItemCaption(realm, realm.getName());
                    }
                }
            }
        }
    }
}