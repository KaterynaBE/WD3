package com.epam.auto.ui.services;

import com.epam.auto.ui.pages.InboxPage;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

import com.epam.auto.ui.pages.NewMessagePopup;
import com.epam.auto.ui.pages.InboxPage;

/**
 * Created by ekaterinabut on 11/12/15.
 */
public class EmailManager extends BaseManager {

    private final Logger logger = Logger.getLogger(EmailManager.class);

    // private NewMessagePopup newMessagePopup;
    private InboxPage inboxPage;
    public EmailManager(WebDriver driver) {
        super(driver);
    }

    public void sendEmail(String to, String subject) {
        logger.info("Creating and sending new email with name: '" + to + "'");
        NewMessagePopup newMessagePopup = new InboxPage(driver).initiateNewEmail();
        newMessagePopup.sendEmail(to, subject);
        inboxPage = new InboxPage(driver);
    }
}
