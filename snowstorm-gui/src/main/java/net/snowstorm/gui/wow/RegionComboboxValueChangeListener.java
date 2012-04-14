package net.snowstorm.gui.wow;

import com.vaadin.data.Property;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.ComboBox;
import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.wow.beans.Realm;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: brandsema
 * Date: 4/14/12
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegionComboboxValueChangeListener implements Property.ValueChangeListener {

    private WowLayout wowLayout;
    private AbstractSelect realmSelect;
    private ComboBox regionComboBox;

    public RegionComboboxValueChangeListener(WowLayout wowLayout, AbstractSelect realmSelect, ComboBox regionComboBox) {
        this.wowLayout = wowLayout;
        this.realmSelect = realmSelect;
        this.regionComboBox = regionComboBox;
    }


    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        // Reset components
        realmSelect.removeAllItems();
        BattlenetRegion battlenetRegion = (BattlenetRegion)regionComboBox.getValue();
        if (battlenetRegion != null){
            List<Realm> realms =  wowLayout.regionRealmsMap.get(battlenetRegion);
            for (Realm realm: realms) {
                realmSelect.addItem(realm);
                realmSelect.setItemCaption(realm, realm.getName());
            }
        }
    }
}
