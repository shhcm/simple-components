package com.simplecomponents.accordion;

import java.util.List;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class Accordion extends RepeatingView {
    
    private static final long serialVersionUID = 1371163648592410548L;
    private List<AccordionItem> panelList;
    
    public Accordion(String id, List<AccordionItem> panelList) {
        super(id);
        this.panelList = panelList;
        
        for(AccordionItem currentItem: this.panelList) {
            // This is what we do if we want to register an arbitrary number of child elements dynamically.
            AccordionPanel repeatedAccordionPanel = new AccordionPanel(this.newChildId());
            repeatedAccordionPanel.add(currentItem.getContentPanel());
            repeatedAccordionPanel.add(new Label(AccordionPanel.TITLE_ID, currentItem.getTitle()));
            this.add(repeatedAccordionPanel);
        }
    }
    /**
    * These functions needs to be called by the page that is displaying this accordion
    * and the returned ressource must be added to the html header. 
    */
    public static JavaScriptResourceReference getJavascriptForHeader() {
        return new JavaScriptResourceReference(Accordion.class, "Accordion.js");
    }
    public static CssResourceReference getCssForHeader() {
        return new CssResourceReference(Accordion.class, "Accordion.css");
    }
    @Override
    public void renderHead(IHeaderResponse response ) {
        response.render(JavaScriptHeaderItem.forReference(getApplication().getJavaScriptLibrarySettings().getJQueryReference()));
        response.render(JavaScriptReferenceHeaderItem.forReference(Accordion.getJavascriptForHeader()));
        response.render(CssReferenceHeaderItem.forReference(Accordion.getCssForHeader()));
    }
}
