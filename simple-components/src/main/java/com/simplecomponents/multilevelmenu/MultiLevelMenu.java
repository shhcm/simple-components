package com.simplecomponents.multilevelmenu;

import java.util.List;

import org.apache.wicket.Page;
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
                boolean isHighlighted = false;
                if(this.getPage().getClass() == item.getModelObject().getTarget()) {
                    link.add(new AttributeAppender("class", " multi-level-menu-repeated-link-highlighted"));
                    isHighlighted = true;
                }
                
                if(item.getModelObject().getSubMenu() != null) {
                    MultiLevelMenu subMenu = new MultiLevelMenu("multi-level-menu-repeated-sub-menu", item.getModelObject().getSubMenu());
                    subMenu.setVisible(false);
                    // Note the recursion: if this sub menu contains the highlighted item,
                    // then this menu as its parent must also be visible.
                    // If this item is the recently clicked (thus highlighted) item,
                    // then the sub menu must be visible.
                    if(isHighlighted || MultiLevelMenu.containsCurrentPageAsTarget(item.getModelObject().getSubMenu(), this.getPage().getClass())) {
                        subMenu.setVisible(true);
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
    
    private static boolean containsCurrentPageAsTarget(List<MultiLevelMenuItem> itemList, Class<? extends Page> target) {
        // Determine if this menu contains the item that should be highlighted.
        for(MultiLevelMenuItem item: itemList) {
            if(item.getTarget() == target) {
                return true;
            }
            if(item.getSubMenu() != null) {
                return MultiLevelMenu.containsCurrentPageAsTarget(item.getSubMenu(), target);
            }
        }
        
        return false;
    }
}
