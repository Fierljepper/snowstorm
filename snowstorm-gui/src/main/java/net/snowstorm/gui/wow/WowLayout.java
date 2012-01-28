package net.snowstorm.gui.wow;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import net.snowstorm.core.url.BattlenetApiUrlImpl;
import net.snowstorm.core.url.BattlenetRegion;
import net.snowstorm.core.url.UrlConnectionReader;
import net.snowstorm.gui.SnowstormApplication;
import net.snowstorm.gui.TransactionLayout;
import net.snowstorm.gui.wow.components.RealmStatusForm;
import net.snowstorm.wow.api.RealmStatus;
import net.snowstorm.wow.beans.Realm;
import net.snowstorm.wow.beans.Realms;
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

    private static final BattlenetRegion[] regionValues = BattlenetRegion.values();
    public static final Map<BattlenetRegion, List<Realm>> regionRealmsMap = new HashMap<BattlenetRegion, List<Realm>>();

    private final RealmStatusForm realmStatusForm;

    private final TransactionLayout transactionLayout;

    static {
        fillRegionRealmsMap();
    }


    SnowstormApplication snowstormApplication;

    @Override
    public void attach(){
        super.attach();
        snowstormApplication = (SnowstormApplication) getApplication();
    }

    public WowLayout(){
        final RealmStatus realmStatus = new RealmStatus();
        BeanItem<RealmStatus> realmStatusBeanItem = new BeanItem<RealmStatus>(realmStatus);
        realmStatusForm = new RealmStatusForm(realmStatusBeanItem);
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
                    getTransactionLayout().setPayload(realmStatus.getJsonPayload(realmStatus.getUrl()));
                    getTransactionLayout().setRequestPropertiesTable(realmStatus.getUrlConnectionReader().getRequestProperties());
                    getTransactionLayout().setResponsePropertiesTable(realmStatus.getUrlConnectionReader().getResponseProperties());
                } catch (Exception e) {
                    // Ignored, we'll let the Form handle the errors
                }
            }
        });
        buttons.addComponent(submit);
        realmStatusForm.getFooter().addComponent(buttons);
        realmStatusForm.getFooter().setMargin(false, false, true, true);
        
        
        transactionLayout = new TransactionLayout();
        transactionLayout.setSizeFull();
        addComponent(transactionLayout);


        setExpandRatio(transactionLayout, 1);
    }

    public TransactionLayout getTransactionLayout() {
        return transactionLayout;
    }

    private static void fillRegionRealmsMap(){
        BattlenetApiUrlImpl battlenetApiImpl = new RealmStatus();
        UrlConnectionReader urlConnectionReader = new UrlConnectionReader();
        for(BattlenetRegion region: regionValues){
            List<Realm> realmsList = new ArrayList<Realm>();
            battlenetApiImpl.setRegion(region);
            InputStream inputStream = null;
            try {
                inputStream = urlConnectionReader.fetch(new URL(battlenetApiImpl.getUrl()));
                JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
                Gson gson = new Gson();
                Realms realms = gson.fromJson(reader, Realms.class);
                for(Realm realm: realms.getRealms()){
                    realmsList.add(realm);
                }
                regionRealmsMap.put(region, realmsList);

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
    }
}
