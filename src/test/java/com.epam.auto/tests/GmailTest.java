package com.epam.auto.tests;

import com.epam.auto.patterns.staticfactorymethod.Email;

import com.epam.auto.patterns.staticfactorymethod.EmailStaticFactory;
import com.epam.auto.ui.services.EmailManager;
import com.epam.auto.ui.services.SignManager;
import com.epam.auto.ui.services.SpamManager;

import com.epam.auto.utils.StringUtils;

import org.junit.Test;
import org.junit.Before;

import java.util.concurrent.TimeUnit;
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
    private final String EMAIL_TITLE = "Email title ";
    private final String MESSAGE = "Some awesome text";

    public EmailManager emailMng;
    public SignManager signMng;
    public SpamManager spamMng;

    @Before
    public void initManagers() {
        emailMng = new EmailManager(customDriver);
        signMng = new SignManager(customDriver);
        spamMng = new SpamManager(customDriver);
    }

    @Test
    public void testSentGmail() {
        customDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // 1, 2
        signMng.signInGmail(USERNAME1, PASSWORD1);

        String emailTitle = EMAIL_TITLE + StringUtils.getRandomString(6);
        Email email = EmailStaticFactory.createDefaultEmail(USERNAME2, emailTitle, MESSAGE
                                                            + StringUtils.getRandomString(7));

        emailMng.sendEmail(email);
        signMng.signoutGmail();

        // Accepting sign-out confirmation alert if shown (it's not always there, but sometimes).
        customDriver.acceptAlert();

        // 3, 4
        signMng.signInGmail(USERNAME2, PASSWORD2);
        spamMng.reportSpam();

        // 5, 6
        signMng.signoutGmail();
        signMng.signInGmail(USERNAME1, PASSWORD1);
        customDriver.acceptAlert();


        String secondTitle = EMAIL_TITLE + StringUtils.getRandomString(4);
        Email secondEmail = EmailStaticFactory.createDefaultEmail(USERNAME2, secondTitle, MESSAGE
                                                                  + StringUtils.getRandomString(8));
        emailMng.sendEmail(secondEmail);

        // 7, 8
        signMng.signoutGmail();
        customDriver.acceptAlert();
        signMng.signInGmail(USERNAME2, PASSWORD2);
        spamMng.navigateToSpamFolder();

        // Easiest way is just check that text is present on page (email title). To be modified in smarter way.
        Assert.assertTrue(customDriver.getPageSource().contains(emailTitle));
    }
}