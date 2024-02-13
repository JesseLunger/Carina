package com.carina.methods.SauceDemo.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Product extends AbstractUIObject {

    @FindBy(xpath = ".//android.widget.TextView[@content-desc='test-Item title']")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = "(//android.widget.TextView[@text='ADD TO CART'])")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.widget.TextView[@text='REMOVE']")
    private ExtendedWebElement removeFromCartButton;



    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickTitle(){
        productTitle.click();
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public void hasBeenSelected(){
        removeFromCartButton.click();
    }

}
