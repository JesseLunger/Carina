package com.carina.methods.SauceDemo.screens;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationScreen extends AbstractPage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-BACK HOME']")
    private ExtendedWebElement backToHomeButton;

    protected OrderConfirmationScreen(WebDriver driver) {
        super(driver);
    }

    public ProductScreen clickBackToHomeButton(){
        backToHomeButton.click();
        return new ProductScreen(getDriver());
    }
}
