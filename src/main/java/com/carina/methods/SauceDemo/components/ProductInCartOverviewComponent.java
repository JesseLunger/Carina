package com.carina.methods.SauceDemo.components;

import com.carina.methods.SauceDemo.commons.ProductInCartOverviewBaseComponent;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductInCartOverviewComponent extends ProductInCartOverviewBaseComponent {
    @FindBy(xpath = ".//android.view.ViewGroup[@content-desc='test-Delete']")
    private ExtendedWebElement trashCanButton;
    @FindBy(xpath = ".//android.widget.TextView[@text='%s']")
    private ExtendedWebElement dynamicProductName;

    private String productName;

    public ProductInCartOverviewComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void swipeProductLeft(){
        dynamicProductName.format(productName).isPresent();
        swipeLeft(dynamicProductName.format(productName), 1000);
    }

    public void setName(String name){
        this.productName = name;
    }
}
