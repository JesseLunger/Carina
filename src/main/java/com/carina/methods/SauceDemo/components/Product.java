package com.carina.methods.SauceDemo.components;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Product extends AbstractUIObject implements IMobileUtils {

    @FindBy(xpath = ".//android.widget.TextView[@content-desc='test-Item title']")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//android.widget.TextView[@text='ADD TO CART']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = ".//android.widget.TextView[@text='REMOVE']")
    private ExtendedWebElement removeFromCartButton;

    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickTitle(){
        productName.click();
    }

    public void clickAddToCartButton(){
        swipe(addToCartButton, 3);
        addToCartButton.click();
    }

    public boolean removeFromCartButtonIsPresent(){
        return removeFromCartButton.isElementPresent();
    }
}
