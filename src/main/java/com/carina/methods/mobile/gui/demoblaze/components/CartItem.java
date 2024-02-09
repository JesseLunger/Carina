package com.carina.methods.mobile.gui.demoblaze.components;

import com.carina.methods.api.PutEmployeeMethod;
import com.carina.methods.mobile.gui.demoblaze.utils.Utils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItem extends AbstractUIObject {

    @FindBy(xpath = ".//a [contains(text(), 'Delete')]")
    private ExtendedWebElement deleteButton;

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickDeleteButton(){
        Utils.waitForElementVisible(getDriver(), deleteButton);
        deleteButton.click();
        Utils.waitForElementVisible(getDriver(), deleteButton);
    }

}
