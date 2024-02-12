package com.carina.methods.mobile.gui.demoblaze.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OrderConfrimation extends AbstractUIObject {

    @FindBy(xpath = "//div [@class='sa-placeholder']")
    private ExtendedWebElement checkMark;

    protected OrderConfrimation(WebDriver driver) {
        super(driver);
    }

    public boolean checkMarkPresent(){
        assertElementPresent(checkMark); //Will throw Error if false
        return true;
    }
}
