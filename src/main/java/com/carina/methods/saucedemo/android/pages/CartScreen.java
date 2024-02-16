package com.carina.methods.saucedemo.android.pages;

import com.carina.methods.saucedemo.commons.pages.CartScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartScreenBase.class)
public class CartScreen extends CartScreenBase {

    @FindBy(xpath = "//android.widget.TextView[@text='YOUR CART']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/parent::*/parent::*//android.widget.TextView[starts-with(@text, '$')]")
    private ExtendedWebElement productCost;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/parent::*/parent::*//android.view.ViewGroup[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeButton;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/parent::*/parent::*/parent::*/parent::*//android.view.ViewGroup[@content-desc='test-Delete']")
    private ExtendedWebElement hiddenRemoveButton;


    public CartScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return pageTitle.isPresent();
    }

    @Override
    public String getCostByName(String productName) {
        return productCost.format(productName).getText();
    }

    @Override
    public void clickRemoveButton(String productName) {
        removeButton.format(productName).click();
    }

    @Override
    public void swipeProductLeft(String productName) {
        swipeLeft(pageTitle.format(productName), 1000);
    }

    @Override
    public void clickExposedRemoveButton(String productName) {
        hiddenRemoveButton.format(productName).click();
    }
}
