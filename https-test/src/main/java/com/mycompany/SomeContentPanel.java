package com.mycompany;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class SomeContentPanel extends Panel{

    public SomeContentPanel(String id, String content) {
        super(id);
        Label label = new Label("content-of-panel", content);
        this.add(label);
    }

    private static final long serialVersionUID = -8445737900438513659L;

}
