package com.carina.methods.demoblaze.components;

import com.carina.methods.demoblaze.pages.AboutUsVideoPage;
import com.carina.methods.demoblaze.pages.CartPage;
import com.carina.methods.demoblaze.pages.HomePage;
import com.carina.methods.demoblaze.pages.LoginMenuPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "//a[@id='nava']")
    private ExtendedWebElement webLogo;

    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    private ExtendedWebElement homeHeaderLink;

    @FindBy(xpath = ".//a[@id='login2']")
    private ExtendedWebElement loginHeaderLink;

    @FindBy(xpath = ".//a [contains(text(), 'About us')]")
    private ExtendedWebElement aboutUsHeaderLink;

    @FindBy(xpath = ".//a [@id= 'cartur']")
    private ExtendedWebElement cartHeaderLink;

    @FindBy(xpath = ".//a[@id='nameofuser']")
    private ExtendedWebElement UserGreetingMessage;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getUserName() {
        return UserGreetingMessage.getText();
    }

    public LoginMenuPage clickSignInLink() {
        loginHeaderLink.click();
        return new LoginMenuPage(getDriver());
    }

    public AboutUsVideoPage clickAboutUsLink() {
        aboutUsHeaderLink.click();
        return new AboutUsVideoPage(getDriver());
    }

    public CartPage clickCartLink() {
        cartHeaderLink.click();
        return new CartPage(getDriver());
    }

    public HomePage clickHomeLink() {
        homeHeaderLink.click();
        return new HomePage(getDriver());
    }

    public boolean isStoreTitlePresent() {
        return webLogo.isPresent();
    }
}
