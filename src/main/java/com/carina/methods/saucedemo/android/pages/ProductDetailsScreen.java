package com.carina.methods.saucedemo.android.pages;

import com.carina.methods.saucedemo.commons.pages.ProductDetailsScreenBase;
import com.carina.methods.saucedemo.commons.pages.ProductScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailsScreenBase.class)
public class ProductDetailsScreen extends ProductDetailsScreenBase {

    @FindBy(xpath = "//android.widget.TextView[@text=\"BACK TO PRODUCTS\"]")
    private ExtendedWebElement backToProductsButton;

    @FindBy(xpath = " //android.widget.TextView[@content-desc=\"test-Price\"]")
    private ExtendedWebElement productCost;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Image Container\"]/android.widget.ImageView")
    private ExtendedWebElement productImg;

    public ProductDetailsScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductScreenBase clickBackToProducts() {
        swipe(backToProductsButton, 3);
        backToProductsButton.click();
        return initPage(ProductScreenBase.class);
    }

    @Override
    public String getPrice() {
        swipe(productCost, 3);
        return productCost.getText();
    }

}
