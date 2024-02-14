package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.screens.HamburgerMenuScreen;
import com.carina.methods.SauceDemo.screens.OrderConfirmationScreen;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutOverviewBaseScreen extends AbstractPage implements IMobileUtils {
    protected CheckoutOverviewBaseScreen(WebDriver driver) {
        super(driver);
    }
    public abstract OrderConfirmationScreen clickFinishButton();

    public abstract HamburgerMenuScreen clickHamburgerMenu();

    public abstract boolean isOpen();

}
