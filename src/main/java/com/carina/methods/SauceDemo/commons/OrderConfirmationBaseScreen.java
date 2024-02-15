package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.screens.ProductScreen;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class OrderConfirmationBaseScreen extends ScreenBaseClass {
    protected OrderConfirmationBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract ProductScreen clickBackToHomeButton();
}
