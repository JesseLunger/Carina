package com.carina.methods.demoblaze.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OrderConfrimationPage extends AbstractPage {

    @FindBy(xpath = "//div [@class='sa-placeholder']")
    private ExtendedWebElement checkMark;

    public OrderConfrimationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckMarkPresent(){
        assertElementPresent(checkMark); //Will throw Error if false
        return true;
    }
}
