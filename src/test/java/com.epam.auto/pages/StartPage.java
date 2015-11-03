package com.epam.auto.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ekaterinabut on 10/31/15.
 */
public class StartPage {

    @FindBy(id = "gmail-sign-in")
    private WebElement buttonSignIn;

    public static final String BASE_URL = "http://www.gmail.com";
    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public SignInPage invokeSignIn() {
        buttonSignIn.click();
        return new SignInPage(driver);
    }

//    private WebDriver driver;
//
//    public void clickSignInButton() {
//        signInButton.click();
//    }
//
//    public StartPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
}
