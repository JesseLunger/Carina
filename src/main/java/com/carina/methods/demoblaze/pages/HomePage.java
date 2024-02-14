package com.carina.methods.demoblaze.pages;

import com.carina.methods.demoblaze.components.ProductItem;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='col-lg-4 col-md-6 mb-4']")
    private List<ProductItem> products;

    @FindBy(xpath = "//div[@class='card h-100']")
    private ExtendedWebElement gridCard;

    @FindBy(xpath = "//a[@href='prod.html?idp_=9']")
    private ExtendedWebElement lastProductImage;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(lastProductImage); //not working page
        setPageAbsoluteURL(R.CONFIG.get("url"));

    }

    public LoginMenuPage clickSignInHeader(){
        loginHeaderOption.click();
        return new LoginMenuPage(getDriver());
    }

    public AboutUsVideoPage clickAboutUs(){
        aboutUsHeaderOption.click();
        return new AboutUsVideoPage(getDriver());
    }

    public String getUserName(){
        return headerUserGreeting.getText();
    }

    public List<ProductItem> getProducts() {
        return products;
    }

    public ProductItem getCartItemByName(String itemName){
        return products.stream()
                .filter(productItem -> productItem.getProductName().equals(itemName))
                .findFirst()
                .orElse(null);
    }
}
