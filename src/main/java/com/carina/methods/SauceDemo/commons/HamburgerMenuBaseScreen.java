package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.screens.LoginScreen;
import org.openqa.selenium.WebDriver;

public abstract class HamburgerMenuBaseScreen extends ScreenBaseClass {

    protected HamburgerMenuBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract LoginScreen clickLogoutButton();

}
