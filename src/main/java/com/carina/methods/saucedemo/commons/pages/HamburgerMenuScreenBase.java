package com.carina.methods.saucedemo.commons.pages;

import org.openqa.selenium.WebDriver;

public abstract class HamburgerMenuScreenBase extends AbstractSauceDemoScreenBase {

    public HamburgerMenuScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginScreenBase clickLogoutButton();

}
