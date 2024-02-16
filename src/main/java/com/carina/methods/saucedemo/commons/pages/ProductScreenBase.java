package com.carina.methods.saucedemo.commons.pages;

import org.openqa.selenium.WebDriver;

public abstract class ProductScreenBase extends AbstractSauceDemoScreenBase {



    public ProductScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract void clickCartButton(String productName);

    public abstract String getCostByName(String productName);

    public abstract String getImage(String productName);

}
