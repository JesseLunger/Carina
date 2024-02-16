package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.components.ProductInCartComponent;
import com.carina.methods.SauceDemo.screens.CartScreen;
import com.carina.methods.SauceDemo.screens.CheckoutScreen;
import org.openqa.selenium.WebDriver;

public abstract class CartBaseScreen extends AbstractSauceDemoScreenBase {

    public CartBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract CheckoutScreen clickCheckoutButton();

    public abstract ProductInCartComponent findByProductInCartName(String name);

    public abstract CartScreen clickCheckoutHeaderButton();

}
