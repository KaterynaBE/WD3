package com.epam.auto.tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void oneCanOpenGoogle() {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.google.com/");
    }
}
