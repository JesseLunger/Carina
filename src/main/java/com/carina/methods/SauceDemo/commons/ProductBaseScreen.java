package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.components.Product;
import com.carina.methods.SauceDemo.screens.CartScreen;
import org.openqa.selenium.WebDriver;

public abstract class ProductBaseScreen extends ScreenBaseClass {

    protected ProductBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract CartScreen clickCheckoutCartButton();

    public abstract Product getProductByName(String name);
}
