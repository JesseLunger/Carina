package com.carina.methods.saucedemo.commons.pages;

import org.openqa.selenium.WebDriver;

public abstract class CheckoutOverviewScreenBase extends AbstractSauceDemoScreenBase {

    public CheckoutOverviewScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getCostByName(String productName);

    public abstract void swipeProductLeftByName(String productName);

    public abstract void clickExposedRemoveButtonByName(String productName);

    public abstract OrderConfirmationScreenBase clickFinishButton();

}
