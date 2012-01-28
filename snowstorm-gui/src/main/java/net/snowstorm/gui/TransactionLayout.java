package net.snowstorm.gui;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

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


    private Label payloadText;
    private Table payloadTable = new Table();
    private Table requestPropertiesTable = new Table();
    private Table responsePropertiesTable = new Table();
    private HorizontalSplitPanel horizontalSplitPanel;


    public TransactionLayout(){

        horizontalSplitPanel = new HorizontalSplitPanel();
        horizontalSplitPanel.setSplitPosition(50, Sizeable.UNITS_PERCENTAGE);
        horizontalSplitPanel.setSizeFull();
        horizontalSplitPanel.setLocked(false);
        addComponent(horizontalSplitPanel);

        payloadTable.setSizeFull();
        payloadTable.addContainerProperty("API Payload", Label.class, null);
        horizontalSplitPanel.addComponent(payloadTable);

        payloadText = new Label();
        payloadText.setContentMode(Label.CONTENT_PREFORMATTED);
        payloadTable.addItem(new Object[]{payloadText}, null);

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

    public void setPayload(String payload){
        payloadText.setValue(payload);
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
