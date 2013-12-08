package Accordion;

import org.apache.wicket.markup.html.panel.Panel;

public class AccordionPanel extends Panel{
    private Panel contentPanel;
    
    public AccordionPanel(String id) {
        super(id);
    }
    public AccordionPanel(String id, Panel contentPanel) {
        super(id);
        this.contentPanel = contentPanel;
        add(contentPanel);
    }
}
