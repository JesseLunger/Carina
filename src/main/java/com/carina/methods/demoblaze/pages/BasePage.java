package com.carina.methods.demoblaze.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage extends AbstractPage {

    @FindBy(xpath = "//a[@id='nava']")
    protected ExtendedWebElement storeTitle;

    @FindBy(xpath = "//a[@id='login2']")
    protected ExtendedWebElement loginHeaderOption;

    @FindBy(xpath = "//a [contains(text(), 'About us')]")
    protected ExtendedWebElement aboutUsHeaderOption;

    @FindBy(xpath = "//a [@id= 'cartur']")
    protected ExtendedWebElement cartHeaderOption;

    @FindBy (xpath = "//a[@id='nameofuser']")
    protected ExtendedWebElement headerUserGreeting;

    public BasePage(WebDriver driver) {
        super(driver);
    }
}