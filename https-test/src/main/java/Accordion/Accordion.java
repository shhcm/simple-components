package Accordion;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class Accordion extends RepeatingView {
    
    public static final String CONTENT_ID = "accordion-item-content";
    public static final String TITLE_ID = "accortion-item-title";
    
    private static final long serialVersionUID = 1371163648592410548L;
    private List<AccordionItem> panelList;
    
    public Accordion(String id, List<AccordionItem> panelList) {
        super(id);
        this.panelList = panelList;
        
        for(AccordionItem currentItem: this.panelList) {
            // This is what we do if we want to register an arbitrary number of child elements dynamically.
            AccordionPanel repeatedAccordionPanel = new AccordionPanel(this.newChildId());
            repeatedAccordionPanel.add(currentItem.getContentPanel());
            repeatedAccordionPanel.add(new Label(TITLE_ID, currentItem.getTitle()));
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
}
