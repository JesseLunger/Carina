package com.carina.methods.demoblaze.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    private ExtendedWebElement homeHeaderOption;

    @FindBy(xpath = "//a [@id= 'cartur']")
    private ExtendedWebElement cartHeaderOption;

    @FindBy(xpath = "//h2[@class='name']")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    private ExtendedWebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(addToCartButton);
    }

    public HomePage clickHomeInHeader() {
        homeHeaderOption.click();
        return new HomePage(getDriver());
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public CartPage clickCart() {
        cartHeaderOption.click();
        return new CartPage(getDriver());
    }
}
