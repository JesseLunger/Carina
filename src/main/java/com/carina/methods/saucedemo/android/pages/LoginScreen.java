package com.carina.methods.saucedemo.android.pages;

import com.carina.methods.saucedemo.commons.pages.LoginScreenBase;
import com.carina.methods.saucedemo.commons.pages.ProductScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginScreenBase.class)
public class LoginScreen extends LoginScreenBase {

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
    public boolean isOpened() {
        return userNameField.isPresent();
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

}
