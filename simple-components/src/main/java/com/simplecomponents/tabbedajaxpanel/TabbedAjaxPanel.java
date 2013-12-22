package com.simplecomponents.tabbedajaxpanel;

import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.CssResourceReference;

import com.simplecomponents.accordion.Accordion;

public class TabbedAjaxPanel extends Panel{
    
    private static final long serialVersionUID = -4310551046617566060L;
    private ListItem<Tab> currentTab;
    private ListItem<Tab> previousTab;
    private String javascriptOnTabLoaded = null;

    public TabbedAjaxPanel(String wicketId, List<Tab> tabList) {
        super(wicketId);
        
        final TabPanel tabPanel = new TabPanel("tabbed-ajax-panel-content", tabList.get(0).getTabContentPanel());
        tabPanel.setOutputMarkupId(true);
        
        ListView<Tab> listView = new ListView<Tab>("tabbed-ajax-panel-tab-span", tabList) {
            
            private static final long serialVersionUID = 2877781060599691449L;
            
            @Override
            protected void populateItem(final ListItem<Tab> item) {
                item.setOutputMarkupId(true);
                if(item.getModelObject().isHighlighted()) {
                    // Mark the initially highlighted tab.
                    item.add(new AttributeModifier("class", "tabbed-ajax-panel-tab-span-highlighted"));
                    currentTab = item;
                    previousTab = item;
                } else {
                    item.add(new AttributeModifier("class", "tabbed-ajax-panel-tab-span-non-highlighted"));
                }
                
                AjaxLink<Void> ajaxLink = new AjaxLink<Void>("tab-ajax-link-link") {
                    
                    private static final long serialVersionUID = -4227997836245955031L;
                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        tabPanel.remove("content-tab");
                        tabPanel.add(item.getModelObject().getTabContentPanel());
                        target.add(tabPanel);
                        
                        if(previousTab == null || currentTab == null) {
                            currentTab = item;
                            previousTab = item;
                        }
                        
                        previousTab = currentTab;
                        currentTab = item;
                        
                        previousTab.add(new AttributeModifier("class", "tabbed-ajax-panel-tab-span-non-highlighted"));
                        currentTab.add(new AttributeModifier("class", "tabbed-ajax-panel-tab-span-highlighted"));
                        
                        target.add(previousTab);
                        target.add(currentTab);
                        if(javascriptOnTabLoaded != null) {
                            target.appendJavaScript(javascriptOnTabLoaded);
                        }
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
    
    public String getJavascriptOnTabLoaded() {
        return javascriptOnTabLoaded;
    }
    /**
     * Set a javascript that should be executed after a tab has loaded content via ajax.
     * @param javascriptOnTabLoaded The js to be executed.
     */
    public void setJavascriptOnTabLoaded(String javascriptOnTabLoaded) {
        this.javascriptOnTabLoaded = javascriptOnTabLoaded;
    }
    
    public static CssResourceReference getCssForHeader() {
        return new CssResourceReference(TabbedAjaxPanel.class, "TabbedAjaxPanel.css");
    }
    
    @Override
    public void renderHead(IHeaderResponse response) {
        response.render(CssReferenceHeaderItem.forReference(TabbedAjaxPanel.getCssForHeader()));
    }

}
