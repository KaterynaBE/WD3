package com.epam.auto.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * 'Spam' page elements and methods..
 */

public class SpamPage {

    private WebDriver driver;

    public SpamPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
