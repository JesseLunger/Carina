package com.carina.methods.saucedemo.android.pages;

import com.carina.methods.saucedemo.commons.pages.OrderConfirmationScreenBase;
import com.carina.methods.saucedemo.commons.pages.ProductScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = OrderConfirmationScreenBase.class)
public class OrderConfirmationScreen extends OrderConfirmationScreenBase {

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: COMPLETE!']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]")
    private ExtendedWebElement thankYouMessage;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-BACK HOME']")
    private ExtendedWebElement backToHomeButton;

    public OrderConfirmationScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return pageTitle.isPresent();
    }

    @Override
    public boolean isThankyouMessagePresent() {
        return thankYouMessage.isPresent();
    }

    @Override
    public ProductScreenBase clickBackToHomeButton() {
        backToHomeButton.click();
        return initPage(ProductScreenBase.class);
    }

}
