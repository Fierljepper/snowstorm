package net.snowstorm.gui;

import com.vaadin.Application;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.*;
import net.snowstorm.gui.wow.WowLayout;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/17/12
 * Time: 5:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class SnowstormApplication extends Application {

    // Application icons
    public static final ExternalResource WOW_ICON_EXTERNAL_RESOURCE = new ExternalResource("http://us.battle.net/wow/static/local-common/images/favicons/wow.ico");
    public static final ExternalResource D3_ICON_EXTERNAL_RESOURCE = new ExternalResource("http://us.battle.net/d3/static/local-common/images/favicons/d3.ico");
    public static final ExternalResource SC2_ICON_EXTERNAL_RESOURCE = new ExternalResource("http://us.battle.net/sc2/static/local-common/images/favicons/sc2.ico");

    @Override
    public void init() {
        Window mainWindow = new Window();

        Label d3Label = new Label("Diablo 3!");
        Label sc2Label = new Label("StarCraft 2!");

        WowLayout wowLayout = new WowLayout();

        TabSheet tabSheet = new TabSheet();
        tabSheet.addTab(wowLayout, "World of Warcraft", WOW_ICON_EXTERNAL_RESOURCE);
        tabSheet.addTab(d3Label, "Diablo III", D3_ICON_EXTERNAL_RESOURCE);
        tabSheet.addTab(sc2Label, "StarCraft II", SC2_ICON_EXTERNAL_RESOURCE);

        mainWindow.addComponent(tabSheet);
        setMainWindow(mainWindow);
    }
}
