package com.carina.methods.demoblaze.pages;

import com.carina.methods.demoblaze.components.Header;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginMenuPage extends AbstractPage {

    @FindBy(xpath = "//h5[@id=\"signInModalLabel\"]")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//input[@id='loginusername']")
    private ExtendedWebElement usernameField;

    @FindBy(xpath = "//input[@id='loginpassword']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private ExtendedWebElement loginButton;

    public LoginMenuPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(usernameField);
        setPageAbsoluteURL(R.CONFIG.get("url"));
    }

    public void typeUsername(String username) {
        usernameField.type(username);
    }

    public void typePassword(String password) {
        passwordField.type(password);
    }

    public HomePage clickLogInButton() {
        loginButton.click();
        return new HomePage(getDriver());
    }
}
