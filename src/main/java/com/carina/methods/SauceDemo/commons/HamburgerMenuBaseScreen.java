package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.screens.LoginScreen;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HamburgerMenuBaseScreen extends ScreenBaseClass {
    protected HamburgerMenuBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract LoginScreen clickLogoutButton();
}
