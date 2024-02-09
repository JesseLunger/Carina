package com.carina.methods.mobile.gui.demoblaze.components;

import com.carina.methods.mobile.gui.demoblaze.pages.ProductPage;
import com.carina.methods.mobile.gui.demoblaze.utils.Utils;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductItem extends AbstractUIObject {

    @FindBy(xpath = ".//img [@class= 'card-img-top img-fluid']")
    private ExtendedWebElement productName;

    public ProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ProductPage clickProduct(){
        Utils.waitForElementVisible(getDriver(), productName);
        productName.click();
        return new ProductPage(getDriver());
    }

    public WebElement getElement(){
        return productName.getElement();
    }
}
