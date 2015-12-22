package com.epam.auto.ui.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.epam.auto.ui.pages.NewMessagePopup;
import com.epam.auto.ui.pages.BasePage;

import com.epam.auto.objects.Email;

/**
 * Created by ekaterinabut on 11/12/15.
 */
public class EmailManager extends BaseManager {

    private final Logger logger = LogManager.getLogger(EmailManager.class.getName());

    private BasePage basePage;
    public EmailManager(WebDriver driver) {
        super(driver);
    }

    public void sendEmail(Email email) {
        logger.info("Sent email to '" + email + "'");
        NewMessagePopup newMessagePopup = new BasePage(driver).initiateNewEmail();
        newMessagePopup.sendEmail(email);
        basePage = new BasePage(driver);
    }
}
