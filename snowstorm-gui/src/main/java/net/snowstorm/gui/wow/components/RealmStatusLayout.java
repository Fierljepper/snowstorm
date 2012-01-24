package net.snowstorm.gui.wow.components;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.ContainerHierarchicalWrapper;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.BaseTheme;
import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.gui.wow.pojo.RealmStatus;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/23/12
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class RealmStatusLayout extends VerticalLayout {

    private RealmStatus realmStatus;

    public RealmStatusLayout(){
        realmStatus = new RealmStatus();
        BeanItem<RealmStatus> realmStatusItem = new BeanItem<RealmStatus>(realmStatus);

        // Create the Form
        final Form realmStatusForm = new Form();
        realmStatusForm.setCaption("Realm Status API");
        realmStatusForm.setWriteThrough(false);
        realmStatusForm.setInvalidCommitted(false);

        // FieldFactory for customizing the fields and adding validators
        realmStatusForm.setFormFieldFactory(new PersonFieldFactory());
        realmStatusForm.setItemDataSource(realmStatusItem);

        // Determines which properties are shown, and in which order:
        realmStatusForm.setVisibleItemProperties(Arrays.asList(new String[]{
                "battlenetRegion", "realmList", "uuid"}));

        // Add form to layout
        addComponent(realmStatusForm);

        // The cancel / apply buttons
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        Button discardChanges = new Button("Discard changes",
                new Button.ClickListener() {
                    public void buttonClick(Button.ClickEvent event) {
                        realmStatusForm.discard();
                    }
                });
        discardChanges.setStyleName(BaseTheme.BUTTON_LINK);
        buttons.addComponent(discardChanges);
        buttons.setComponentAlignment(discardChanges, Alignment.MIDDLE_LEFT);

        Button apply = new Button("Apply", new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                try {
                    realmStatusForm.commit();
                } catch (Exception e) {
                    // Ignored, we'll let the Form handle the errors
                }
            }
        });
        buttons.addComponent(apply);
        realmStatusForm.getFooter().addComponent(buttons);
        realmStatusForm.getFooter().setMargin(false, false, true, true);

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
        n.setDescription("Battlenet region: " + realmStatus.getBattlenetRegion()
                + "<br/>Realm list: " + realmStatus.getRealmList()
                + "<br/>UUID: " + realmStatus.getUuid());
        getWindow().showNotification(n);
    }

    private class PersonFieldFactory extends DefaultFieldFactory {

        final BattlenetRegion[] regionValues = BattlenetRegion.values();

        final ComboBox regionComboBox = new ComboBox("Region");
        final TwinColSelect realmTwinColSelect = new TwinColSelect();

        public PersonFieldFactory(){
            regionComboBox.setInputPrompt("Region");
            regionComboBox.setWidth("6em");
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
            realmTwinColSelect.setWidth("450px");
        }

        @Override
        public Field createField(Item item, Object propertyId, Component uiContext) {
            Field f;
            if ("battlenetRegion".equals(propertyId)) {
                // filtering ComboBox with regions
                return regionComboBox;
            } else if ("realmList".equals(propertyId)) {
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
    }

}
