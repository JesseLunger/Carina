package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.components.ProductInCartOverview;
import com.carina.methods.SauceDemo.screens.OrderConfirmationScreen;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutOverviewBaseScreen extends ScreenBaseClass {

    protected CheckoutOverviewBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract OrderConfirmationScreen clickFinishButton();

    public abstract ProductInCartOverview getByProductInCartName(String name);

}
