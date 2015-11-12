package com.epam.auto.ui.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Describes Spam Confirmation dialog elements and methods.
 */

public class SpamConfirmDialog {

    @FindBy(xpath="//button[@name='rs']")
    private WebElement buttonItsSpam;

    private WebDriver driver;

    public SpamConfirmDialog(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public InboxPage confirmItsSpam() {
        buttonItsSpam.click();
        return new InboxPage(driver);
    }
}
