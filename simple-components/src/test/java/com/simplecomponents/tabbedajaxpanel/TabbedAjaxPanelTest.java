package com.simplecomponents.tabbedajaxpanel;

import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.simplecomponents.examples.WicketApplication;
import com.simplecomponents.tabbedajaxpanel.TabbedAjaxPanel;

public class TabbedAjaxPanelTest {
    private WicketTester tester;
    
    @Before
    public void setUp() {
        tester = new WicketTester(new WicketApplication());
    }
    
    @After
    public void tearDown() {
        tester.destroy();
    }

    @Test
    public void tabbedAjaxPanelRendersSuccessfully() {
        // Given
        tester.startPage(TabbedAjaxPanelTestHomePage.class);
        // When
        
        // Then
        tester.assertRenderedPage(TabbedAjaxPanelTestHomePage.class);
        tester.assertComponent("tabbed-ajax-panel", TabbedAjaxPanel.class);
        tester.assertComponent("tabbed-ajax-panel:tabbed-ajax-panel-tab-span", ListView.class);
        tester.assertComponent("tabbed-ajax-panel:tabbed-ajax-panel-tab-span:0:tab-ajax-link-link", AjaxLink.class);
        tester.assertComponent("tabbed-ajax-panel:tabbed-ajax-panel-tab-span:1:tab-ajax-link-link", AjaxLink.class);
        tester.assertComponent("tabbed-ajax-panel:tabbed-ajax-panel-tab-span:2:tab-ajax-link-link", AjaxLink.class);
        tester.assertEnabled("tabbed-ajax-panel");//accortion-item-title");
    }
    
    @Test
    public void clickOnTab1LoadsCorrectPanel() {
        // Given
        tester.startPage(TabbedAjaxPanelTestHomePage.class);
        // When
        tester.clickLink("tabbed-ajax-panel:tabbed-ajax-panel-tab-span:0:tab-ajax-link-link");
        // Then
        tester.assertContains("Content of tab 1");
    }
    @Test
    public void clickOnTab2LoadsCorrectPanel() {
        // Given
        tester.startPage(TabbedAjaxPanelTestHomePage.class);
        // When
        tester.clickLink("tabbed-ajax-panel:tabbed-ajax-panel-tab-span:1:tab-ajax-link-link");
        // Then
        tester.assertContains("Content of tab 2");
    }
    @Test
    public void clickOnTab3LoadsCorrectPanel() {
        // Given
        tester.startPage(TabbedAjaxPanelTestHomePage.class);
        // When
        tester.clickLink("tabbed-ajax-panel:tabbed-ajax-panel-tab-span:2:tab-ajax-link-link");
        // Then
        tester.assertContains("Content of tab 3");
    }
}