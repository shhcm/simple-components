package com.simplecomponents;

import java.util.LinkedList;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

import com.simplecomponents.examples.MyPanel;
import com.simplecomponents.examples.SomeContentPanel;
import com.simplecomponents.tabbedajaxpanel.Tab;
import com.simplecomponents.tabbedajaxpanel.TabPanel;
import com.simplecomponents.tabbedajaxpanel.TabbedAjaxPanel;

public class TabbedAjaxPanelHomePage extends WebPage{

    private static final long serialVersionUID = 6546796359662225200L;

    public TabbedAjaxPanelHomePage() {
        LinkedList<Tab> tabList = new LinkedList<Tab>();
        Label label = new Label("panel-content", "Some label");
        MyPanel myPanel = new MyPanel(TabPanel.CONTENT_ID);
        myPanel.add(label);
        tabList.add(new Tab("tab 1", new SomeContentPanel(TabPanel.CONTENT_ID, "Content of tab 1")));
        tabList.add(new Tab("tab 2", new SomeContentPanel(TabPanel.CONTENT_ID, "Content of tab 2")));
        tabList.add(new Tab("tab 3", new SomeContentPanel(TabPanel.CONTENT_ID, "Content of tab 3")));
        tabList.get(0).setHighlighted(true);
        TabbedAjaxPanel tabbedAjaxPanel = new TabbedAjaxPanel("tabbed-ajax-panel", tabList);
        tabbedAjaxPanel.setJavascriptOnTabLoaded("initAccordion();");
        add(tabbedAjaxPanel);
    }
}
