package com.simplecomponents;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.simplecomponents.WicketApplication;

/**
 * Simple test using the WicketTester
 */
public class AccordionTest {
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
    public void accordionRendersSuccessfully() {
        // Given
        
        // When
        tester.startPage(AccordionTestHomePage.class);
        // Then
        tester.assertRenderedPage(AccordionTestHomePage.class);
        tester.assertEnabled("accordion");//accortion-item-title");
        // Initially, the three accordion items should be closed.
        tester.assertContains("(.*<div\\sclass=\"accordion\\-item\\-content\\-div\"\\s" +
                            "style=\"display:none;\"\\s" +
                            "wicket:id=\"accordion\\-item\\-content\"){3}");
    }
}
