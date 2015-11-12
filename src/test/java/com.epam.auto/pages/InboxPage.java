package com.epam.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * 'Home' page elements and methods.
 */

public class InboxPage {

    @FindBy(className = "z0")
    protected static WebElement buttonCompose;

    @FindBy(className="UI")
    private WebElement listOfEmails;

    @FindBy(xpath="//div[@aria-label='Report spam']")
    private WebElement buttonReportSpam;

    @FindBy(className="gb_Qa")
    private WebElement expanderAccount;

    @FindBy(xpath="//a[text()='Sign out']")
    private WebElement buttonSignOut;

    @FindBy(className="ait")
    private WebElement expanderMoreLess;

    @FindBy(linkText = "Spam")
    private WebElement linkSpam;

    private WebDriver driver;

    public InboxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewMessagePopup initiateNewEmail() {
        buttonCompose.click();
        return new NewMessagePopup(driver);
    }

    public SignInPage signOut() {
        expanderAccount.click();
        buttonSignOut.click();
        return new SignInPage(driver);
    }

    public SpamConfirmDialog reportSpam() {
        listOfEmails.click();
        buttonReportSpam.click();
        return new SpamConfirmDialog(driver);
    }

    public SpamPage openSpamFolder() {
        expanderMoreLess.click();
        linkSpam.click();
        return new SpamPage(driver);
    }
}
