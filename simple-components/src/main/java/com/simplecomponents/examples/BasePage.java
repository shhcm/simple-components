package com.simplecomponents.examples;

import java.util.LinkedList;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import com.simplecomponents.accordion.Accordion;
import com.simplecomponents.examples.accordion.AccordionDocumentationPage;
import com.simplecomponents.examples.accordion.AccordionPage;
import com.simplecomponents.examples.multilevelmenu.MultiLevelMenuDocumentationPage;
import com.simplecomponents.examples.tabbedajaxpanel.TabbedAjaxPanelDocumentationPage;
import com.simplecomponents.examples.tabbedajaxpanel.TabbedAjaxPanelPage;
import com.simplecomponents.multilevelmenu.MultiLevelMenu;
import com.simplecomponents.multilevelmenu.MultiLevelMenuItem;

public class BasePage extends WebPage {

    private static final long serialVersionUID = -1340886205560590416L;

    public BasePage(final PageParameters pageParameters) {
        super(pageParameters);
        // TODO: meaningful examples.
        LinkedList<MultiLevelMenuItem> pageList = new LinkedList<MultiLevelMenuItem>();
        MultiLevelMenuItem homePageItem = new MultiLevelMenuItem("Home Page", HomePage.class);
       
        MultiLevelMenuItem accordionPageItem = new MultiLevelMenuItem("Accordion Page", AccordionPage.class);
        MultiLevelMenuItem accordionDocumentationPageItem = new MultiLevelMenuItem("Accordion Documentation", AccordionDocumentationPage.class);
        LinkedList<MultiLevelMenuItem> accordionSubPages = new LinkedList<MultiLevelMenuItem>();
        accordionSubPages.add(accordionDocumentationPageItem);
        accordionPageItem.setSubMenu(accordionSubPages);
       
        MultiLevelMenuItem tabbedAjaxPanelPageItem = new MultiLevelMenuItem("TabbedAjaxPanel Page", TabbedAjaxPanelPage.class);
        MultiLevelMenuItem tabbedAjaxPanelDocumentationPageItem = new MultiLevelMenuItem("TabbedAjaxPanel Documentation", TabbedAjaxPanelDocumentationPage.class);
        LinkedList<MultiLevelMenuItem> tabbedAjaxPanelSubPages = new LinkedList<MultiLevelMenuItem>();
        tabbedAjaxPanelSubPages.add(tabbedAjaxPanelDocumentationPageItem);
        tabbedAjaxPanelPageItem.setSubMenu(tabbedAjaxPanelSubPages);
        
        MultiLevelMenuItem multiLevelMenuDocumentationPageItem = new MultiLevelMenuItem("MultiLevelMenu Documentation", MultiLevelMenuDocumentationPage.class);
        
        pageList.add(homePageItem);
        pageList.add(accordionPageItem);
        pageList.add(tabbedAjaxPanelPageItem);
        pageList.add(multiLevelMenuDocumentationPageItem);
        
        MultiLevelMenu multiLevelMenu = new MultiLevelMenu("multi-level-menu", pageList);
        add(multiLevelMenu);
    }
    public static CssResourceReference getCssForHeader() {
        return new CssResourceReference(BasePage.class, "Accordion.css");
    }
    @Override
    public void renderHead(IHeaderResponse response ) {
        response.render(JavaScriptReferenceHeaderItem.forReference(new JavaScriptResourceReference(BasePage.class,"run_prettify.js")));
        response.render(JavaScriptReferenceHeaderItem.forReference(new JavaScriptResourceReference(BasePage.class,"prettify.js")));
        response.render(CssReferenceHeaderItem.forReference(new CssResourceReference(BasePage.class, "prettify.css")));
    }
}
