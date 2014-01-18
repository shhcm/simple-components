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
                BookmarkablePageLink<Void> link = new BookmarkablePageLink<Void>("multi-level-menu-repeated-link", item.getModelObject().getTarget());
                Label label = new Label("multi-level-menu-repeated-label", item.getModelObject().getName());
                boolean isHighlighted = false;
                
                if(this.getPage().getClass() == item.getModelObject().getTarget()) {
                    link.add(new AttributeAppender("class", " multi-level-menu-repeated-link-highlighted"));
                    isHighlighted = true;
                }
                
                if(item.getModelObject().getSubMenu() != null) {
                    MultiLevelMenu subMenu = new MultiLevelMenu("multi-level-menu-repeated-sub-menu", item.getModelObject().getSubMenu());
                    subMenu.setVisible(false);
                    // If this sub menu contains the highlighted item,
                    // then this menu as its parent must also be visible.
                    // If this item is the recently clicked (thus highlighted) item,
                    // then the sub menu must be visible.
                    if(isHighlighted || MultiLevelMenu.containsCurrentPageAsTarget(item.getModelObject().getSubMenu(), this.getPage().getClass())) {
                        subMenu.setVisible(true);
                    }
                    item.add(subMenu);
                }
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
    /**
     * Utility function to determine whether a sub menu contains the highlighted (clicked) item.
     * This cannot be done when the sub menu instance is constructed, because populateItem() of
     * the corresponding ListView is called before rendering, and not while the instance is constructed.
     * (A sub menu is not constructed by the constructor of its parent menu, but by populateItem(...) ).
     * Implements a depth first search.
     * @param itemList The items to search for the same link target as the current page.
     * @param target The class of the current page.
     * @return True if the itemList or any of its sub menus contains the target, otherwise false. 
     */
    private static boolean containsCurrentPageAsTarget(List<MultiLevelMenuItem> itemList, Class<? extends Page> target) {
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
