package com.epam.auto.tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import com.epam.auto.pages.SignInPage;
import com.epam.auto.pages.StartPage;
import com.epam.auto.pages.HomePage;
import java.util.concurrent.TimeUnit;


/**
 * Created by ekaterinabut on 11/1/15.
 */
public class GmailTest {
    private final String USERNAME1 = "testtasktask";
    private final String PASSWORD1 = "testtasktaskpwd";
    private final String USERNAME2 = "testtasktask2";
    private final String PASSWORD2 = "testtasktaskpwd2";

    @Test
    public void testSentGmail() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        StartPage startPage = new StartPage(driver);
        startPage.open();
        SignInPage signInPage = new SignInPage(driver);
        HomePage homePage = signInPage.signIn(USERNAME1, PASSWORD1);
        homePage.sendEmail(USERNAME2 + "@gmail.com", "title");

        // TBD: add log out for current user

        // TBD: Log in as user 2 and the rest of the test.
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        startPage.open();
//        SignInPage signInPage2 = new SignInPage(driver);
//        HomePage homePage2 = signInPage.signIn(USERNAME2, PASSWORD2);
//        homePage.reportSpam();
        // driver.quit();


    }
}

