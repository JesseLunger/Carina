package com.carina.methods.SauceDemo.screens;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomeScreen extends AbstractPage {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    private ExtendedWebElement userNameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    private ExtendedWebElement loginButton;

    public HomeScreen(WebDriver driver) {
        super(driver);
    }


    public void typeUsername(String username){
        userNameField.type(username);
    }

    public void typePassword(String password){
        passwordField.type(password);
    }


    public ProductScreen clickLoginButton(){
        loginButton.click();
        return new ProductScreen(getDriver());
    }

}
