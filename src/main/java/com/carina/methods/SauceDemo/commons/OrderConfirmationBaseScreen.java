package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.screens.ProductScreen;
import org.openqa.selenium.WebDriver;

public abstract class OrderConfirmationBaseScreen extends ScreenBaseClass {

    protected OrderConfirmationBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract ProductScreen clickBackToHomeButton();

}
