package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.screens.ProductScreen;
import org.openqa.selenium.WebDriver;

public abstract class LoginBaseScreen extends AbstractSauceDemoScreenBase {

    public LoginBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract void typeUsername(String username);

    public abstract void typePassword(String password);

    public abstract ProductScreen clickLoginButton();

}
