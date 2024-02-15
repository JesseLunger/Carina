package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.screens.ProductScreen;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginBaseScreen extends ScreenBaseClass {
    protected LoginBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract void typeUsername(String username);

    public abstract void typePassword(String password);

    public abstract ProductScreen clickLoginButton();
}
