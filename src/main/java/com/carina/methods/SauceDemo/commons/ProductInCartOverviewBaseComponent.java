package com.carina.methods.SauceDemo.commons;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductInCartOverviewBaseComponent extends AbstractUIObject implements IMobileUtils {

    protected ProductInCartOverviewBaseComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void swipeProductLeft();

    public abstract void setName(String name);
}
