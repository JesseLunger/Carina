package com.carina.methods.SauceDemo.screens;

import com.carina.methods.SauceDemo.components.ProductInCart;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartScreen extends AbstractPage {


    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CHECKOUT']")
    private ExtendedWebElement checkoutButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ProductInCart> productsInCart;

    public CartScreen(WebDriver driver) {
        super(driver);

    }

    public CheckoutScreen clickCheckoutButton(){
        checkoutButton.click();
        return new CheckoutScreen(getDriver());
    }

    public List<ProductInCart> getProductInCart(){
        return productsInCart;
    }
}
