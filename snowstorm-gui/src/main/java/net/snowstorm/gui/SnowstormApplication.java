package net.snowstorm.gui;

import com.vaadin.Application;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Window;
import net.snowstorm.gui.wow.WowLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/17/12
 * Time: 5:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class SnowstormApplication extends Application {

    private static final Logger LOG = LoggerFactory.getLogger(SnowstormApplication.class);

    // Application icons
    public static final ExternalResource WOW_ICON_EXTERNAL_RESOURCE = new ExternalResource("http://us.battle.net/wow/static/local-common/images/favicons/wow.ico");
    public static final ExternalResource D3_ICON_EXTERNAL_RESOURCE = new ExternalResource("http://us.battle.net/d3/static/local-common/images/favicons/d3.ico");
    public static final ExternalResource SC2_ICON_EXTERNAL_RESOURCE = new ExternalResource("http://us.battle.net/sc2/static/local-common/images/favicons/sc2.ico");

    private WowLayout wowLayout;

    @Override
    public void init() {
        Window mainWindow = new Window();
        mainWindow.getContent().setHeight(100, Sizeable.UNITS_PERCENTAGE);

        Label d3Label = new Label("Diablo 3!");
        Label sc2Label = new Label("StarCraft 2!");

        wowLayout = new WowLayout();
        wowLayout.setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();
        tabSheet.addTab(wowLayout, "World of Warcraft", WOW_ICON_EXTERNAL_RESOURCE);
        tabSheet.addTab(d3Label, "Diablo III", D3_ICON_EXTERNAL_RESOURCE);
        tabSheet.addTab(sc2Label, "StarCraft II", SC2_ICON_EXTERNAL_RESOURCE);
        mainWindow.addComponent(tabSheet);


        setMainWindow(mainWindow);
    }

}
