package com.carina.methods.demoblaze.pages;

import com.carina.methods.demoblaze.components.CartItem;
import com.carina.methods.demoblaze.components.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(xpath = " //div [@id=\"navbarExample\"]")
    private Header header;

    @FindBy(xpath = "//h2[contains(text(), \"Products\")]")
    private ExtendedWebElement productsLogo;

    @FindBy(xpath = "//h3[@id='totalp']")
    private ExtendedWebElement productTotal;

    @FindBy(xpath = "//*[@id='tbodyid']//*[contains(@class, 'success')]")
    private List<CartItem> cartItems;

    @FindBy(xpath = "//img[@width='100']")
    private ExtendedWebElement cartItemImage;

    @FindBy(xpath = "//button[contains(text(), 'Place Order')]")
    private ExtendedWebElement placeOrderButton;

    @FindBy(xpath = "//button[@onclick ='purchaseOrder()']")
    private ExtendedWebElement submitButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productsLogo);
    }

    public Header getHeader(){
        return header;
    }

    public PlaceOrderFormPage clickPlaceOrder() {
        placeOrderButton.click();
        return new PlaceOrderFormPage(getDriver());
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
