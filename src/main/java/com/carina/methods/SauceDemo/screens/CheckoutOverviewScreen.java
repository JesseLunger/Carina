package com.carina.methods.SauceDemo.screens;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewScreen extends AbstractPage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    private ExtendedWebElement hamburgerMenu;

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: OVERVIEW']")
    private ExtendedWebElement checkoutTitle;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-FINISH']")
    private ExtendedWebElement finishButton;

    public CheckoutOverviewScreen(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(checkoutTitle);
    }

    public OrderConfirmationScreen clickFinishButton(){
        finishButton.click();
        return new OrderConfirmationScreen(getDriver());
    }

    public HamburgerMenuScreen clickHamburgerMenu(){
        hamburgerMenu.click();
        return new HamburgerMenuScreen(getDriver());
    }

    public boolean isOpen(){
        return checkoutTitle.isElementPresent();
    }
}
