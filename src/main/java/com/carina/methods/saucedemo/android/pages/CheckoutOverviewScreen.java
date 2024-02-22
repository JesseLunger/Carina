package com.carina.methods.saucedemo.android.pages;

import com.carina.methods.saucedemo.commons.pages.CheckoutOverviewScreenBase;
import com.carina.methods.saucedemo.commons.pages.OrderConfirmationScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutOverviewScreenBase.class)
public class CheckoutOverviewScreen extends CheckoutOverviewScreenBase {

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: OVERVIEW']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/parent::*/parent::*/parent::*//android.widget.TextView[starts-with(@text, '$')]")
    private ExtendedWebElement productCost;

    @FindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Backpack']/parent::*/parent::*/parent::*/parent::*//android.view.ViewGroup[@content-desc=\"test-Delete\"]")
    private ExtendedWebElement hiddenRemoveButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-FINISH']")
    private ExtendedWebElement finishButton;

    public CheckoutOverviewScreen(WebDriver driver) {
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
    public void swipeProductLeftByName(String productName) {
        swipeLeft(productTitle.format(productName), 1000);
    }

    @Override
    public void clickExposedRemoveButtonByName(String productName) {
        hiddenRemoveButton.format(productName).click();
    }

    @Override
    public OrderConfirmationScreenBase clickFinishButton() {
        swipe(finishButton, 3);
        finishButton.click();
        return initPage(OrderConfirmationScreenBase.class);
    }
}
