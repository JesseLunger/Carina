package com.carina.methods.SauceDemo.commons;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductBaseComponent extends AbstractUIObject implements IMobileUtils {
    public ProductBaseComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void clickTitle();

    public abstract void clickAddToCartButton();

    public abstract boolean isRemoveFromCartButtonIsPresent();
}
