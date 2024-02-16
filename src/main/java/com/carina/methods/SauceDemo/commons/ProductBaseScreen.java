package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.components.Product;
import org.openqa.selenium.WebDriver;

public abstract class ProductBaseScreen extends ScreenBaseClass {

    protected ProductBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract Product getProductByName(String name);

}
