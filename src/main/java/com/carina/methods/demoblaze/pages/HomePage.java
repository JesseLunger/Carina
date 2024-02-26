package com.carina.methods.demoblaze.pages;

import com.carina.methods.demoblaze.components.Header;
import com.carina.methods.demoblaze.components.ProductItem;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = " //div [@id=\"navbarExample\"]")
    private Header header;

    @FindBy(xpath = "(//img[@src=\"imgs/sony_vaio_5.jpg\"])[2]")
    private ExtendedWebElement lastProductImg;

    @FindBy(xpath = "//div[@class=\"carousel-item active\"]")
    private ExtendedWebElement activeCarouselImg;

    @FindBy(xpath = "//div[@class='col-lg-4 col-md-6 mb-4']")
    private List<ProductItem> products;

    @FindBy(xpath = "//div[@class='card h-100']")
    private ExtendedWebElement gridCard;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(lastProductImg);
        setPageAbsoluteURL(R.CONFIG.get("url"));
    }

    public Header getHeader() {
        return header;
    }

    public List<ProductItem> getProducts() {
        return products;
    }

    public ProductItem getCartItemByName(String itemName) {
        return products.stream()
                .filter(productItem -> productItem.getProductName().equals(itemName))
                .findFirst()
                .orElse(null);
    }
}
