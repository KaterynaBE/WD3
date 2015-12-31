package com.epam.auto.utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

/**
 * Created by ekaterinabut on 12/21/15.
 */
public class ScreenshottingUtils {

    private static final Logger logger = LogManager.getLogger(ScreenshottingUtils.class.getName());

    public static void takeScreenshot(WebDriver driver) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File ("screenshot.png"));
            logger.info("Screenshot saved");
        } catch (IOException e) {
            logger.error("Can't save screenshot due to " + e.getMessage());
        }
    }

    public static void highlightElement(WebDriver driver, WebElement elementToHighlight) {
        JavascriptExecutor jsExecutor = ((JavascriptExecutor) driver);
        String background = elementToHighlight.getCssValue("backgroundColor");
        jsExecutor.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", elementToHighlight);
        takeScreenshot(driver);
        jsExecutor.executeScript("arguments[0].style.backgroundColor = '" + background + "'", elementToHighlight);
    }
}