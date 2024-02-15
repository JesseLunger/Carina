package com.carina.methods.SauceDemo.commons;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class ScreenBaseClass extends AbstractPage implements IMobileUtils {

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    protected ExtendedWebElement screenTitle;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    protected ExtendedWebElement hamburgerMenuButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
    protected ExtendedWebElement checkoutCartButton;


    protected ScreenBaseClass(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        throw  new UnsupportedOperationException("IsOpen not implemented");
    }
}
