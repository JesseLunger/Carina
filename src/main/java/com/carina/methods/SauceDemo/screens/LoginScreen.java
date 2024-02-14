package com.carina.methods.SauceDemo.screens;

import com.carina.methods.SauceDemo.commons.LoginBaseScreen;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginBaseScreen.class)
public class LoginScreen extends LoginBaseScreen {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    private ExtendedWebElement userNameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    private ExtendedWebElement loginButton;

    public LoginScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeUsername(String username){
        userNameField.type(username);
    }

    @Override
    public void typePassword(String password){
        passwordField.type(password);
    }


    @Override
    public ProductScreen clickLoginButton(){
        loginButton.click();
        return new ProductScreen(getDriver());
    }

    @Override
    public boolean isOpen(){
        return userNameField.isElementPresent();
    }
}
