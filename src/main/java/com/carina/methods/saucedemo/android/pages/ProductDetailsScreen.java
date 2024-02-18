package com.carina.methods.saucedemo.android.pages;

import com.carina.methods.saucedemo.commons.pages.ProductDetailsScreenBase;
import com.carina.methods.saucedemo.commons.pages.ProductScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

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
    public String captureProductImage(){
        swipe(productImg);
        WebElement productImageElement = productImg.getElement();
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
