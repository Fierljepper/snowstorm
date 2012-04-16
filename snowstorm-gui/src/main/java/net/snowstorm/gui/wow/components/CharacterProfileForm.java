package net.snowstorm.gui.wow.components;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.gui.wow.WowLayout;
import net.snowstorm.wow.api.CharacterProfile;
import net.snowstorm.wow.api.CharacterProfile.CharacterProfileField;
import net.snowstorm.gui.wow.RegionComboboxValueChangeListener;

import java.util.Arrays;

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
        layout = new GridLayout(2, 3);
        layout.setMargin(true, false, false, true);
        layout.setSpacing(true);
        setLayout(layout);
        setWriteThrough(false);
        setInvalidCommitted(false);
        setFormFieldFactory(new CharacterProfileFieldFactory());
        setItemDataSource(characterProfileBeanItem);
        setVisibleItemProperties(Arrays.asList(new String[]{
                "region", "realm", "characterName", "characterProfileFields"}));
    }

    @Override
    protected void attachField(Object propertyId, Field field) {
        if (propertyId.equals("region")) {
            layout.addComponent(field, 0, 0);
        } else if (propertyId.equals("realm")) {
            layout.addComponent(field, 0, 1);
        } else if (propertyId.equals("characterName")) {
            layout.addComponent(field, 0, 2);
        } else if (propertyId.equals("characterProfileFields")) {
            layout.addComponent(field, 1, 0, 1, 2);
        }
    }

    private class CharacterProfileFieldFactory extends DefaultFieldFactory {
        final BattlenetRegion[] regionValues = BattlenetRegion.values();
        final CharacterProfileField[] characterProfileFieldValues = CharacterProfileField.values();

        final ComboBox regionComboBox = new ComboBox("Region");
        final ComboBox realmComboBox = new ComboBox("Realm");
        final TwinColSelect fieldsTwinColSelect = new TwinColSelect();
        final TextField characterNameTextField = new TextField("Character name");

        public CharacterProfileFieldFactory(){
            regionComboBox.setRequired(true);
            regionComboBox.setInputPrompt("Region");
            regionComboBox.setWidth("6em");
            regionComboBox.addListener(new RegionComboboxValueChangeListener(wowLayout, realmComboBox, regionComboBox));
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
            for (CharacterProfileField characterProfileFieldValue:characterProfileFieldValues){
                fieldsTwinColSelect.addItem(characterProfileFieldValue);
            }

            characterNameTextField.setRequired(true);
            characterNameTextField.setNullRepresentation("");
            characterNameTextField.setInputPrompt("Character name");
            characterNameTextField.setWidth(COMMON_FIELD_WIDTH);
            characterNameTextField.setImmediate(true);
        }

        @Override
        public Field createField(Item item, Object propertyId, Component uiContext) {
            Field f;
            if ("region".equals(propertyId)) {
                return regionComboBox;
            } else if ("realm".equals(propertyId)) {
                return realmComboBox;
            } else if ("characterProfileFields".equals(propertyId)) {
                return fieldsTwinColSelect;
            } else if("characterName".equals(propertyId)) {
                return characterNameTextField;
            } else {
                f = super.createField(item, propertyId, uiContext);
            }

            if ("uuid".equals(propertyId)) {
                TextField tf = (TextField) f;
                tf.setWidth("20em");
            }

            return f;
        }
    }
}
