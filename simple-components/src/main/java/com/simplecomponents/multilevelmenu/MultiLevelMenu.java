package com.simplecomponents.multilevelmenu;

import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;

public class MultiLevelMenu extends Panel {
    
    private static final long serialVersionUID = 6149666288654144564L;
    
    public MultiLevelMenu(String id,final List<MultiLevelMenuItem> itemList) {
        super(id);
        ListView<MultiLevelMenuItem> listView = new ListView<MultiLevelMenuItem>("multi-level-menu-repeated-div", itemList) {
            private static final long serialVersionUID = -3527363179584213016L;
            @Override
            protected void populateItem(ListItem<MultiLevelMenuItem> item) {
                PageParameters pageParameters = new PageParameters();
                BookmarkablePageLink<Void> link = new BookmarkablePageLink<Void>("multi-level-menu-repeated-link", item.getModelObject().getTarget(), pageParameters);
                
                if(this.getPage().getClass() == item.getModelObject().getTarget()) {
                    link.add(new AttributeAppender("class", " multi-level-menu-repeated-link-highlighted"));
                    MultiLevelMenu.this.setVisible(true);
                } else {
                    MultiLevelMenu.this.setVisible(false);
                }
                if(item.getModelObject().getSubMenu() != null) {
                    MultiLevelMenu subMenu = new MultiLevelMenu("multi-level-menu-repeated-sub-menu", item.getModelObject().getSubMenu());
                    if(subMenu.isVisible()) {
                        MultiLevelMenu.this.setVisible(true);
                    } else {
                        MultiLevelMenu.this.setVisible(false);
                    }
                    item.add(subMenu);
                }
                Label label = new Label("multi-level-menu-repeated-label", item.getModelObject().getName());
                link.add(label);
                item.add(link);
            }
        };
        add(listView);
    }
    
    @Override
    public void renderHead(IHeaderResponse response) {
        response.render(CssReferenceHeaderItem.forReference(
                new CssResourceReference(MultiLevelMenu.class, "MultiLevelMenu.css")));
    }
}
