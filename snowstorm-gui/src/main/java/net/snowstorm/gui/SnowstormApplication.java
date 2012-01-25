package net.snowstorm.gui;

import com.vaadin.Application;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.*;
import net.snowstorm.core.url.UrlConnectionReader;
import net.snowstorm.gui.wow.WowLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

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


    private final TextArea payloadTextAre = new TextArea();
    private Label urlLabel;

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

        urlLabel = new Label();
        mainWindow.addComponent(urlLabel);

        payloadTextAre.setRows(80);
        payloadTextAre.setColumns(80);
        payloadTextAre.setImmediate(true);
        mainWindow.addComponent(payloadTextAre);


        setMainWindow(mainWindow);
    }

    private String inputStringAsString(InputStream in) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line = null;

        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        br.close();
        return sb.toString();
    }

    public void setPayload(String url){
        urlLabel.setValue(url);
        UrlConnectionReader urlConnectionReader = new UrlConnectionReader();
        try {
            InputStream inputStream = urlConnectionReader.fetch(new URL(url));

//            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
//            Gson gsonIn = new Gson();
//            Realms realms = gsonIn.fromJson(reader, Realms.class);
//            Gson gsonOut = new GsonBuilder().setPrettyPrinting().create();

            payloadTextAre.setValue(inputStringAsString(inputStream));
        } catch (MalformedURLException e) {
            LOG.error("Malformed URL", e);
        } catch (IOException e) {
            LOG.error("Failed to convert InputStream to String", e);
        }
    }
}
