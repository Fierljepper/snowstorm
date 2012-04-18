package net.snowstorm.gui.wow;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import net.snowstorm.core.url.BattlenetApiUrlImpl;
import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.core.url.UrlConnectionReader;
import net.snowstorm.core.utils.ReflectionHelper;
import net.snowstorm.core.utils.UrlConnectionHelper;
import net.snowstorm.gui.SnowstormApplication;
import net.snowstorm.gui.TransactionLayout;
import net.snowstorm.gui.wow.components.*;
import net.snowstorm.wow.WowApi;
import net.snowstorm.wow.api.auctionresources.CurrentAuctionsApi;
import net.snowstorm.wow.api.auctionresources.CurrentAuctionsDataApi;
import net.snowstorm.wow.api.characterresources.CharacterProfileApi;
import net.snowstorm.wow.api.guildresources.GuildProfileApi;
import net.snowstorm.wow.api.itemresources.ItemApi;
import net.snowstorm.wow.api.realmresources.RealmStatusApi;
import net.snowstorm.wow.beans.auctionresources.CurrentAuctionsData;
import net.snowstorm.wow.beans.auctionresources.File;
import net.snowstorm.wow.beans.realmresources.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: brandsema
 * Date: 1/18/12
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class WowLayout extends VerticalLayout {

    private static final Logger LOG = LoggerFactory.getLogger(WowLayout.class);


    public static final String CHARACTER_PROFILE_API_CAPTION = "Character Profile";
    public static final String CURRENT_AUCTIONS_API_CAPTION = "Current Auctions";
    public static final String GUILD_PROFILE_API_CAPTION = "Guild Profile";
    public static final String ITEM_API_CAPTION = "Item";
    public static final String REALM_STATUS_API_CAPTION = "Realm Status";


    private static final BattlenetRegion[] regionValues = BattlenetRegion.values();
    public static final Map<BattlenetRegion, List<Realm>> regionRealmsMap = new HashMap<BattlenetRegion, List<Realm>>();

    private Form form = new Form();
    private HorizontalLayout buttons = new HorizontalLayout();

    private final TransactionLayout transactionLayout;

    private Button characterProfileButton;
    private Button currentAuctionsDataButton;
    private Button guildProfileButton;
    private Button itemButton;
    private Button realmStatusButton;


    WowApi wowApi;

    
    static {
        fillRegionRealmsMap();
    }

    private List<Button> apiSelectionButtons = new ArrayList<Button>();

    SnowstormApplication snowstormApplication;

    @Override
    public void attach(){
        super.attach();
        snowstormApplication = (SnowstormApplication) getApplication();
    }

    public WowLayout(){

        // Api selection buttons horizontal layout
        HorizontalLayout apiButtonSelectLayout = new HorizontalLayout();
        apiButtonSelectLayout.setSpacing(true);
        apiButtonSelectLayout.setMargin(true, false, true, true);
        addComponent(apiButtonSelectLayout);

        ApiSelectButtonClickListener apiSelectButtonClickListener = new ApiSelectButtonClickListener();
        characterProfileButton = new Button(CHARACTER_PROFILE_API_CAPTION, apiSelectButtonClickListener);
        characterProfileButton.setEnabled(false);
        currentAuctionsDataButton = new Button(CURRENT_AUCTIONS_API_CAPTION, apiSelectButtonClickListener);
        guildProfileButton = new Button(GUILD_PROFILE_API_CAPTION, apiSelectButtonClickListener);
        itemButton = new Button(ITEM_API_CAPTION, apiSelectButtonClickListener);
        realmStatusButton = new Button(REALM_STATUS_API_CAPTION, apiSelectButtonClickListener);
        apiButtonSelectLayout.addComponent(characterProfileButton);
        apiButtonSelectLayout.addComponent(currentAuctionsDataButton);
        apiButtonSelectLayout.addComponent(guildProfileButton);
        apiButtonSelectLayout.addComponent(itemButton);
        apiButtonSelectLayout.addComponent(realmStatusButton);

        // add all the api selection buttons to a list
        apiSelectionButtons.add(characterProfileButton);
        apiSelectionButtons.add(currentAuctionsDataButton);
        apiSelectionButtons.add(guildProfileButton);
        apiSelectionButtons.add(itemButton);
        apiSelectionButtons.add(realmStatusButton);

        apiSwitcher(CHARACTER_PROFILE_API_CAPTION);
        addComponent(form);

        // The reset / submit buttons

        buttons.setSpacing(true);
        Button reset = new Button("Reset",
                new Button.ClickListener() {
                    public void buttonClick(Button.ClickEvent event) {
                        form.discard();
                    }
                });
        buttons.addComponent(reset);
        buttons.setComponentAlignment(reset, Alignment.MIDDLE_LEFT);

        Button submit = new Button("Submit", new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                // Persist the form data to the wowApi
                form.commit();

                UrlConnectionHelper urlConnectionHelper = new UrlConnectionHelper();
                String apiUrl = wowApi.getUrl();
                byte [] bytes = urlConnectionHelper.urlPayloadToByteArray(apiUrl);

                try {
                    if (wowApi instanceof CurrentAuctionsApi){
                        File[] files = ((CurrentAuctionsApi) wowApi).getBeanPayload(new ByteArrayInputStream(bytes)).getFiles();
                        String url = files[0].getUrl();
                        if (url!= null){
                            byte[] auctionDataBytes = urlConnectionHelper.urlPayloadToByteArray(url);
                            CurrentAuctionsDataApi currentAuctionsDataApi = new CurrentAuctionsDataApi();
                            CurrentAuctionsData auctionsData  = currentAuctionsDataApi.getBeanPayload(new ByteArrayInputStream(auctionDataBytes));

                            int noAllianceAuc = auctionsData.getAlliance().getAuctions().length;
                            int noHordeAuc = auctionsData.getHorde().getAuctions().length;
                            int noNeutralAuc = auctionsData.getNeutral().getAuctions().length;
                            int totalAuc = noAllianceAuc + noHordeAuc + noNeutralAuc;
                            // TODO printf this
                            getTransactionLayout().setBeanPayload("DATASET TO LARGE TO REFLECT!" +
                                    "\n\nNumber of auctions on " + auctionsData.getRealm().getName() +
                                    "\n==========================================" +
                                    "\nAlliance: " + Integer.toString(noAllianceAuc) +
                                    "\nHorde: " + Integer.toString(noHordeAuc) +
                                    "\nNeutral: " + Integer.toString(noNeutralAuc) +
                                    "\n==========================================" +
                                    "\nTotal: " + Integer.toString(totalAuc)
                            );
                            getTransactionLayout().setJsonPayload(currentAuctionsDataApi.getJsonPayload(new ByteArrayInputStream(auctionDataBytes)));
                        }
                    } else {
                        getTransactionLayout().setJsonPayload(wowApi.getJsonPayload(new ByteArrayInputStream(bytes)));
                        getTransactionLayout().setBeanPayload((new ReflectionHelper()).reflectMethodState(wowApi
                                .getBeanPayload(new ByteArrayInputStream(bytes))));
                    }
                    // Set the header tables
                    getTransactionLayout().setRequestPropertiesTable(urlConnectionHelper.getUrlConnectionReader().getRequestProperties());
                    getTransactionLayout().setResponsePropertiesTable(urlConnectionHelper.getUrlConnectionReader().getResponseProperties());
                } catch (Exception e) {
                    LOG.error("Catch all: ", e);
                }
            }
        });
        buttons.addComponent(submit);
        form.getFooter().addComponent(buttons);
        form.getFooter().setMargin(true, false, true, true);
        
        
        transactionLayout = new TransactionLayout();
        transactionLayout.setSizeFull();
        addComponent(transactionLayout);


        setExpandRatio(transactionLayout, 1);
    }

    public TransactionLayout getTransactionLayout() {
        return transactionLayout;
    }

    private static void fillRegionRealmsMap(){
        BattlenetApiUrlImpl battlenetApiImpl = new RealmStatusApi();
        UrlConnectionReader urlConnectionReader = new UrlConnectionReader();
        for(BattlenetRegion region: regionValues){
            List<Realm> realmsList = new ArrayList<Realm>();
            battlenetApiImpl.setRegion(region);
            InputStream inputStream = null;
            try {
                inputStream = urlConnectionReader.fetch(new URL(battlenetApiImpl.getUrl()));
                if (inputStream != null){
                    JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
                    Gson gson = new Gson();
                    net.snowstorm.wow.beans.realmresources.RealmStatus realmStatus = gson.fromJson(reader, net.snowstorm.wow.beans.realmresources.RealmStatus.class);
                    for(Realm realm: realmStatus.getRealms()){
                        realmsList.add(realm);
                    }
                    regionRealmsMap.put(region, realmsList);
                }
            } catch (MalformedURLException e) {
                LOG.error("Malformed URL", e);
            } catch (IOException e) {
                LOG.error("Failed to convert InputStream to String", e);
            } finally {
                urlConnectionReader.disconnect();
                try {
                    if (inputStream != null){
                        inputStream.close();
                    }
                } catch (IOException e) {
                    LOG.error("Unable to close InputStream", e);
                }
            }
        }
    }

    private class ApiSelectButtonClickListener implements Button.ClickListener {

        @Override
        public void buttonClick(final Button.ClickEvent event) {
            Button clickedButton = event.getButton();
            apiSwitcher(clickedButton.getCaption());
        }
    }
    
    private void apiSwitcher(String apiCaption){
        Form form = new Form();
        if (CHARACTER_PROFILE_API_CAPTION.equals(apiCaption)){
            wowApi = new CharacterProfileApi();
            BeanItem<CharacterProfileApi> characterProfileBeanItem = new BeanItem<CharacterProfileApi>((CharacterProfileApi)wowApi);
            form = new CharacterProfileForm(characterProfileBeanItem);
        } else if (CURRENT_AUCTIONS_API_CAPTION.equals(apiCaption)){
            wowApi = new CurrentAuctionsApi();
            BeanItem<CurrentAuctionsApi> currentAuctionsBeanItem = new BeanItem<CurrentAuctionsApi>((CurrentAuctionsApi)
                    wowApi);
            form = new CurrentAuctionsForm(currentAuctionsBeanItem);
        } else if (GUILD_PROFILE_API_CAPTION.equals(apiCaption)){
            wowApi = new GuildProfileApi();
            BeanItem<GuildProfileApi> guildProfileBeanItem = new BeanItem<GuildProfileApi>((GuildProfileApi)
                    wowApi);
            form = new GuildProfileForm(guildProfileBeanItem);
        } else if (ITEM_API_CAPTION.equals(apiCaption)){
            wowApi = new ItemApi();
            BeanItem<ItemApi> itemBeanItem = new BeanItem<ItemApi>((ItemApi)wowApi);
            form = new ItemForm(itemBeanItem);
        } else if (REALM_STATUS_API_CAPTION.equals(apiCaption)){
            wowApi = new RealmStatusApi();
            BeanItem<RealmStatusApi> realmStatusBeanItem = new BeanItem<RealmStatusApi>((RealmStatusApi)wowApi);
            form = new RealmStatusForm(realmStatusBeanItem);
        }

        setApiButtonState(apiCaption);

        form.getFooter().addComponent(buttons);
        form.getFooter().setMargin(true, false, true, true);

        this.replaceComponent(this.form, form);
        this.form = form;
    }

    private void setApiButtonState(String apiCaption){
        for (Button apiSelectionButton: apiSelectionButtons){
            if (apiSelectionButton.getCaption().equals(apiCaption)){
                apiSelectionButton.setEnabled(false);
            } else {
                apiSelectionButton.setEnabled(true);
            }
        }
    }
}
