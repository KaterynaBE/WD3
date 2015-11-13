package com.epam.auto.ui.services;

import com.epam.auto.ui.pages.SignInPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by ekaterinabut on 11/13/15.
 */
public class SigninManager extends BaseManager {

    private SignInPage signinPage;
    public SigninManager(WebDriver driver) {
        super(driver);
    }

    public void signInGmail(String email, String password)
    {
        signinPage = new SignInPage(driver);
        signinPage.signIn(email, password);
    }
}
