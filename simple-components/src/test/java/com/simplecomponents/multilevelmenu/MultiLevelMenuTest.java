package com.simplecomponents.multilevelmenu;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.simplecomponents.examples.WicketApplication;

public class MultiLevelMenuTest {
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
    public void multiLevelMenuRendersCorrectly() {
        // Given
        tester.startPage(PageA.class);
        // Then
        tester.assertRenderedPage(PageA.class);
        tester.assertContains("<h1>Page A</h1>");
    }
    
    @Test
    public void clickOnLinkToPageARendersPageA() {
        // Given
        tester.startPage(PageA.class);
        // When
        tester.clickLink("multi-level-menu:multi-level-menu-repeated-div:0:multi-level-menu-repeated-link");
        // Then
        tester.assertRenderedPage(PageA.class);
        tester.assertContains("<h1>Page A</h1>");
        tester.assertContainsNot("Page C1"); // This submenu should not be visible.
    }
    
    @Test
    public void clickOnLinkToPageBRendersPageB() {
        // Given
        tester.startPage(PageA.class);
        // When
        tester.clickLink("multi-level-menu:multi-level-menu-repeated-div:1:multi-level-menu-repeated-link");
        // Then
        tester.assertRenderedPage(PageB.class);
        tester.assertContains("<h1>Page B</h1>");
        tester.assertContainsNot("Page C1"); // This submenu should not be visible.
    }
    
    @Test
    public void clickOnLinkToPageCRendersPageC() {
        // Given
        tester.startPage(PageA.class);
        // When
        tester.clickLink("multi-level-menu:multi-level-menu-repeated-div:2:multi-level-menu-repeated-link");
        // Then
        tester.assertRenderedPage(PageC.class);
        tester.assertContains("<h1>Page C</h1>");
        tester.assertContains("Page C1"); // This submenu should be visible.
        tester.assertComponent("multi-level-menu:"
                + "multi-level-menu-repeated-div:"
                + "2:"
                + "multi-level-menu-repeated-sub-menu:", MultiLevelMenu.class);
    }
    
    @Test
    public void clickOnLinkToPageC1RendersPageC1() {
        // Given
        tester.startPage(PageC.class);
        
        // When
        tester.clickLink("multi-level-menu:"
                + "multi-level-menu-repeated-div:"
                + "2:"
                + "multi-level-menu-repeated-sub-menu:"
                + "multi-level-menu-repeated-div:0:"
                + "multi-level-menu-repeated-link");
        // Then
        tester.assertRenderedPage(PageC1.class);
        tester.assertContains("<h1>Page C1</h1>");
    }
}
