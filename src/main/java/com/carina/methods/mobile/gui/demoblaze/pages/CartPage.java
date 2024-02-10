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

    @FindBy(xpath = "//img[@width='100']")
    private ExtendedWebElement cartItemImage;

    @FindBy(xpath = "//button[@onclick ='purchaseOrder()']")
    private ExtendedWebElement submitButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productsInCartTittle);
    }

    public PlaceOrderMenu clickPlaceOrder(){
        Utils.waitForElementVisible(getDriver(), placeOrderButton, false);
        placeOrderButton.click();
        Utils.waitForElementVisible(getDriver(), submitButton, false);
        return new PlaceOrderMenu(getDriver());
    }

    public List<CartItem> getCartItems(){
        Utils.waitForElementVisible(getDriver(), cartItemImage, true);
        return cartItems;
    }
}
