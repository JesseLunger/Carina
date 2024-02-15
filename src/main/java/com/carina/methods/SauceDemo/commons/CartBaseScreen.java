package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.components.Product;
import com.carina.methods.SauceDemo.components.ProductInCart;
import com.carina.methods.SauceDemo.screens.CheckoutScreen;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CartBaseScreen extends ScreenBaseClass {
    protected CartBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract CheckoutScreen clickCheckoutButton();

    public abstract ProductInCart findByProductInCartName(String name);

}
