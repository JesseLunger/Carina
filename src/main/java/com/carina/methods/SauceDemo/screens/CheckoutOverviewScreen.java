package com.carina.methods.SauceDemo.screens;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;




public class CheckoutOverviewScreen extends AbstractPage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-FINISH']")
    private ExtendedWebElement finishButton;

    protected CheckoutOverviewScreen(WebDriver driver) {
        super(driver);
    }

    public OrderConfirmationScreen clickFinishButton(){
        finishButton.click();
        return new OrderConfirmationScreen(getDriver());
    }
}
