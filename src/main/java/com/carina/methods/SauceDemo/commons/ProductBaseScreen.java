package com.carina.methods.SauceDemo.commons;

import com.carina.methods.SauceDemo.components.ProductComponent;
import org.openqa.selenium.WebDriver;

public abstract class ProductBaseScreen extends AbstractSauceDemoScreenBase {

    public ProductBaseScreen(WebDriver driver) {
        super(driver);
    }

    public abstract ProductComponent getProductByName(String name);

}
