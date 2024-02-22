package com.carina.methods.demoblaze.components;

import com.carina.methods.demoblaze.pages.CartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItem extends AbstractUIObject {

    @FindBy(xpath = ".//a [contains(text(), 'Delete')]")
    private ExtendedWebElement deleteButton;

    @FindBy(xpath = ".//td[2]")
    private ExtendedWebElement itemName;

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPage clickDeleteButton() {
        deleteButton.click();
        return new CartPage(getDriver());
    }

    public String getProductName() {
        return itemName.getText();
    }

    @Override
    public String toString() {
        return itemName.getText();
    }
}
