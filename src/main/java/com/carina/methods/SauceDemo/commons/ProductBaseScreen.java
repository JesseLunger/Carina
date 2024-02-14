package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.components.Product;
import com.carina.methods.SauceDemo.screens.CartScreen;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductBaseScreen extends AbstractPage implements IMobileUtils {

    protected ProductBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract CartScreen clickCheckoutCartButton();

    public abstract boolean isOpen();

    public abstract List<Product> getProducts();
}
