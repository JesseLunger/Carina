package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.components.ProductInCart;
import com.carina.methods.SauceDemo.screens.CheckoutScreen;
import org.openqa.selenium.WebDriver;

public abstract class CartBaseScreen extends ScreenBaseClass {
    protected CartBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract CheckoutScreen clickCheckoutButton();

    public abstract ProductInCart findByProductInCartName(String name);

}
