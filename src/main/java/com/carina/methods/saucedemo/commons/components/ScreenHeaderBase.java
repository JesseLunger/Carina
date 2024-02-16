package com.carina.methods.saucedemo.commons.components;

import com.carina.methods.saucedemo.commons.pages.CartScreenBase;
import com.carina.methods.saucedemo.commons.pages.HamburgerMenuScreenBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ScreenHeaderBase extends AbstractPage {
    protected ScreenHeaderBase(WebDriver driver) {
        super(driver);
    }

    public abstract HamburgerMenuScreenBase clickHamburgerButton();

    public abstract CartScreenBase clickCheckoutButton();
}
