package com.epam.auto.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 'Home' page elements and methods.
 */

public class HomePage {

    @FindBy(className = "z0")
    private WebElement buttonCompose;

    @FindBy(id =":9o")
    private WebElement textareaEmail;

    @FindBy(xpath="//textarea[@name='to']")
    private WebElement textareaTo;

    @FindBy(xpath="//input[@name='subjectbox']")
    private WebElement textareaSubjectbox;

    @FindBy(xpath="//div[text()='Send']")
    private WebElement buttonSend;

    @FindBy(className="UI")
    private WebElement listOfEmails;

    @FindBy(xpath="//div[@aria-label='Report spam']")
    private WebElement buttonReportSpam;

    @FindBy(className="gb_Qa")
    private WebElement expanderAccound;

    @FindBy(xpath="//a[text()='Sign out']")
    private WebElement buttonSignOut;

    @FindBy(className="ait")
    private WebElement expanderMoreLess;

    @FindBy(className="J-Ke n0 aBU")
    private WebElement linkSpam;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendEmail(String to, String subject) {
        buttonCompose.click();
        textareaTo.sendKeys(to);
        textareaSubjectbox.sendKeys(subject);
        buttonSend.click();
    }

    public void signOut() {
        expanderAccound.click();
        buttonSignOut.click();
    }

    public void reportSpam() {
        listOfEmails.click();
        buttonReportSpam.click();
    }

    public void openSpamFolder() {
        expanderMoreLess.click();
        linkSpam.click();
    }
}
