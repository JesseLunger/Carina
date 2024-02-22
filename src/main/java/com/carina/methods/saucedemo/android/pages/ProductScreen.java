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


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductScreenBase.class)
public class ProductScreen extends ProductScreenBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/parent::*/parent::*//android.widget.TextView[@text='ADD TO CART']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/parent::*/parent::*//android.widget.TextView[starts-with(@text, '$')]")
    private ExtendedWebElement productCost;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/parent::*/parent::*//android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement productImg;

    public ProductScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return pageTitle.isPresent();
    }

    @Override
    public void clickCartButtonByName(String productName) {
        swipe(addToCartButton.format(productName), 3);
        addToCartButton.format(productName).click();
    }

    @Override
    public String getCostByName(String productName) {
        swipe(productCost.format(productName), 3);
        return productCost.format(productName).getText();
    }

    @Override
    public ProductDetailsScreenBase clickProductImgByName(String productName) {
        swipe(productImg.format(productName), 3);
        productImg.click();
        return initPage(ProductDetailsScreenBase.class);
    }

    @Override
    public String captureProductImageByName(String productName) {
        swipe(productImg.format(productName));
        WebElement productImageElement = productImg.format(productName).getElement();
        Point location = productImageElement.getLocation();
        int width = productImageElement.getSize().getWidth();
        int height = productImageElement.getSize().getHeight();
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        return ScreenMethods.elementScreenShotHash(screenShot, location, width, height);
    }
}
