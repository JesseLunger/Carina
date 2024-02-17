package com.carina.methods.saucedemo.android.components;

import com.carina.methods.saucedemo.android.pages.HamburgerMenuScreen;
import com.carina.methods.saucedemo.commons.components.ScreenHeaderBase;
import com.carina.methods.saucedemo.commons.pages.CartScreenBase;
import com.carina.methods.saucedemo.commons.pages.CheckoutOverviewScreenBase;
import com.carina.methods.saucedemo.commons.pages.HamburgerMenuScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ScreenHeaderBase.class)
public class ScreenHeader extends ScreenHeaderBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    private ExtendedWebElement hamburgerMenuButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
    private ExtendedWebElement checkoutButton;


    public ScreenHeader(WebDriver driver) {
        super(driver);
    }

    public HamburgerMenuScreenBase clickHamburgerButton(){
        hamburgerMenuButton.click();
        return initPage(HamburgerMenuScreenBase.class);
    }

    public CartScreenBase clickCheckoutButton(){
        checkoutButton.click();
        return initPage(CartScreenBase.class);
    }
}
