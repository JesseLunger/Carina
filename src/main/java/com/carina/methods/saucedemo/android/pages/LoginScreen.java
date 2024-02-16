package com.carina.methods.saucedemo.android.pages;

import com.carina.methods.saucedemo.commons.pages.ProductScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = com.carina.methods.saucedemo.commons.pages.LoginScreenBase.class)
public class LoginScreen extends com.carina.methods.saucedemo.commons.pages.LoginScreenBase {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    private ExtendedWebElement userNameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    private ExtendedWebElement loginButton;

    public LoginScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeUsername(String username) {
        userNameField.type(username);
    }

    @Override
    public void typePassword(String password) {
        passwordField.type(password);
    }


    @Override
    public ProductScreenBase clickLoginButton() {
        loginButton.click();
        return initPage(ProductScreenBase.class);
    }

    @Override
    public boolean isOpened() {
        return userNameField.isPresent();
    }
}
