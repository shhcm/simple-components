package com.simplecomponents.multilevelmenu;

import java.io.Serializable;
import java.util.LinkedList;

import org.apache.wicket.markup.html.WebPage;

public class MultiLevelMenuItem implements Serializable{
    private static final long serialVersionUID = -8853925022606271695L;
    private String name;
    private Class<? extends WebPage> target;
    private LinkedList<MultiLevelMenuItem> subMenu;
    
    public MultiLevelMenuItem(String name, Class<? extends WebPage> target) {
        this.name = name;
        this.target = target;
    }
    
    public MultiLevelMenuItem(String name, LinkedList<MultiLevelMenuItem> subMenu) {
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
