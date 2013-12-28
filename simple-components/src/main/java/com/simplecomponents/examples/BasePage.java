package com.simplecomponents.examples;

import java.util.LinkedList;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.simplecomponents.multilevelmenu.MultiLevelMenu;
import com.simplecomponents.multilevelmenu.MultiLevelMenuItem;

public class BasePage extends WebPage {

    private static final long serialVersionUID = -1340886205560590416L;

    public BasePage(final PageParameters pageParameters) {
        super(pageParameters);
        // TODO: meaningful examples.
        LinkedList<MultiLevelMenuItem> pageList = new LinkedList<MultiLevelMenuItem>();
        for(int i = 0; i < 10; i++) {
            MultiLevelMenuItem item = new MultiLevelMenuItem("page link " + i, HomePage.class);
            if(i < 5) {
                LinkedList<MultiLevelMenuItem> subPageList = new LinkedList<MultiLevelMenuItem>();
                for(int j = 0; j < 3; j++) {
                    MultiLevelMenuItem subItem = new MultiLevelMenuItem("sub page link " + i, HomePage.class);
                    subPageList.add(subItem);
                }
                item.setSubMenu(subPageList);
            }
            pageList.add(item);
        }
        
        MultiLevelMenu multiLevelMenu = new MultiLevelMenu("multi-level-menu", pageList);
        add(multiLevelMenu);
    }

}
