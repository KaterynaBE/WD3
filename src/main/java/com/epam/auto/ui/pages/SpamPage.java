package com.epam.auto.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 'Spam' page elements and methods..
 */

public class SpamPage extends BasePage {

    @FindBy(xpath="//div[@gh='tl']")
    public WebElement spamList;

    public SpamPage(WebDriver driver) {
        super(driver);
    }
}
