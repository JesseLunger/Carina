package com.carina.methods.SauceDemo.screens;

import com.carina.methods.SauceDemo.commons.ProductBaseScreen;
import com.carina.methods.SauceDemo.components.ProductComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductBaseScreen.class)
public class ProductScreen extends ProductBaseScreen {

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='%s']/parent::*")
    private ExtendedWebElement productParent;

    public ProductScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return screenTitle.format("PRODUCTS").isPresent();
    }

    @Override
    public ProductComponent getProductByName(String name) {
        return new ProductComponent(getDriver(), productParent.format(name).getElement());
    }

}
