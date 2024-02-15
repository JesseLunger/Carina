package com.carina.methods.SauceDemo.screens;

import com.carina.methods.SauceDemo.commons.OrderConfirmationBaseScreen;
import com.carina.methods.SauceDemo.commons.ProductBaseScreen;
import com.carina.methods.SauceDemo.components.Product;
import com.carina.methods.utils.MobileContextUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductBaseScreen.class)
public class ProductScreen extends ProductBaseScreen {

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='%s']/parent::*")
    private ExtendedWebElement productParent;

    @FindBy(xpath = "//android.widget.TextView[@text='Terms of Service | Privacy Policy']")
    private ExtendedWebElement lowestUniqueElement;


    public ProductScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartScreen clickCheckoutCartButton(){
        checkoutCartButton.click();
        return new CartScreen(getDriver());
    }

    @Override
    public boolean isOpened(){
        return screenTitle.format("PRODUCTS").isPresent();
    }

    @Override
    public Product getProductByName(String name) {
        swipe(productParent.format(name));
        return new Product(getDriver(), productParent.format(name).getElement());
    }

}
