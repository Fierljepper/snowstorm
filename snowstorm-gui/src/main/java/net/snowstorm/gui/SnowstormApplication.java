package net.snowstorm.gui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.vaadin.Application;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.*;
import net.snowstorm.core.url.UrlConnectionReader;
import net.snowstorm.gui.wow.WowLayout;
import net.snowstorm.wow.Realms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
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

        payloadTextAre.setCaption("API Payload");
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
//            payloadTextAre.setValue(inputStringAsString(inputStream));

            String prettyJsonString = prettyPrint(inputStream);

            payloadTextAre.setValue(prettyJsonString);
        } catch (MalformedURLException e) {
            LOG.error("Malformed URL", e);
        } catch (IOException e) {
            LOG.error("Failed to convert InputStream to String", e);
        }
    }
    
    private String prettyPrint(InputStream json) {
        JsonReader reader = null;
        try {
            reader = new JsonReader(new InputStreamReader(json, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            LOG.error("UTF-8 not supported", e);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(reader);
        return gson.toJson(jsonElement);
    }
}
