package com.carina.methods.saucedemo.android.pages;

import com.carina.methods.saucedemo.commons.pages.HamburgerMenuScreenBase;
import com.carina.methods.saucedemo.commons.pages.LoginScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HamburgerMenuScreenBase.class)
public class HamburgerMenuScreen extends HamburgerMenuScreenBase {

    @FindBy(xpath = "//android.widget.TextView[@text='LOGOUT']")
    private ExtendedWebElement logOutButton;

    public HamburgerMenuScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return logOutButton.isPresent();
    }

    @Override
    public LoginScreenBase clickLogoutButton() {
        logOutButton.click();
        return initPage(LoginScreenBase.class);
    }

}