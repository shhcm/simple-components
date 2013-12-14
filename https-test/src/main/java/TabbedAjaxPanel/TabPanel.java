package TabbedAjaxPanel;

import org.apache.wicket.markup.html.panel.Panel;

public class TabPanel extends Panel{
    public static final String CONTENT_TAB_ID = "content-tab";
    private static final long serialVersionUID = -7357775325750378416L;
    
    public TabPanel(String id, Panel contentTab) {
        super(id);
        this.add(contentTab);
    }
    
    public void addContentTab(Panel contentTab) {
        this.add(contentTab);
    }

}
