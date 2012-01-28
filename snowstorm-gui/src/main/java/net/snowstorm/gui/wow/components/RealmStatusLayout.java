package net.snowstorm.gui.wow.components;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.gui.SnowstormApplication;
import net.snowstorm.gui.wow.WowLayout;
import net.snowstorm.wow.api.RealmStatus;
import net.snowstorm.wow.beans.Realm;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/23/12
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class RealmStatusLayout extends VerticalLayout {

    final private Form realmStatusForm;

    private RealmStatus realmStatus;

    private WowLayout wowLayout;
    private SnowstormApplication snowstormApplication;

    @Override
    public void attach(){
        super.attach();
        wowLayout = (WowLayout) getParent();
        snowstormApplication = (SnowstormApplication) getApplication();
    }

    public RealmStatusLayout(){
        setMargin(true, true, true, true);

        realmStatus = new RealmStatus();
        BeanItem<RealmStatus> realmStatusItem = new BeanItem<RealmStatus>(realmStatus);

        // Create the Form
        realmStatusForm = new Form();

        realmStatusForm.setCaption("Realm Status API");
        realmStatusForm.setWriteThrough(false);
        realmStatusForm.setInvalidCommitted(false);

        // FieldFactory for customizing the fields and adding validators
        realmStatusForm.setFormFieldFactory(new RealmStatusFieldFactory());
        realmStatusForm.setItemDataSource(realmStatusItem);

        // Determines which properties are shown, and in which order:
        realmStatusForm.setVisibleItemProperties(Arrays.asList(new String[]{
                "region", "realms"}));

        // Add form to layout
        addComponent(realmStatusForm);

        // The reset / submit buttons
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        Button reset = new Button("Reset",
                new Button.ClickListener() {
                    public void buttonClick(Button.ClickEvent event) {
                        realmStatusForm.discard();
                    }
                });
        buttons.addComponent(reset);
        buttons.setComponentAlignment(reset, Alignment.MIDDLE_LEFT);

        Button submit = new Button("Submit", new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                try {
                    realmStatusForm.commit();
                    wowLayout.getTransactionLayout().setPayload(realmStatus.getJsonPayload(realmStatus.getUrl()));
                    wowLayout.getTransactionLayout().setRequestPropertiesTable(realmStatus.getUrlConnectionReader().getRequestProperties());
                    wowLayout.getTransactionLayout().setResponsePropertiesTable(realmStatus.getUrlConnectionReader().getResponseProperties());
                } catch (Exception e) {
                    // Ignored, we'll let the Form handle the errors
                }
            }
        });
        buttons.addComponent(submit);
        realmStatusForm.getFooter().addComponent(buttons);
        realmStatusForm.getFooter().setMargin(false, false, true, false);

        // button for showing the internal state of the POJO
        Button showPojoState = new Button("Show POJO internal state",
                new Button.ClickListener() {
                    public void buttonClick(Button.ClickEvent event) {
                        showPojoState();
                    }
                });
        addComponent(showPojoState);

    }

    private void showPojoState() {
        Window.Notification n = new Window.Notification("POJO state",
                Window.Notification.TYPE_TRAY_NOTIFICATION);
        n.setPosition(Window.Notification.POSITION_CENTERED);
        n.setDescription("Region: " + realmStatus.getRegion()
                + "<br/>Realms:" + realmStatus.getRealms()
                + "<br/>UUID: " + realmStatus.getUuid());
        getWindow().showNotification(n);
    }

    private class RealmStatusFieldFactory extends DefaultFieldFactory {

        final BattlenetRegion[] regionValues = BattlenetRegion.values();

        final ComboBox regionComboBox = new ComboBox("Region");
        final TwinColSelect realmTwinColSelect = new TwinColSelect();

        public RealmStatusFieldFactory(){
            regionComboBox.setInputPrompt("Region");
            regionComboBox.setWidth("6em");
            regionComboBox.addListener(new RegionComboboxValueChangeListener());
            for (BattlenetRegion regionValue: regionValues){
                regionComboBox.addItem(regionValue);
            }
            regionComboBox.setFilteringMode(ComboBox.FILTERINGMODE_STARTSWITH);
            regionComboBox.setImmediate(true);

            realmTwinColSelect.setCaption("Realms");
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
                // filtering ComboBox with regions
                return regionComboBox;
            } else if ("realms".equals(propertyId)) {
                // Create a password field so the password is not shown
                return realmTwinColSelect;
            } else {
                // Use the super class to create a suitable field base on the
                // property type.
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
