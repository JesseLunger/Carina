package com.carina.methods.saucedemo.commons.pages;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public abstract class ProductDetailsScreenBase extends AbstractPage implements IMobileUtils {

    public ProductDetailsScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getPrice();

    public abstract ProductScreenBase clickBackToProducts();

    public abstract String captureProductImage();

}
