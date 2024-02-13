package com.carina.methods.SauceDemo.screens;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HamburgerMenuScreen extends AbstractPage {

    @FindBy(xpath = "//android.widget.TextView[@text='LOGOUT']")
    private ExtendedWebElement logOutButton;

    public HamburgerMenuScreen(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(logOutButton);
    }

    public HomeScreen clickLogoutButton(){
        logOutButton.click();
        return new HomeScreen(getDriver());
    }
}
