package com.simplecomponents.multilevelmenu;

import java.util.LinkedList;

import org.apache.wicket.markup.html.WebPage;

public class MultiLevelMenuItem {
    private String name;
    private Class<? extends WebPage> target;
    private LinkedList<MultiLevelMenuItem> subMenu;
    
    private MultiLevelMenuItem(String name, Class<? extends WebPage> target) {
        this.name = name;
        this.target = target;
    }
    
    private MultiLevelMenuItem(String name, LinkedList<MultiLevelMenuItem> subMenu) {
        this.name = name;
        this.subMenu = subMenu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<? extends WebPage> getTarget() {
        return target;
    }

    public void setTarget(Class<? extends WebPage> target) {
        this.target = target;
    }

    public LinkedList<MultiLevelMenuItem> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(LinkedList<MultiLevelMenuItem> subMenu) {
        this.subMenu = subMenu;
    }
}
