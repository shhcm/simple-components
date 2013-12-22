package com.simplecomponents;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.simplecomponents.HomePage;
import com.simplecomponents.WicketApplication;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage
{
    private WicketTester tester;

    @Before
    public void setUp()
    {
        tester = new WicketTester(new WicketApplication());
    }
    
    @After
    public void tearDown() {
        tester.destroy();
    }

    @Test
    public void homepageRendersSuccessfully()
    {
        //start and render the test page
        tester.startPage(HomePage.class);

        //assert rendered page class
        tester.assertRenderedPage(HomePage.class);
    }
}
