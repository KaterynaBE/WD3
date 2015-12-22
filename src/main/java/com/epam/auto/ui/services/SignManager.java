package com.epam.auto.ui.services;

import com.epam.auto.ui.pages.BasePage;
import com.epam.auto.ui.pages.SignInPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by ekaterinabut on 11/13/15.
 */
public class SignManager extends BaseManager {

    private final Logger logger = LogManager.getLogger(SignManager.class.getName());

    private SignInPage signinPage;
    private BasePage basePage;
    public SignManager(WebDriver driver) {
        super(driver);
    }

    public void signInGmail(String email, String password)
    {
        logger.info("Sign-in to '" + email + "' account");
        signinPage = new SignInPage(driver);
        signinPage.signIn(email, password);
    }
    public void signoutGmail()
    {
        basePage = new BasePage(driver);
        basePage.signOut();
    }
}