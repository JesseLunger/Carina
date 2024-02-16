package com.carina.methods.SauceDemo.screens;

import com.carina.methods.SauceDemo.commons.CheckoutOverviewBaseScreen;
import com.carina.methods.SauceDemo.components.ProductInCartOverviewComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutOverviewBaseScreen.class)
public class CheckoutOverviewScreen extends CheckoutOverviewBaseScreen {


    @FindBy(xpath = "//android.widget.TextView[@text='%s']/parent::*/parent::*/parent::*/parent::*")
    private ExtendedWebElement productInCartParent;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-FINISH']")
    private ExtendedWebElement finishButton;

    public CheckoutOverviewScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public OrderConfirmationScreen clickFinishButton() {
        swipe(finishButton, 3);
        finishButton.click();
        return new OrderConfirmationScreen(getDriver());
    }

    @Override
    public boolean isOpened() {
        return screenTitle.format("CHECKOUT: OVERVIEW").isPresent();
    }

    @Override
    public ProductInCartOverviewComponent getByProductInCartName(String name) {
        swipe(productInCartParent.format(name));
        ProductInCartOverviewComponent productInCartOverviewComponent = new ProductInCartOverviewComponent(getDriver(), productInCartParent.format(name).getElement());
        productInCartOverviewComponent.setName(name);
        return productInCartOverviewComponent;
    }

}
