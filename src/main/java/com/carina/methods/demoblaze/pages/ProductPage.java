package com.carina.methods.demoblaze.pages;

import com.carina.methods.demoblaze.components.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = " //div [@id=\"navbarExample\"]")
    private Header header;

    @FindBy(xpath = "//h2[@class='name']")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    private ExtendedWebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(addToCartButton);
    }

    public Header getHeader(){
        return header;
    }

    @Override
    public boolean isOpened() {
        return productName.isPresent();
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

}
