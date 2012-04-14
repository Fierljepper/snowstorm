package net.snowstorm.gui.wow;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import net.snowstorm.core.url.BattlenetApiUrlImpl;
import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.core.url.UrlConnectionReader;
import net.snowstorm.core.utils.ReflectionHelper;
import net.snowstorm.gui.SnowstormApplication;
import net.snowstorm.gui.TransactionLayout;
import net.snowstorm.gui.wow.components.CharacterProfileForm;
import net.snowstorm.gui.wow.components.GuildProfileForm;
import net.snowstorm.gui.wow.components.RealmStatusForm;
import net.snowstorm.wow.WowApi;
import net.snowstorm.wow.api.CharacterProfileApi;
import net.snowstorm.wow.api.GuildProfileApi;
import net.snowstorm.wow.api.RealmStatusApi;
import net.snowstorm.wow.beans.Realm;
import net.snowstorm.wow.beans.RealmStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public static final String REALM_STATUS_API_CAPTION = "Realm Status API";
    public static final String CHARACTER_PROFILE_API_CAPTION = "Character Profile API";
    public static final String GUILD_PROFILE_API_CAPTION = "Guild Profile API";

    private static final BattlenetRegion[] regionValues = BattlenetRegion.values();
    public static final Map<BattlenetRegion, List<Realm>> regionRealmsMap = new HashMap<BattlenetRegion, List<Realm>>();

    private Form form = new Form();
    private HorizontalLayout buttons = new HorizontalLayout();

    private final TransactionLayout transactionLayout;

    private Button realmStatusButton;
    private Button characterProfileButton;
    private Button guildProfileButton;

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
        guildProfileButton = new Button(GUILD_PROFILE_API_CAPTION, apiSelectButtonClickListener);
        realmStatusButton = new Button(REALM_STATUS_API_CAPTION, apiSelectButtonClickListener);
        apiButtonSelectLayout.addComponent(characterProfileButton);
        apiButtonSelectLayout.addComponent(guildProfileButton);
        apiButtonSelectLayout.addComponent(realmStatusButton);

        // add all the api selection buttons to a list
        apiSelectionButtons.add(characterProfileButton);
        apiSelectionButtons.add(guildProfileButton);
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
                try {
                    form.commit();
                    // TODO fires request for each payload type: fire once
                    getTransactionLayout().setJsonPayload(wowApi.getJsonPayload(wowApi.getUrl()));
                    getTransactionLayout().setBeanPayload((new ReflectionHelper()).reflectMethodState(wowApi
                            .getBeanPayload(wowApi.getUrl())));
                    getTransactionLayout().setRequestPropertiesTable(wowApi.getUrlConnectionReader().getRequestProperties());
                    getTransactionLayout().setResponsePropertiesTable(wowApi.getUrlConnectionReader().getResponseProperties());
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
                    RealmStatus realms = gson.fromJson(reader, RealmStatus.class);
                    for(Realm realm: realms.getRealms()){
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
        if (REALM_STATUS_API_CAPTION.equals(apiCaption)){
            wowApi = new RealmStatusApi();
            BeanItem<RealmStatusApi> realmStatusBeanItem = new BeanItem<RealmStatusApi>((RealmStatusApi)wowApi);
            form = new RealmStatusForm(realmStatusBeanItem);
        } else if (GUILD_PROFILE_API_CAPTION.equals(apiCaption)){
            wowApi = new GuildProfileApi();
            BeanItem<GuildProfileApi> guildProfileBeanItem = new BeanItem<GuildProfileApi>((GuildProfileApi)
                    wowApi);
            form = new GuildProfileForm(guildProfileBeanItem);
        } else if (CHARACTER_PROFILE_API_CAPTION.equals(apiCaption)){
            wowApi = new CharacterProfileApi();
            BeanItem<CharacterProfileApi> characterProfileBeanItem = new BeanItem<CharacterProfileApi>((CharacterProfileApi)wowApi);
            form = new CharacterProfileForm(characterProfileBeanItem);
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
