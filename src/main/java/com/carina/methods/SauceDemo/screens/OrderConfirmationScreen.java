package com.carina.methods.SauceDemo.screens;

import com.carina.methods.SauceDemo.commons.OrderConfirmationBaseScreen;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = OrderConfirmationBaseScreen.class)
public class OrderConfirmationScreen extends OrderConfirmationBaseScreen {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-BACK HOME']")
    private ExtendedWebElement backToHomeButton;

    protected OrderConfirmationScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductScreen clickBackToHomeButton(){
        backToHomeButton.click();
        return new ProductScreen(getDriver());
    }
}
