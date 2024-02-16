package com.carina.methods.saucedemo.commons.pages;

import com.carina.methods.saucedemo.android.pages.ProductScreen;
import org.openqa.selenium.WebDriver;

public abstract class LoginScreenBase extends AbstractSauceDemoScreenBase {


    public LoginScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeUsername(String username);

    public abstract void typePassword(String password);

    public abstract ProductScreenBase clickLoginButton();

}
