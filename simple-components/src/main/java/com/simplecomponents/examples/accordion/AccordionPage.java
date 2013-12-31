package com.simplecomponents.examples.accordion;

import java.util.LinkedList;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.simplecomponents.accordion.Accordion;
import com.simplecomponents.accordion.AccordionItem;
import com.simplecomponents.accordion.AccordionPanel;
import com.simplecomponents.examples.BasePage;
import com.simplecomponents.examples.MyPanel;

public class AccordionPage extends BasePage {

    private static final long serialVersionUID = -4330009888522105536L;

    public AccordionPage(PageParameters pageParameters) {
        super(pageParameters);
        
        LinkedList<AccordionItem> accordionItems = new LinkedList<AccordionItem>();
        for(int i = 0; i < 10; i++) {
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
