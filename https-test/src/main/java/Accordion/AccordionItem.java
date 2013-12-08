package Accordion;

import org.apache.wicket.markup.html.panel.Panel;

public class AccordionItem {
    private String title;
    private Panel contentPanel;
    
    public AccordionItem(String title, Panel contentPanel) {
        super();
        this.title = title;
        this.contentPanel = contentPanel;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Panel getContentPanel() {
        return contentPanel;
    }
    public void setContentPanel(Panel contentPanel) {
        this.contentPanel = contentPanel;
    }
}
