package com.carina.methods.demoblaze.pages;

import com.carina.methods.demoblaze.components.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage extends AbstractPage {

    protected BasePage(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();
}
