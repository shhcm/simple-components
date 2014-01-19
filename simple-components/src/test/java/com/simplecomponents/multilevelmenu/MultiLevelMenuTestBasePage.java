package com.simplecomponents.multilevelmenu;

import java.util.LinkedList;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.simplecomponents.multilevelmenu.MultiLevelMenu;
import com.simplecomponents.multilevelmenu.MultiLevelMenuItem;

public class MultiLevelMenuTestBasePage extends WebPage {

    private static final long serialVersionUID = -3497941396279229041L;

    public MultiLevelMenuTestBasePage(final PageParameters pageParameters) {
        super(pageParameters);
        LinkedList<MultiLevelMenuItem> pageList = new LinkedList<MultiLevelMenuItem>();
       
        MultiLevelMenuItem PageAMenuItem = new MultiLevelMenuItem("Page A", PageA.class);
        MultiLevelMenuItem PageBMenuItem = new MultiLevelMenuItem("Page B", PageB.class);
        MultiLevelMenuItem PageCMenuItem = new MultiLevelMenuItem("Page C", PageC.class);
        // Page C has subpages.
        MultiLevelMenuItem PageC1MenuItem = new MultiLevelMenuItem("Page C1", PageC1.class);
        LinkedList<MultiLevelMenuItem> pageCSubPagesList = new LinkedList<MultiLevelMenuItem>();
        pageCSubPagesList.add(PageC1MenuItem); // Other subpages may be added just like this.
        PageCMenuItem.setSubMenu(pageCSubPagesList);
        
        pageList.add(PageAMenuItem);
        pageList.add(PageBMenuItem);
        pageList.add(PageCMenuItem);
        
        MultiLevelMenu multiLevelMenu = new MultiLevelMenu("multi-level-menu", pageList);
        add(multiLevelMenu);
    }
}
