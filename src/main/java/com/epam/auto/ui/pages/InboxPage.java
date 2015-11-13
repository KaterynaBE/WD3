package com.epam.auto.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * 'Home' page elements and methods.
 */

public class InboxPage extends BasePage {

    @FindBy(className="UI")
    private WebElement listOfEmails;

    @FindBy(xpath="//div[@aria-label='Report spam']")

    private WebElement buttonReportSpam;

    // private WebDriver driver;

    public InboxPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
        super(driver);
    }

    public SpamConfirmDialog reportSpam() {
        listOfEmails.click();
        buttonReportSpam.click();
        return new SpamConfirmDialog(driver);
    }
}
