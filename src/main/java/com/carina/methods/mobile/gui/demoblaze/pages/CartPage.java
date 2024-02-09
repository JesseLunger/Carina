package com.carina.methods.mobile.gui.demoblaze.pages;

import com.carina.methods.mobile.gui.demoblaze.components.CartItem;
import com.carina.methods.mobile.gui.demoblaze.components.PlaceOrderMenu;
import com.carina.methods.mobile.gui.demoblaze.utils.Utils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//h2 [contains(text(), 'Products')]")
    private ExtendedWebElement productsInCartTittle;

    @FindBy(xpath = "//button[contains(text(), 'Place Order')]")
    private ExtendedWebElement placeOrderButton;

    @FindBy(xpath = "//h5[@id='orderModalLabel']")
    private ExtendedWebElement placeOrderHeader;

    @FindBy(xpath = "//*[@id='tbodyid']//*[contains(@class, 'success')]")
    private List<CartItem> cartItems;

    @FindBy(xpath = "//a [contains(text(), 'Delete')]")
    private ExtendedWebElement deleteButton;


    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productsInCartTittle);
    }


    public PlaceOrderMenu clickPlaceOrder(){
        Utils.waitForElementVisible(getDriver(), placeOrderButton);
        placeOrderButton.click();
        Utils.waitForElementVisible(getDriver(), placeOrderHeader);
        return new PlaceOrderMenu(getDriver());
    }

    public List<CartItem> getCartItems(){
        Utils.waitForElementVisible(getDriver(), deleteButton);
        return cartItems;
    }

}
