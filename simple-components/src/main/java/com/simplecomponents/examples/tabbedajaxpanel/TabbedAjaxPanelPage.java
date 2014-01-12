package com.simplecomponents.examples.tabbedajaxpanel;

import java.util.LinkedList;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.simplecomponents.examples.BasePage;
import com.simplecomponents.examples.MyPanel;
import com.simplecomponents.examples.SomeContentPanel;
import com.simplecomponents.tabbedajaxpanel.Tab;
import com.simplecomponents.tabbedajaxpanel.TabPanel;
import com.simplecomponents.tabbedajaxpanel.TabbedAjaxPanel;

public class TabbedAjaxPanelPage extends BasePage{

    private static final long serialVersionUID = 6337831478117817645L;

    public TabbedAjaxPanelPage(PageParameters pageParameters) {
        super(pageParameters);
        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae ornare elit. Praesent ut cursus ipsum. Pellentesque et turpis commodo, fringilla diam id, interdum magna. Proin quis sem adipiscing, pharetra tortor quis, pharetra est. Curabitur sed ullamcorper quam. Donec ac laoreet velit, id ornare enim. Integer congue enim venenatis euismod tempus. Praesent non nunc iaculis, pretium tortor vel, rhoncus dui. Aenean eget elementum justo. Donec at eleifend sem. Aliquam tempor, mauris id eleifend mollis, erat libero ultrices arcu, eu ornare erat sapien a metus. Duis congue mi quis purus vestibulum lobortis. Donec varius feugiat neque, ut elementum nisi posuere quis. Suspendisse ac posuere lorem, tincidunt tincidunt nibh. Donec a orci consequat, blandit lectus vel, pellentesque nulla.";
        LinkedList<Tab> tabList = new LinkedList<Tab>();
        Label label = new Label("panel-content", loremIpsum);
        MyPanel myPanel = new MyPanel(TabPanel.CONTENT_ID);
        myPanel.add(label);
        tabList.add(new Tab("tab 1", myPanel));
        tabList.add(new Tab("tab 2", new SomeContentPanel(TabPanel.CONTENT_ID, "Content of tab 2")));
        tabList.add(new Tab("tab 3", new SomeContentPanel(TabPanel.CONTENT_ID, "Content of tab 3")));
        tabList.get(0).setHighlighted(true);
        TabbedAjaxPanel tabbedAjaxPanel = new TabbedAjaxPanel("tabbed-ajax-panel", tabList);
        tabbedAjaxPanel.setJavascriptOnTabLoaded("initAccordion();");
        add(tabbedAjaxPanel);
    }
}
