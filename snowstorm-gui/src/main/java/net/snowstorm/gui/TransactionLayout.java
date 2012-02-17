package net.snowstorm.gui;

import com.vaadin.terminal.ClassResource;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: developer
 * Date: 1/28/12
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionLayout extends VerticalLayout {

    private ClassResource JSON_ICON;
//    public final ExternalResource D3_ICON_EXTERNAL_RESOURCE = new ExternalResource("http://us.battle.net/d3/static/local-common/images/favicons/d3.ico");

    private Label payloadBeanLabel;
    private Label payloadXmlLabel;
    private Label payloadJsonLabel;
    private Accordion payloadAccordion = new Accordion();
    private Table requestPropertiesTable = new Table();
    private Table responsePropertiesTable = new Table();
    private HorizontalSplitPanel horizontalSplitPanel;


    public TransactionLayout(){

        horizontalSplitPanel = new HorizontalSplitPanel();
        horizontalSplitPanel.setSplitPosition(50, Sizeable.UNITS_PERCENTAGE);
        horizontalSplitPanel.setSizeFull();
        horizontalSplitPanel.setLocked(false);
        addComponent(horizontalSplitPanel);

        payloadAccordion.setSizeFull();

        horizontalSplitPanel.addComponent(payloadAccordion);

        payloadBeanLabel = new Label();
        payloadBeanLabel.setContentMode(Label.CONTENT_PREFORMATTED);
        payloadAccordion.addTab(payloadBeanLabel, "API PAYLOAD AS BEAN");

        payloadXmlLabel = new Label();
        payloadXmlLabel.setContentMode(Label.CONTENT_PREFORMATTED);
//        payloadAccordion.addTab(payloadXmlLabel, "API PAYLOAD AS XML");

        payloadJsonLabel = new Label();
        payloadJsonLabel.setContentMode(Label.CONTENT_PREFORMATTED);
        payloadAccordion.addTab(payloadJsonLabel, "API PAYLOAD AS JSON", JSON_ICON);
        payloadAccordion.setSelectedTab(payloadJsonLabel);

        VerticalLayout requestResponseLayout = new com.vaadin.ui.VerticalLayout();
        requestResponseLayout.setSizeFull();
        horizontalSplitPanel.addComponent(requestResponseLayout);

        requestPropertiesTable.setSizeFull();
        requestPropertiesTable.addContainerProperty("Request Property", String.class, null);
        requestPropertiesTable.addContainerProperty("Request Value", String.class, null);
        requestResponseLayout.addComponent(requestPropertiesTable);

        responsePropertiesTable.setSizeFull();
        responsePropertiesTable.addContainerProperty("Response Property", String.class, null);
        responsePropertiesTable.addContainerProperty("Response Value", List.class, null);
        requestResponseLayout.addComponent(responsePropertiesTable);
    }

    public void setBeanPayload(String beanPayload){
        payloadBeanLabel.setValue(beanPayload);
    }

    public void setXmlPayload(String xmlPayload){
        payloadXmlLabel.setValue(xmlPayload);
    }

    public void setJsonPayload(String jsonPayload){
        payloadJsonLabel.setValue(jsonPayload);
    }

    public void setRequestPropertiesTable(Map<String, String> requestProperties) {
        requestPropertiesTable.removeAllItems();
        for (Map.Entry<String, String> entry : requestProperties.entrySet()){
            requestPropertiesTable.addItem(new Object[]{entry.getKey(), entry.getValue()}, null);
        }
    }

    public void setResponsePropertiesTable(Map<String, List<String>> requestProperties) {
        responsePropertiesTable.removeAllItems();
        for (Map.Entry<String, List<String>> entry : requestProperties.entrySet()){
            responsePropertiesTable.addItem(new Object[]{entry.getKey(), entry.getValue()}, null);
        }
    }
}
