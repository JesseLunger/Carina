package com.carina.methods.SauceDemo.screens;

import com.carina.methods.SauceDemo.commons.OrderConfirmationBaseScreen;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import groovy.util.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = OrderConfirmationBaseScreen.class)
public class OrderConfirmationScreen extends OrderConfirmationBaseScreen {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-BACK HOME']")
    private ExtendedWebElement backToHomeButton;

    public OrderConfirmationScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductScreen clickBackToHomeButton() {
        backToHomeButton.click();
        return new ProductScreen(getDriver());
    }

    @Override
    public boolean isOpened() {
        return screenTitle.format("CHECKOUT: COMPLETE!").isPresent();
    }

    @Override
    public HamburgerMenuScreen clickHamburgerMenu() {
        hamburgerMenuButton.click();
        return new HamburgerMenuScreen(getDriver());
    }
}
