package com.carina.methods.SauceDemo.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductInCart extends AbstractUIObject {

    @FindBy(xpath = ".//android.widget.TextView[@text=\"REMOVE\"]")
    private ExtendedWebElement removeButton;

    public ProductInCart(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickRemoveButton(){
        removeButton.click();
    }
}
