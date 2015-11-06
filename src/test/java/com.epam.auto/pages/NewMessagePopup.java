package com.epam.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * New message pop-up elements and methods.
 */

public class NewMessagePopup {

    @FindBy(id =":9o")
    private WebElement textareaEmail;

    @FindBy(xpath="//textarea[@name='to']")
    private WebElement textareaTo;

    @FindBy(xpath="//input[@name='subjectbox']")
    private WebElement textareaSubjectbox;

    @FindBy(xpath="//div[text()='Send']")
    private WebElement buttonSend;

    private WebDriver driver;

    public NewMessagePopup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public InboxPage sendEmail(String to, String subject) {
        InboxPage.buttonCompose.click();
        textareaTo.sendKeys(to);
        textareaSubjectbox.sendKeys(subject);
        buttonSend.click();
        return new InboxPage(driver);
    }
}
