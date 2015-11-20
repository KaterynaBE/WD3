package com.epam.auto.ui.services;

import org.openqa.selenium.WebDriver;

import com.epam.auto.ui.pages.NewMessagePopup;
import com.epam.auto.ui.pages.BasePage;

/**
 * Created by ekaterinabut on 11/12/15.
 */
public class EmailManager extends BaseManager {

    private BasePage basePage;
    public EmailManager(WebDriver driver) {
        super(driver);
    }

    public void sendEmail(String to, String subject, String message) {
        NewMessagePopup newMessagePopup = new BasePage(driver).initiateNewEmail();
        newMessagePopup.sendEmail(to, subject, message);
        basePage = new BasePage(driver);
    }
}
