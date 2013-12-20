package com.mycompany;

import java.util.LinkedList;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

import Accordion.Accordion;
import Accordion.AccordionItem;
import Accordion.AccordionPanel;

public class SomeContentPanel extends Panel{

    public SomeContentPanel(String id, String content) {
        super(id);
        Label label = new Label("content-of-panel", content);
        this.add(label);
        LinkedList<AccordionItem> accordionItems = new LinkedList<AccordionItem>();
        for(int i = 0; i < 20; i++) {
            // Create some content panels
            Panel contentPanel = new MyPanel(AccordionPanel.CONTENT_ID);
            Label repeatedLabel = new Label("panel-content", "repeatedPanel " + i);
            contentPanel.add(repeatedLabel);
            accordionItems.add(new AccordionItem("title " + i, contentPanel));
        }
        Accordion accordion = new Accordion("panel-accordion", accordionItems);
        add(accordion);
    }

    private static final long serialVersionUID = -8445737900438513659L;

}
