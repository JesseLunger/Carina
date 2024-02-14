package com.carina.methods.SauceDemo.screens;

import com.carina.methods.SauceDemo.commons.OrderConfirmationBaseScreen;
import com.carina.methods.SauceDemo.commons.ProductBaseScreen;
import com.carina.methods.SauceDemo.components.Product;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductBaseScreen.class)
public class ProductScreen extends ProductBaseScreen {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
    private ExtendedWebElement checkoutCartButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<Product> products;

    @FindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private ExtendedWebElement productsScreenTitle;

    public ProductScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartScreen clickCheckoutCartButton(){
        checkoutCartButton.click();
        return new CartScreen(getDriver());
    }

    @Override
    public boolean isOpen(){
        return productsScreenTitle.isElementPresent();
    }

    @Override
    public List<Product> getProducts() {

        return products;
    }
}
