package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.screens.CheckoutOverviewScreen;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutBaseScreen extends AbstractPage implements IMobileUtils {
    protected CheckoutBaseScreen(WebDriver driver) {
        super(driver);
    }
    public abstract void typeFirstName(String firstName);

    public abstract void typeLastName(String lastName);

    public abstract void typeZipCode(String zipCode);

    public abstract CheckoutOverviewScreen clickContinueButton();

}
