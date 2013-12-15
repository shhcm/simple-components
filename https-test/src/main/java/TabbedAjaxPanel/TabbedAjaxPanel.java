package TabbedAjaxPanel;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.CssResourceReference;

public class TabbedAjaxPanel extends Panel{
    
    private static final long serialVersionUID = -4310551046617566060L;

    public TabbedAjaxPanel(String wicketId, List<Tab> tabList) {
        super(wicketId);
        final TabPanel tabPanel = new TabPanel("tabbed-ajax-panel-content", tabList.get(0).getTabContentPanel());
        tabPanel.setOutputMarkupId(true); // Ajax needs an id to modify the element.
        
        ListView<Tab> listView = new ListView<Tab>("tabbed-ajax-panel-tab-link", tabList) {
            
            private static final long serialVersionUID = 2877781060599691449L;
            
            @Override
            protected void populateItem(final ListItem<Tab> item) {
                AjaxLink<Void> ajaxLink = new AjaxLink<Void>("tab-ajax-link-link") {

                    private static final long serialVersionUID = 1L;
                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        tabPanel.remove("content-tab");
                        tabPanel.add(item.getModelObject().getTabContentPanel());
                        target.add(tabPanel);
                        
                    }
                };
                Label label = new Label("tab-ajax-link-label", item.getModelObject().getTabName());
                ajaxLink.add(label);
                item.add(ajaxLink);
            }
            
        };
        add(listView);
        add(tabPanel);
    }
    
    public static CssResourceReference getCssForHeader() {
        return new CssResourceReference(TabbedAjaxPanel.class, "TabbedAjaxPanel.css");
    }

}
