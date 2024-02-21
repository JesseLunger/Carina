package com.carina.methods.saucedemo.commons.pages;

import org.openqa.selenium.WebDriver;

public abstract class CartScreenBase extends AbstractSauceDemoScreenBase {

    public CartScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getCostByName(String productName);

    public abstract void clickRemoveButtonByName(String productName);

    public abstract CheckoutScreenBase clickCheckoutButton();

    public abstract void swipeProductLeftByName(String productName);

    public abstract void clickExposedRemoveButtonByName(String productName);

}
