package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.screens.CheckoutOverviewScreen;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutBaseScreen extends ScreenBaseClass {

    protected CheckoutBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract void typeFirstName(String firstName);

    public abstract void typeLastName(String lastName);

    public abstract void typeZipCode(String zipCode);

    public abstract CheckoutOverviewScreen clickContinueButton();

}
