package net.snowstorm.gui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.vaadin.Application;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;
import net.snowstorm.core.url.UrlConnectionReader;
import net.snowstorm.gui.wow.WowLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

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

    private Label payloadText;
    private Table payloadTable = new Table();
    private Table responsePropertiesTable = new Table("Response properties");
//    private Label urlLabel;
    private HorizontalSplitPanel horizontalSplitPanel;

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

//        urlLabel = new Label();
//        mainWindow.addComponent(urlLabel);

        horizontalSplitPanel = new HorizontalSplitPanel();
        horizontalSplitPanel.setSplitPosition(50, Sizeable.UNITS_PERCENTAGE);
        horizontalSplitPanel.setSizeFull();
        horizontalSplitPanel.setHeight("450px");
        horizontalSplitPanel.setLocked(false);
        mainWindow.addComponent(horizontalSplitPanel);

        payloadTable.setSizeFull();
        payloadTable.addContainerProperty("API Payload", Label.class, null);
//        payloadTable.setColumnAlignment("API Payload", Table.ALIGN_CENTER);
        horizontalSplitPanel.addComponent(payloadTable);

        payloadText = new Label();
        payloadText.setContentMode(Label.CONTENT_PREFORMATTED);
        payloadTable.addItem(new Object[]{payloadText}, null);

        responsePropertiesTable.setSizeFull();
        responsePropertiesTable.addContainerProperty("Property", String.class, null);
        responsePropertiesTable.addContainerProperty("Value", List.class, null);
        horizontalSplitPanel.addComponent(responsePropertiesTable);


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
//        urlLabel.setValue(url);
        UrlConnectionReader urlConnectionReader = new UrlConnectionReader();
        InputStream inputStream = null;
        try {
            inputStream = urlConnectionReader.fetch(new URL(url));
            JsonReader reader = getJsonReader(inputStream, "UTF-8");
            String prettyJsonString = prettyPrint(reader);
            payloadText.setValue(prettyJsonString);
            // FIXME don't want to set the table from within this method
            setResponsePropertiesTable(urlConnectionReader.getResponseProperties());
            
        } catch (MalformedURLException e) {
            LOG.error("Malformed URL", e);
        } catch (IOException e) {
            LOG.error("Failed to convert InputStream to String", e);
        } finally {
            urlConnectionReader.disconnect();
            try {
                inputStream.close();
            } catch (IOException e) {
                LOG.error("Unable to close InputStream", e);
            }
        }
    }
    
    private void setResponsePropertiesTable(Map<String, List<String>> requestProperties) {
        responsePropertiesTable.removeAllItems();
        for (Map.Entry<String, List<String>> entry : requestProperties.entrySet()){
            responsePropertiesTable.addItem(new Object[]{entry.getKey(), entry.getValue()}, null);
        }
    }
    
    
    private JsonReader getJsonReader(InputStream json, String characterEncoding) {
        JsonReader reader = null;
        try {
            reader = new JsonReader(new InputStreamReader(json, characterEncoding));
        } catch (UnsupportedEncodingException e) {
            LOG.error(characterEncoding +" not supported", e);
        }
        return reader;
    }

    private String prettyPrint(JsonReader reader) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(reader);
        return gson.toJson(jsonElement);
    }
}
