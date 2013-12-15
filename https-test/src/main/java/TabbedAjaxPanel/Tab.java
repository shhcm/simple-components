package TabbedAjaxPanel;

import java.io.Serializable;

import org.apache.wicket.markup.html.panel.Panel;

public class Tab implements Serializable{
    
    private static final long serialVersionUID = 8656423862204651688L;
    private String tabName;
    private Panel tabContentPanel;
    private boolean highlighted;
    
    public Tab(String tabName, Panel tabContentPanel) {
        super();
        this.tabName = tabName;
        this.tabContentPanel = tabContentPanel;
        this.highlighted = false;
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
    public boolean isHighlighted() {
        return highlighted;
    }
    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }
}
