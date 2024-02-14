package com.carina.methods.demoblaze.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginMenuPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='loginusername']")
    private ExtendedWebElement usernameField;

    @FindBy(xpath = "//input[@id='loginpassword']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private ExtendedWebElement loginButton;

    public LoginMenuPage(WebDriver driver) {
        super(driver);
    }

    public void typeUsername(String username){
        usernameField.type(username);
    }

    public void typePassword(String password){
        passwordField.type(password);
    }

    public HomePage clickLogInButton(){
        loginButton.click();
        return new HomePage(getDriver());
    }
}
