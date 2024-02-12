package com.carina.methods.mobile.gui.demoblaze.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        setUiLoadedMarker(productName);
    }

    public HomePage clickHomeInHeader(){
        homeHeaderOption.click();
        return new HomePage(getDriver());
    }

    public void clickAddToCart() {
        addToCartButton.click();
        new WebDriverWait(getDriver(), Duration.ofMillis(2000)).until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public CartPage clickCart(){
        cartHeaderOption.click();
        return new CartPage(getDriver());
    }
}
