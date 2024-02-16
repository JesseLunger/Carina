package com.carina.methods.demoblaze.pages;

import com.carina.methods.demoblaze.components.CartItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//h3[@id='totalp']")
    private ExtendedWebElement productTotal;

    @FindBy(xpath = "//button[contains(text(), 'Place Order')]")
    private ExtendedWebElement placeOrderButton;

    @FindBy(xpath = "//h5[@id='orderModalLabel']")
    private ExtendedWebElement placeOrderHeader;

    @FindBy(xpath = "//*[@id='tbodyid']//*[contains(@class, 'success')]")
    private List<CartItem> cartItems;

    @FindBy(xpath = "//img[@width='100']")
    private ExtendedWebElement cartItemImage;

    @FindBy(xpath = "//button[@onclick ='purchaseOrder()']")
    private ExtendedWebElement submitButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(cartItemImage);
    }

    public PlaceOrderFromPage clickPlaceOrder() {
        placeOrderButton.click();
        return new PlaceOrderFromPage(getDriver());
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public CartItem getCartItemByName(String itemName) {
        return cartItems.stream()
                .filter(cartItem -> cartItem.getProductName().equals(itemName))
                .findFirst()
                .orElse(null);
    }

    public String getTotal() {
        return productTotal.getText();
    }
}
