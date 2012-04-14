package net.snowstorm.gui.wow.components;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.gui.wow.WowLayout;
import net.snowstorm.wow.api.GuildProfileApi;
import net.snowstorm.wow.api.GuildProfileApi.GuildProfileField;
import net.snowstorm.wow.beans.Realm;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA. User: developer Date: 4/14/12 Time: 10:11 AM To change this template use File | Settings |
 * File Templates.
 */
public class GuildProfileForm extends Form {

    private static final String COMMON_FIELD_WIDTH = "12em";

    private GridLayout layout;
    private WowLayout wowLayout;

    @Override
    public void attach(){
        super.attach();
        wowLayout = (WowLayout) getParent();
    }

    public GuildProfileForm(BeanItem<GuildProfileApi> guildProfileBeanItem){
        setCaption(WowLayout.GUILD_PROFILE_API_CAPTION);
        layout = new GridLayout(2, 3);
        layout.setMargin(true, false, false, true);
        layout.setSpacing(true);
        setLayout(layout);
        setWriteThrough(false);
        setInvalidCommitted(false);
        setFormFieldFactory(new GuildProfileFieldFactory());
        setItemDataSource(guildProfileBeanItem);
        setVisibleItemProperties(Arrays.asList(new String[]{
                "region", "realm", "guildName", "guildProfileFields"}));
    }

    @Override
    protected void attachField(Object propertyId, Field field) {
        if (propertyId.equals("region")) {
            layout.addComponent(field, 0, 0);
        } else if (propertyId.equals("realm")) {
            layout.addComponent(field, 0, 1);
        } else if (propertyId.equals("guildName")) {
            layout.addComponent(field, 0, 2);
        } else if (propertyId.equals("guildProfileFields")) {
            layout.addComponent(field, 1, 0, 1, 2);
        }
    }

    private class GuildProfileFieldFactory extends DefaultFieldFactory {
        final BattlenetRegion[] regionValues = BattlenetRegion.values();
        final GuildProfileField[] guildProfileFieldValues = GuildProfileField.values();

        final ComboBox regionComboBox = new ComboBox("Region");
        final ComboBox realmComboBox = new ComboBox("Realm");
        final TwinColSelect fieldsTwinColSelect = new TwinColSelect();
        final TextField guildNameTextField = new TextField("Guild name");

        public GuildProfileFieldFactory(){
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


            fieldsTwinColSelect.setRows(8);
            fieldsTwinColSelect.setNullSelectionAllowed(true);
            fieldsTwinColSelect.setMultiSelect(true);
            fieldsTwinColSelect.setImmediate(true);
            fieldsTwinColSelect.setLeftColumnCaption("Available fields");
            fieldsTwinColSelect.setRightColumnCaption("Selected fields");
            fieldsTwinColSelect.setWidth("30em");
            fieldsTwinColSelect.setMultiSelect(true);
            for (GuildProfileField guildProfileFieldValue:guildProfileFieldValues){
                fieldsTwinColSelect.addItem(guildProfileFieldValue);
            }

            guildNameTextField.setRequired(true);
            guildNameTextField.setNullRepresentation("");
            guildNameTextField.setInputPrompt("Guild name");
            guildNameTextField.setWidth(COMMON_FIELD_WIDTH);
            guildNameTextField.setImmediate(true);
        }

        @Override
        public Field createField(Item item, Object propertyId, Component uiContext) {
            Field f;
            if ("region".equals(propertyId)) {
                return regionComboBox;
            } else if ("realm".equals(propertyId)) {
                return realmComboBox;
            } else if ("guildProfileFields".equals(propertyId)) {
                return fieldsTwinColSelect;
            } else if("guildName".equals(propertyId)) {
                return guildNameTextField;
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
