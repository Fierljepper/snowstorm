package net.snowstorm.gui.wow.components;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.gui.wow.WowLayout;
import net.snowstorm.wow.api.itemresources.ItemApi;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/18/12 Time: 6:27 PM To change this template use File | Settings |
 * File Templates.
 */
public class ItemForm extends Form {

    private static final String COMMON_FIELD_WIDTH = "12em";

    private GridLayout layout;
    private WowLayout wowLayout;

    @Override
    public void attach(){
        super.attach();
        wowLayout = (WowLayout) getParent();
    }

    public ItemForm(BeanItem<ItemApi> itemBeanItem){
        setCaption(WowLayout.CURRENT_AUCTIONS_API_CAPTION);
        layout = new GridLayout(1, 3);
        layout.setMargin(true, false, false, true);
        layout.setSpacing(true);
        setLayout(layout);
        setWriteThrough(false);
        setInvalidCommitted(false);
        setFormFieldFactory(new ItemFieldFactory());
        setItemDataSource(itemBeanItem);
        setVisibleItemProperties(Arrays.asList(new String[]{
                "region", "itemId"}));
    }

    @Override
    protected void attachField(Object propertyId, Field field) {
        if (propertyId.equals("region")) {
            layout.addComponent(field, 0, 0);
        } else if (propertyId.equals("itemId")) {
            layout.addComponent(field, 0, 1);
        }
    }

    private class ItemFieldFactory extends DefaultFieldFactory {
        final BattlenetRegion[] regionValues = BattlenetRegion.values();

        final ComboBox regionComboBox = new ComboBox("Region");
        final TextField itemIdTextField = new TextField("Item id");

        public ItemFieldFactory(){
            regionComboBox.setRequired(true);
            regionComboBox.setInputPrompt("Region");
            regionComboBox.setWidth("6em");
            for (BattlenetRegion regionValue: regionValues){
                regionComboBox.addItem(regionValue);
            }
            regionComboBox.setFilteringMode(ComboBox.FILTERINGMODE_STARTSWITH);
            regionComboBox.setImmediate(true);

            itemIdTextField.setRequired(true);
            itemIdTextField.setNullRepresentation("");
            itemIdTextField.setInputPrompt("Item id");
            itemIdTextField.setWidth(COMMON_FIELD_WIDTH);
            itemIdTextField.setImmediate(true);
        }

        @Override
        public Field createField(Item item, Object propertyId, Component uiContext) {
            Field f;
            if ("region".equals(propertyId)) {
                return regionComboBox;
            } else if ("itemId".equals(propertyId)) {
                return itemIdTextField;
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
