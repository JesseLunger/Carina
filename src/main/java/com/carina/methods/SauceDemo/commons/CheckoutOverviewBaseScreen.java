package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.components.ProductInCartOverviewComponent;
import com.carina.methods.SauceDemo.screens.OrderConfirmationScreen;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutOverviewBaseScreen extends AbstractSauceDemoScreenBase {

    public CheckoutOverviewBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract OrderConfirmationScreen clickFinishButton();

    public abstract ProductInCartOverviewComponent getByProductInCartName(String name);

}
