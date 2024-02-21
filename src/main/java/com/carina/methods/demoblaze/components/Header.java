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
    protected ExtendedWebElement storeTitle;

    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    private ExtendedWebElement homeHeaderOption;

    @FindBy(xpath = ".//a[@id='login2']")
    protected ExtendedWebElement loginHeaderOption;

    @FindBy(xpath = ".//a [contains(text(), 'About us')]")
    protected ExtendedWebElement aboutUsHeaderOption;


    @FindBy(xpath = ".//a [@id= 'cartur']")
    protected ExtendedWebElement cartHeaderOption;

    @FindBy(xpath = ".//a[@id='nameofuser']")
    protected ExtendedWebElement headerUserGreeting;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public LoginMenuPage clickSignIn() {
        loginHeaderOption.click();
        return new LoginMenuPage(getDriver());
    }

    public AboutUsVideoPage clickAboutUs() {
        aboutUsHeaderOption.click();
        return new AboutUsVideoPage(getDriver());
    }

    public String getUserName() {
        return headerUserGreeting.getText();
    }

    public CartPage clickCart() {
        cartHeaderOption.click();
        return new CartPage(getDriver());
    }

    public HomePage clickHome() {
        homeHeaderOption.click();
        return new HomePage(getDriver());
    }

    public boolean isStoreTitlePresent(){
        return storeTitle.isPresent();
    }
}
