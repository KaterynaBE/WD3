package com.epam.auto.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ekaterinabut on 11/1/15.
 */
public class InboxPage {

    private WebDriver driver;

    public InboxPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
