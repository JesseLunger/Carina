package com.carina.methods.saucedemo.commons.pages;

import com.carina.methods.saucedemo.android.pages.HamburgerMenuScreen;
import com.carina.methods.saucedemo.android.pages.ProductScreen;
import org.openqa.selenium.WebDriver;

public abstract class OrderConfirmationScreenBase extends AbstractSauceDemoScreenBase {

    public OrderConfirmationScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductScreenBase clickBackToHomeButton();

    public abstract boolean isThankyouMessagePresent();

}
