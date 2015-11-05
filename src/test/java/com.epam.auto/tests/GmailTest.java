package com.epam.auto.tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.epam.auto.pages.SignInPage;
import com.epam.auto.pages.StartPage;
import com.epam.auto.pages.HomePage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;


/**
 * Gmail test - home work 3.
 * 1. Login as registered user1
 * 2. Send message to user2
 * 3. Login as registered user2
 * 4. Mark letter from user1 as "spam"
 * 5. Login user1
 * 6. Send letter to user2
 * 7. Login user2
 * 8. Go to folder: Spam"
 * 9. Check that the letter from user1 in Spam
 */
public class GmailTest {
    private final String USERNAME1 = "testtasktask";
    private final String PASSWORD1 = "testtasktaskpwd";
    private final String USERNAME2 = "testtasktask2@gmail.com";
    private final String PASSWORD2 = "testtasktaskpwd2";

    @Test
    public void testSentGmail() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        StartPage startPage = new StartPage(driver);
        startPage.open();
        SignInPage signInPage = new SignInPage(driver);
        // 1, 2
        HomePage homePage = signInPage.signIn(USERNAME1, PASSWORD1);
        homePage.sendEmail(USERNAME2, "title");
        homePage.signOut();

        // Accepting alert shown
        // TODO: Add condition: if alert is shown - accept it (as it's not always appears, but on most cases)
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // 3, 4
        signInPage.signIn(USERNAME2, PASSWORD2);
        homePage.reportSpam();

        // 5, 6
        homePage.signOut();
        signInPage.signIn(USERNAME1, PASSWORD1);
        homePage.sendEmail(USERNAME2, "title");

        // 7, 8
        homePage.signOut();
        signInPage.signIn(USERNAME2, PASSWORD2);
        homePage.openSpamFolder();

        // TODO 9. Easiest way is just check that text is present on page (email title on our case)

        driver.quit();
    }
}