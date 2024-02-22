package com.carina.methods.saucedemo.commons.pages;

import org.openqa.selenium.WebDriver;

public abstract class CheckoutScreenBase extends AbstractSauceDemoScreenBase {

    public CheckoutScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeFirstName(String firstName);

    public abstract void typeLastName(String lastName);

    public abstract void typeZipCode(String zipCode);

    public abstract CheckoutOverviewScreenBase clickContinueButton();

}
