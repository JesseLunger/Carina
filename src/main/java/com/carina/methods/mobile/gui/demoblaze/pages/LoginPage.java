package com.carina.methods.mobile.gui.demoblaze.pages;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//a[@id='login2']")
    private ExtendedWebElement loginHeaderOption;

    @FindBy(xpath = "//input[@id='loginusername']")
    private ExtendedWebElement username;

    @FindBy(xpath = "//input[@id='loginpassword']")
    private ExtendedWebElement password;

    @FindBy(xpath = "//button[text()='Log in']")
    private ExtendedWebElement loginButton;


    protected LoginPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(loginHeaderOption);
        setPageAbsoluteURL(R.CONFIG.get("url"));

    }
}
