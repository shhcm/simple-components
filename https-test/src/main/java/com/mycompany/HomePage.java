package com.mycompany;

import java.util.LinkedList;

import org.apache.wicket.protocol.https.RequireHttps;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.WebPage;

import TabbedAjaxPanel.Tab;
import TabbedAjaxPanel.TabPanel;
import TabbedAjaxPanel.TabbedAjaxPanel;
import Accordion.Accordion;
import Accordion.AccordionItem;
import Accordion.AccordionPanel;
@RequireHttps
public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
        super(parameters);
        
        LinkedList<Tab> tabList = new LinkedList<Tab>();
        tabList.add(new Tab("tab 1", new SomeContentPanel(TabPanel.CONTENT_ID, "Content of tab 1\nContent of tab 1\nContent of tab 1\n")));
        tabList.add(new Tab("tab 2", new SomeContentPanel(TabPanel.CONTENT_ID, "Content of tab 2\nContent of tab 2\nContent of tab 2\nContent of tab 2\n")));
        tabList.add(new Tab("tab 3", new SomeContentPanel(TabPanel.CONTENT_ID, "Content of tab 3\nContent of tab 3\nContent of tab 3\n")));
        tabList.get(0).setHighlighted(true);
        TabbedAjaxPanel tabbedAjaxPanel = new TabbedAjaxPanel("tabbed-ajax-panel", tabList);
        add(tabbedAjaxPanel);
        
        /*
        Label label = new Label("panel-content", "initial content");
        // Create a container element whose content will be modifed via ajax.
        // The element must be final, because it is accessed from within an inner class,
        // but we will be able to modify its content.
        final MyPanel panel = new MyPanel("ajax-content");
        panel.setOutputMarkupId(true);
        // Create an ajax link.
        AjaxLink ajaxLink = new AjaxLink("ajax-link") {
        
            @Override
            public void onClick(AjaxRequestTarget target) {
                panel.remove("panel-content");
                panel.add(new Label("panel-content","ajax-provided content"));
                // The component that is modified via ajax must be added to the AjaxRequestTarget parameter.
                target.add(panel);
            }
            
        };
        panel.add(label);
        add(panel);
        add(ajaxLink);
        */
        // Accordion Component.
        LinkedList<AccordionItem> accordionItems = new LinkedList<AccordionItem>();
        for(int i = 0; i < 20; i++) {
            // Create some content panels
            Panel contentPanel = new MyPanel(AccordionPanel.CONTENT_ID);
            Label repeatedLabel = new Label("panel-content", "repeatedPanel " + i);
            contentPanel.add(repeatedLabel);
            accordionItems.add(new AccordionItem("title " + i, contentPanel));
        }
        
        Accordion accordion = new Accordion("accordion", accordionItems);
        add(accordion);
    }
    // Write the required css and js files of the accordion to the html head.
    @Override
    public void renderHead(IHeaderResponse response) {
        response.render(JavaScriptReferenceHeaderItem.forReference(Accordion.getJavascriptForHeader()));
        response.render(CssReferenceHeaderItem.forReference(Accordion.getCssForHeader()));
        response.render(CssReferenceHeaderItem.forReference(TabbedAjaxPanel.getCssForHeader()));
    }
}
