package com.epam.auto.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Base test - initializing setUp (create WD instance), navigate to URL and tearDown - quits driver.
 */

public class BaseTest {

    protected WebDriver driver;
    public static final String BASE_URL = "http://www.gmail.com";

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}