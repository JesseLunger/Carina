package com.carina.methods.SauceDemo.screens;

import com.carina.methods.SauceDemo.commons.CheckoutOverviewBaseScreen;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutOverviewBaseScreen.class)
public class CheckoutOverviewScreen extends CheckoutOverviewBaseScreen {


    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-FINISH']")
    private ExtendedWebElement finishButton;

    public CheckoutOverviewScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public OrderConfirmationScreen clickFinishButton(){
        finishButton.click();
        return new OrderConfirmationScreen(getDriver());
    }

    @Override
    public HamburgerMenuScreen clickHamburgerMenu(){
        hamburgerMenuButton.click();
        return new HamburgerMenuScreen(getDriver());
    }

    @Override
    public boolean isOpened(){
        return screenTitle.format("CHECKOUT: OVERVIEW").isPresent();
    }
}
