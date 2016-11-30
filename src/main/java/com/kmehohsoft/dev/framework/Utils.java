package com.kmehohsoft.dev.framework;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    private static AppiumDriver androiddriver = AndroidBasePage.androiddriver;

    public static void waitForElementPresent(String xpath) {
        WebDriverWait wait = new WebDriverWait(androiddriver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void waitForElementPresentByID(String id) {
        WebDriverWait wait = new WebDriverWait(androiddriver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public static boolean isElementPresent(String xpath) {
        return androiddriver.findElements(By.xpath(xpath)).size() > 0;
    }

    public static boolean isElementPresent(By by) {
        return androiddriver.findElements(by).size() > 0;
    }

    public static String getText(String xpath) {
        return androiddriver.findElement(By.xpath(xpath)).getText();
    }

    public static void closeApplication(){
        androiddriver.closeApp();
    }

    public static void openApplication(){
        androiddriver.launchApp();
    }

}
