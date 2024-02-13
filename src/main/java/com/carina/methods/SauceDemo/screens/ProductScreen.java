package com.carina.methods.SauceDemo.screens;

import com.carina.methods.SauceDemo.components.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProductScreen extends AbstractPage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
    private ExtendedWebElement checkoutCartButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<Product> products;

    @FindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private ExtendedWebElement productsScreenTitle;

    public ProductScreen(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productsScreenTitle);
    }

    public CartScreen clickCheckoutCartButton(){
        checkoutCartButton.click();
        return new CartScreen(getDriver());
    }

    public boolean isOpen(){
        return productsScreenTitle.isElementPresent();
    }

    public List<Product> getProducts() {
        return products;
    }
}
