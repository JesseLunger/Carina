package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.screens.HamburgerMenuScreen;
import com.carina.methods.SauceDemo.screens.ProductScreen;
import org.openqa.selenium.WebDriver;

public abstract class OrderConfirmationBaseScreen extends AbstractSauceDemoScreenBase {

    public OrderConfirmationBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract ProductScreen clickBackToHomeButton();

    public abstract HamburgerMenuScreen clickHamburgerMenu();

}
