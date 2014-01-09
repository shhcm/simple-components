package com.simplecomponents.examples;

import java.util.LinkedList;

import org.apache.wicket.protocol.https.RequireHttps;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.WebPage;

import com.simplecomponents.accordion.Accordion;
import com.simplecomponents.accordion.AccordionItem;
import com.simplecomponents.accordion.AccordionPanel;
import com.simplecomponents.multilevelmenu.MultiLevelMenu;
import com.simplecomponents.multilevelmenu.MultiLevelMenuItem;
import com.simplecomponents.tabbedajaxpanel.Tab;
import com.simplecomponents.tabbedajaxpanel.TabPanel;
import com.simplecomponents.tabbedajaxpanel.TabbedAjaxPanel;

public class HomePage extends BasePage {
    private static final long serialVersionUID = 3887031127365020010L;

    public HomePage(final PageParameters parameters) {
        super(parameters);
        /*
        LinkedList<MultiLevelMenuItem> pageList = new LinkedList<MultiLevelMenuItem>();
        for(int i = 0; i < 10; i++) {
            MultiLevelMenuItem item = new MultiLevelMenuItem("page link " + i, HomePage.class);
            if(i < 5) {
                LinkedList<MultiLevelMenuItem> subPageList = new LinkedList<MultiLevelMenuItem>();
                for(int j = 0; j < 3; j++) {
                    MultiLevelMenuItem subItem = new MultiLevelMenuItem("sub page link " + i, HomePage.class);
                    subPageList.add(subItem);
                }
                item.setSubMenu(subPageList);
            }
            pageList.add(item);
        }
        
        MultiLevelMenu multiLevelMenu = new MultiLevelMenu("multi-level-menu", pageList);
        add(multiLevelMenu);
        */
        LinkedList<Tab> tabList = new LinkedList<Tab>();
        Label label = new Label("panel-content", "This is a content panel of a tab.");
        MyPanel myPanel = new MyPanel(TabPanel.CONTENT_ID);
        myPanel.add(label);
        tabList.add(new Tab("tab a", myPanel));
        tabList.add(new Tab("tab b", new SomeContentPanel(TabPanel.CONTENT_ID, "Here's an accordion.")));
        tabList.add(new Tab("tab c", new SomeContentPanel(TabPanel.CONTENT_ID, "Another accordion.")));
        tabList.get(0).setHighlighted(true);
        TabbedAjaxPanel tabbedAjaxPanel = new TabbedAjaxPanel("tabbed-ajax-panel", tabList);
        tabbedAjaxPanel.setJavascriptOnTabLoaded("initAccordion();");
        add(tabbedAjaxPanel);
        
        
        LinkedList<AccordionItem> accordionItems = new LinkedList<AccordionItem>();
        for(int i = 0; i < 10; i++) {
            // Create some content panels
            Panel contentPanel = new MyPanel(AccordionPanel.CONTENT_ID);
            Label repeatedLabel = new Label("panel-content", "accordion panel " + i);
            contentPanel.add(repeatedLabel);
            accordionItems.add(new AccordionItem("title " + i, contentPanel));
        }
        Accordion accordion = new Accordion("accordion", accordionItems);
        add(accordion);
    }
}
