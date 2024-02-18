package com.carina.methods.saucedemo.android.pages;

import com.carina.methods.saucedemo.commons.components.ScreenHeaderBase;
import com.carina.methods.saucedemo.commons.pages.ProductDetailsScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.carina.methods.saucedemo.commons.pages.ProductScreenBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


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
    public void clickCartButton(String productName){
        swipe(addToCartButton.format(productName), 3);
        addToCartButton.format(productName).click();
    }

    @Override
    public String getCost(String productName){
        swipe(productCost.format(productName), 3);
        return productCost.format(productName).getText();
    }

    @Override
    public ProductDetailsScreenBase clickProductImg(String productName) {
        swipe(productImg.format(productName), 3);
        productImg.click();
        return initPage(ProductDetailsScreenBase.class);
    }

    @Override
    public String captureProductImage(String productName){
        swipe(productImg.format(productName));
        WebElement productImageElement = productImg.format(productName).getElement();
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES.BYTES);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedData = messageDigest.digest(screenshot);
            return Base64.getEncoder().encodeToString(hashedData);
        } catch (NoSuchAlgorithmException e){
            LOGGER.debug(e.getMessage());
            return null;
        }
    }
}
