package com.epam.auto.ui.services;

import com.epam.auto.ui.pages.InboxPage;
import com.epam.auto.ui.pages.BasePage;
import com.epam.auto.ui.pages.SpamPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


/**
 * Created by ekaterinabut on 11/13/15.
 */
public class SpamManager extends BaseManager {

    private final Logger logger = LogManager.getLogger(SpamManager.class.getName());

    private InboxPage inboxPage;
    private BasePage basePage;
    private SpamPage spamPage;
    public SpamManager(WebDriver driver) {
        super(driver);
    }

    public void reportSpam() {
        logger.debug("Reporting inbox message as a spam");
        inboxPage = new InboxPage(driver);
        inboxPage.reportSpam();
    }

    public void navigateToSpamFolder() {
        logger.debug("Navigate to Spam folder");
        basePage = new BasePage(driver);
        basePage.openSpamFolder();
        spamPage = new SpamPage(driver);
    }

    public String getSpamListText() {
        logger.debug("Getting list of items in Spam folder");
        return spamPage.spamList.getText();
    }
}