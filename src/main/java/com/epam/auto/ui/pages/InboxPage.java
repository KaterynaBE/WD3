package com.epam.auto.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * 'Home' page elements and methods.
 */

public class InboxPage extends BasePage {

    @FindBy(className="UI")
    private WebElement listOfEmails;

    // @FindBy(xpath="//div[@aria-label='Report spam']")
    @FindBy(xpath="//div[@gh='mtb']/div/div/div[2]/div[2]")
    private WebElement buttonReportSpam;

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public SpamPage reportSpam() {
        listOfEmails.click();
        buttonReportSpam.click();
        return new SpamPage(driver);
    }
}