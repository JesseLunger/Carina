package com.carina.methods.saucedemo.commons.pages;

import org.openqa.selenium.WebDriver;

public abstract class CheckoutOverviewScreenBase extends AbstractSauceDemoScreenBase {

    public CheckoutOverviewScreenBase(WebDriver driver) {
        super(driver);
    }


    public abstract String getCost(String productName);

    public abstract void swipeProductLeft(String productName);

    public abstract void clickExposedRemoveButton(String productName);

    public abstract OrderConfirmationScreenBase clickFinishButton();


}
