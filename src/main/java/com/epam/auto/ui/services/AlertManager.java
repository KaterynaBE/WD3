package com.epam.auto.ui.services;

import com.epam.auto.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by ekaterinabut on 11/16/15.
 */
public class AlertManager extends BaseManager {

    private BasePage basePage;
    public AlertManager(WebDriver driver) {
        super(driver);
    }

    public void acceptAlertIfPresent()
    {
        basePage = new BasePage(driver);
        basePage.acceptAlert();
    }
}