package com.epam.auto.tests;

import com.epam.auto.pages.NewMessagePopup;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.epam.auto.pages.SignInPage;
import com.epam.auto.pages.StartPage;
import com.epam.auto.pages.InboxPage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;


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
        InboxPage inboxPage = signInPage.signIn(USERNAME1, PASSWORD1);
        NewMessagePopup newMessage = new NewMessagePopup(driver);
        newMessage.sendEmail(USERNAME2, "title");
        inboxPage.signOut();

        // Accepting alert shown
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // 3, 4
        inboxPage = signInPage.signIn(USERNAME2, PASSWORD2);
        inboxPage.reportSpam();

        // 5, 6
        inboxPage.signOut();
        signInPage.signIn(USERNAME1, PASSWORD1);
        newMessage.sendEmail(USERNAME2, "title");

        // 7, 8
        inboxPage.signOut();
        signInPage.signIn(USERNAME2, PASSWORD2);
        inboxPage.openSpamFolder();

        // TODO 9. Easiest way is just check that text is present on page (email title on our case)

        driver.quit();
    }
}