package com.carina.methods.SauceDemo.components;

import com.carina.methods.SauceDemo.commons.ProductInCartBaseComponent;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductInCartComponent extends ProductInCartBaseComponent {

    @FindBy(xpath = ".//android.widget.TextView[@text='REMOVE']")
    private ExtendedWebElement removeButton;


    public ProductInCartComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickRemoveButton() {
        swipe(removeButton, 4); //Only swipes down in search of element
        //want to use swipeUp but there is not option avaialbe to increase the speed, takes 5 minutes to traverse screen.
        removeButton.click();
    }

    public boolean isPresent() {
        return removeButton.isPresent(2);
    }

}
