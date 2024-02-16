package com.carina.methods.saucedemo.android.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = com.carina.methods.saucedemo.commons.pages.HamburgerMenuScreenBase.class)
public class HamburgerMenuScreen extends com.carina.methods.saucedemo.commons.pages.HamburgerMenuScreenBase {

    @FindBy(xpath = "//android.widget.TextView[@text='LOGOUT']")
    private ExtendedWebElement logOutButton;

    public HamburgerMenuScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginScreen clickLogoutButton() {
        logOutButton.click();
        return new LoginScreen(getDriver());
    }

    @Override
    public boolean isOpened() {
        return logOutButton.isPresent();
    }
}