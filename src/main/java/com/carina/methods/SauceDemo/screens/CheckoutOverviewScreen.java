package com.carina.methods.SauceDemo.screens;

import com.carina.methods.SauceDemo.commons.CartBaseScreen;
import com.carina.methods.SauceDemo.commons.CheckoutOverviewBaseScreen;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.carina.demo.utils.MobileContextUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutOverviewBaseScreen.class)
public class CheckoutOverviewScreen extends CheckoutOverviewBaseScreen {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    private ExtendedWebElement hamburgerMenu;

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: OVERVIEW']")
    private ExtendedWebElement checkoutTitle;

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
        hamburgerMenu.click();
        return new HamburgerMenuScreen(getDriver());
    }

    @Override
    public boolean isOpen(){
        return checkoutTitle.isElementPresent();
    }
}
