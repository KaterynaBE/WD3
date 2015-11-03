package com.epam.auto.pages;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ekaterinabut on 11/1/15.
 */
public class SignInPage {

    @FindBy(id = "Email")
    private WebElement inputEmail;

    @FindBy(id="next")
    private WebElement buttonNext;

    @FindBy(id="Passwd")
    private WebElement inputPassword;

    @FindBy(id="signIn")
    private WebElement buttonSignIn;

//    @FindBy(id="PersistentCookie");
//    private WebElement staySignedInCheckbox;

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage signIn(String email, String password) {
        inputEmail.sendKeys(email);
        buttonNext.click();
        inputPassword.sendKeys(password);
        buttonSignIn.click();
        return new HomePage(driver);
    }
}
