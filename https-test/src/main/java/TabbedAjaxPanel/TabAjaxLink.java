package TabbedAjaxPanel;

import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class TabAjaxLink extends Panel {
    public static final String LINK_ID = "tab-ajax-link-link";
    public static final String LINK_LABEL_ID = "tab-ajax-link-label";
    private static final long serialVersionUID = -4473618388993418582L;

    public TabAjaxLink(String id, AjaxLink<Void> ajaxLink, Label label) {
        super(id);
        ajaxLink.add(label);
        add(ajaxLink);
    }

}
