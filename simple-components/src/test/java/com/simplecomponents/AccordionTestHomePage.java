package com.simplecomponents;

import java.util.LinkedList;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.simplecomponents.accordion.Accordion;
import com.simplecomponents.accordion.AccordionItem;
import com.simplecomponents.accordion.AccordionPanel;

public class AccordionTestHomePage extends WebPage{

    private static final long serialVersionUID = -2202153740633427898L;

    public AccordionTestHomePage(final PageParameters pageParameters) {
        LinkedList<AccordionItem> accordionItems = new LinkedList<AccordionItem>();
        for(int i = 0; i < 3; i++) {
            // Create some content panels
            Panel contentPanel = new MyPanel(AccordionPanel.CONTENT_ID);
            Label repeatedLabel = new Label("panel-content", "repeatedPanel " + i);
            contentPanel.add(repeatedLabel);
            accordionItems.add(new AccordionItem("title " + i, contentPanel));
        }
        Accordion accordion = new Accordion("accordion", accordionItems);
        add(accordion);
    }
}
