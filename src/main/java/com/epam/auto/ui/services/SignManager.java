package com.epam.auto.ui.services;

import com.epam.auto.ui.pages.BasePage;
import com.epam.auto.ui.pages.SignInPage;
import com.epam.auto.utils.ScreenshottingUtils;
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
    private ScreenshottingUtils screenshottingUtils;
    public SignManager(WebDriver driver) {
        super(driver);
    }

    public void signInGmail(String email, String password)
    {
        logger.info("Sign-in to '" + email + "' account");
        signinPage = new SignInPage(driver);
        signinPage.signIn(email, password);
        // This scr will show what's inside Spam folder on that step.
//        screenshottingUtils.highlightElement(driver, linkSpam);
//        screenshottingUtils.takeScreenshot();
    }
    public void signoutGmail()
    {
        basePage = new BasePage(driver);
        basePage.signOut();
    }
}