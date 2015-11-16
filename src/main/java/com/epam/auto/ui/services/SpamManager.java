package com.epam.auto.ui.services;

import com.epam.auto.ui.pages.InboxPage;
import com.epam.auto.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;


/**
 * Created by ekaterinabut on 11/13/15.
 */
public class SpamManager extends BaseManager {

    private InboxPage inboxPage;
    private BasePage basePage;
    public SpamManager(WebDriver driver) {
        super(driver);
    }

    public void reportSpam() {
        inboxPage = new InboxPage(driver);
        inboxPage.reportSpam();
    }

    public void navigateToSpamFolder() {
        basePage = new BasePage(driver);
        basePage.openSpamFolder();
    }
}
