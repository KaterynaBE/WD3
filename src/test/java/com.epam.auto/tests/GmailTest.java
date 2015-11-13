package com.epam.auto.tests;

import com.epam.auto.ui.pages.BasePage;
import com.epam.auto.ui.pages.InboxPage;
import com.epam.auto.ui.pages.NewMessagePopup;
import com.epam.auto.ui.pages.SignInPage;
import com.epam.auto.ui.pages.SpamConfirmDialog;

import com.epam.auto.ui.services.EmailManager;
import com.epam.auto.ui.services.SigninManager;

import com.epam.auto.utils.StringUtils;
import org.junit.Test;
import org.junit.Before;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.junit.Assert;


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

public class GmailTest extends BaseTest {
    private final String USERNAME1 = "testtasktask";
    private final String PASSWORD1 = "testtasktaskpwd";
    private final String USERNAME2 = "testtasktask2@gmail.com";
    private final String PASSWORD2 = "testtasktaskpwd2";
    private final String EMAIL_TITLE = "Email title";
    private final String MESSAGE = "Some awesome text";

    public EmailManager emailMng;
    public SigninManager signinMng;

    @Before
    public void initManagers() {
        emailMng = new EmailManager(driver);
        signinMng = new SigninManager(driver);
    }

    @Test
    public void testSentGmail() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        SignInPage signInPage = new SignInPage(driver);
        // 1, 2
        signinMng.signInGmail(USERNAME1, PASSWORD1);

        String emailTitle = EMAIL_TITLE + StringUtils.getRandomString(6);
        emailMng.sendEmail(USERNAME2, emailTitle, MESSAGE);

        BasePage basePage = new BasePage(driver);
        basePage.signOut();

        // Accepting alert shown. Sometimes (seldom) it's not shown which causes. It's not connected to butter bar
        // display as I thought earlier - so wait for element to be displayed will not help. Condition if it's displayed
        // - click , otherwise - go further should help.
        // TODO (in case I'll still need it) -> move accept alert to base page as it's created.
//        Alert alert = driver.switchTo().alert();
//        alert.accept();

        // 3, 4
        signinMng.signInGmail(USERNAME2, PASSWORD2);
        // Commenting out us dialog is not shown now - as a result of test runs Google is convinced that it IS spam
        // and do not ask about it. May be uncommented as needed for another emails.
//        SpamConfirmDialog spamDialog = inboxPage.reportSpam();
//        inboxPage = spamDialog.confirmItsSpam();

        // 5, 6
        signInPage = basePage.signOut();
        basePage  = signInPage.signIn(USERNAME1, PASSWORD1);
        emailMng.sendEmail(USERNAME2, emailTitle, MESSAGE);

        // 7, 8
        basePage.signOut();
//        driver.switchTo().alert();
//        alert.accept();

        signinMng.signInGmail(USERNAME2, PASSWORD2);
        basePage.openSpamFolder();

        // Easiest way is just check that text is present on page (email title). To be modified in smarter way.
        Assert.assertTrue(driver.getPageSource().contains(emailTitle));
    }
}
