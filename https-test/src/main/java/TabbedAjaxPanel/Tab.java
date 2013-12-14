package TabbedAjaxPanel;

import java.io.Serializable;

import org.apache.wicket.markup.html.panel.Panel;

/**
 * An Tabbed Ajax Panel will hold a list of Tab objects.
 * For each Tab object, an ajax link is created 
 * that loads the Panel of the Tab as the target into the
 * main content panel, removing any previous content of
 * that content panel. 
 **/
public class Tab implements Serializable{
    
    private static final long serialVersionUID = 8656423862204651688L;
    private String tabName;
    private Panel tabContentPanel;
    
    public Tab(String tabName, Panel tabContentPanel) {
        super();
        this.tabName = tabName;
        this.tabContentPanel = tabContentPanel;
    }
    public String getTabName() {
        return tabName;
    }
    public void setTabName(String tabName) {
        this.tabName = tabName;
    }
    public Panel getTabContentPanel() {
        return tabContentPanel;
    }
    public void setTabContentPanel(Panel tabContentPanel) {
        this.tabContentPanel = tabContentPanel;
    }
}
