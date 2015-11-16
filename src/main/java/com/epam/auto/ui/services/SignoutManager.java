package com.epam.auto.ui.services;

import com.epam.auto.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by ekaterinabut on 11/13/15.
 */
public class SignoutManager extends BaseManager{

    private BasePage basePage;
    public SignoutManager(WebDriver driver) {
        super(driver);
    }

    public void signoutGmail()
    {
        basePage = new BasePage(driver);
        basePage.signOut();
    }
}