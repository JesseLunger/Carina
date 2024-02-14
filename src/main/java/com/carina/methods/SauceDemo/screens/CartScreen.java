package com.carina.methods.SauceDemo.screens;

import com.carina.methods.SauceDemo.commons.CartBaseScreen;
import com.carina.methods.SauceDemo.components.ProductInCart;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartBaseScreen.class)
public class CartScreen extends CartBaseScreen{

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CHECKOUT']")
    private ExtendedWebElement checkoutButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ProductInCart> productsInCart;

    public CartScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutScreen clickCheckoutButton(){
        checkoutButton.click();
        return new CheckoutScreen(getDriver());
    }

    @Override
    public List<ProductInCart> getProductInCart(){
        return productsInCart;
    }
}
