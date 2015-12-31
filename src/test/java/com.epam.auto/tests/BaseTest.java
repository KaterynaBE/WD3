package com.epam.auto.tests;

import com.epam.auto.core.webdriver.CustomWebDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Base test - initializing setUp (create WD instance), navigate to URL and tearDown - quits driver.
 */

public class BaseTest {

    protected CustomWebDriver customDriver;
    public static final String BASE_URL = "http://www.gmail.com";

    @Before
    public void setUp() {
        WebDriver driver = new FirefoxDriver();
        customDriver = new CustomWebDriver(driver);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @After
    public void tearDown() {
        customDriver.quit();
    }
}