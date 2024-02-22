package com.carina.methods.saucedemo.android.pages;

import com.carina.methods.saucedemo.android.utils.ScreenMethods;
import com.carina.methods.saucedemo.commons.pages.ProductDetailsScreenBase;
import com.carina.methods.saucedemo.commons.pages.ProductScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailsScreenBase.class)
public class ProductDetailsScreen extends ProductDetailsScreenBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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

    @Override
    public String captureProductImage() {
        swipe(productImg);
        WebElement productImageElement = productImg.getElement();
        Point location = productImageElement.getLocation();
        int width = productImageElement.getSize().getWidth();
        int height = productImageElement.getSize().getHeight();
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        return ScreenMethods.elementScreenShotHash(screenShot, location, width, height);
    }
}
