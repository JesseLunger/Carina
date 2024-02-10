package com.carina.methods.mobile.gui.demoblaze.utils;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Utils {

    public static void waitForElementVisible(WebDriver webDriver, ExtendedWebElement extendedWebElement, Boolean catchError){
        try {
            new FluentWait<>(webDriver)
                    .withTimeout(Duration.ofSeconds(2))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(Exception.class)
                    .until(ExpectedConditions.visibilityOf(extendedWebElement.getElement()));
        } catch (TimeoutException e) {
            if (!catchError){
                throw new TimeoutException(e);
            }
        }

    }

    public static void waitForElementInvisible(WebDriver webDriver, ExtendedWebElement extendedWebElement){
        new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class)
                .until(ExpectedConditions.invisibilityOf(extendedWebElement.getElement()));
    }

}
