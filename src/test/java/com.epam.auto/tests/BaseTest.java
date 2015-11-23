package com.epam.auto.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.auto.patterns.decorator.Decorator;


/**
 * Base test - initializing setUp (create WD instance), navigate to URL and tearDown - quits driver.
 */

public class BaseTest {

    protected Decorator customDriver;
    public static final String BASE_URL = "http://www.gmail.com";

    @Before
    public void setUp() {
        WebDriver driver = new FirefoxDriver();
        customDriver = new Decorator(driver);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @After
    public void tearDown() {
        customDriver.quit();
    }
}