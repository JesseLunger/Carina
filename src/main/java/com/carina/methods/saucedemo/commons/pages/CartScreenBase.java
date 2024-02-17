package com.carina.methods.saucedemo.commons.pages;

import com.carina.methods.saucedemo.android.pages.CartScreen;
import com.carina.methods.saucedemo.android.pages.CheckoutScreen;
import org.openqa.selenium.WebDriver;

public abstract class CartScreenBase extends AbstractSauceDemoScreenBase {

    public CartScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();


    public abstract String getCostByName(String productName);

    public abstract void clickRemoveButton(String productName);

    public abstract CheckoutScreenBase clickCheckoutButton();

    public abstract void swipeProductLeft(String productName);

    public abstract void clickExposedRemoveButton(String productName);

}
