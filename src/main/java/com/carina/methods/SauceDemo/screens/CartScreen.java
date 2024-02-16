package com.carina.methods.SauceDemo.screens;

import com.carina.methods.SauceDemo.commons.CartBaseScreen;
import com.carina.methods.SauceDemo.components.ProductInCartComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartBaseScreen.class)
public class CartScreen extends CartBaseScreen {

    @FindBy(xpath = "//android.widget.TextView(@text=’%s’])")
    private ExtendedWebElement cartPageProductTitle;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CHECKOUT']")
    private ExtendedWebElement checkoutButton;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/parent::*/parent::*")
    private ExtendedWebElement productInCartParent;

    public CartScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutScreen clickCheckoutButton() {
        checkoutButton.click();
        return new CheckoutScreen(getDriver());
    }

    @Override
    public boolean isOpened() {
        return screenTitle.format("YOUR CART").isPresent();
    }

    @Override
    public ProductInCartComponent findByProductInCartName(String name) {
        swipe(productInCartParent.format(name));
        return new ProductInCartComponent(getDriver(), productInCartParent.format(name).getElement());
    }

    @Override
    public CartScreen clickCheckoutHeaderButton() {
        checkoutCartButton.click();
        return new CartScreen(getDriver());
    }

}
