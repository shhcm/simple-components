package TabbedAjaxPanel;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;

public class TabbedAjaxPanel extends Panel{
    
    private static final long serialVersionUID = -4310551046617566060L;

    public TabbedAjaxPanel(String wicketId, List<Tab> tabList) {
        super(wicketId);
        RepeatingView repeatingView = new RepeatingView("tabbed-ajax-panel-tab-link");
        final TabPanel tabPanel = new TabPanel("tabbed-ajax-panel-content", tabList.get(0).getTabContentPanel());
        tabPanel.setOutputMarkupId(true); // Ajax needs an id to modify the element.
        
        for (final Tab tab: tabList) {
            System.out.println("Added tab "+ tab.getTabName() + " " + tab.getTabContentPanel().toString());
            AjaxLink<Void> ajaxLink = new AjaxLink<Void>(TabAjaxLink.LINK_ID) {

                private static final long serialVersionUID = -4994060829564891878L;

                @Override
                public void onClick(AjaxRequestTarget target) {
                    tabPanel.remove("content-tab");
                    tabPanel.add(tab.getTabContentPanel());
                    target.add(tabPanel);
                }
            };
            Label label = new Label(TabAjaxLink.LINK_LABEL_ID, tab.getTabName());
            TabAjaxLink tabAjaxLink = new TabAjaxLink(repeatingView.newChildId(), ajaxLink, label);
            repeatingView.add(tabAjaxLink);
            
        }
        add(repeatingView);
        add(tabPanel);
    }

}
