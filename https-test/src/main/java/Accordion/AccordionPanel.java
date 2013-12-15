package Accordion;

import org.apache.wicket.markup.html.panel.Panel;

public class AccordionPanel extends Panel{

    private static final long serialVersionUID = 1969056775214737437L;

    public static final String CONTENT_ID = "accordion-item-content";
    public static final String TITLE_ID = "accortion-item-title";
    
    public AccordionPanel(String id) {
        super(id);
    }
    public AccordionPanel(String id, Panel contentPanel) {
        super(id);
        add(contentPanel);
    }
}
