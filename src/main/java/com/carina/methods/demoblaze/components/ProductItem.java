package com.carina.methods.demoblaze.components;

import com.carina.methods.demoblaze.pages.ProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItem extends AbstractUIObject {

    @FindBy(xpath = ".//h4 [@class='card-title']/a")
    private ExtendedWebElement productName;

    public ProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ProductPage clickProduct() {
        productName.click();
        return new ProductPage(getDriver());
    }

    public String getProductName() {
        return productName.getText();
    }

    @Override
    public String toString() {
        return productName.getText();
    }
}
