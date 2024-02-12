package com.carina.methods.mobile.gui.demoblaze.pages;

import com.carina.methods.mobile.gui.demoblaze.components.CartItem;
import com.carina.methods.mobile.gui.demoblaze.components.PlaceOrderMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {

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

    public PlaceOrderMenu clickPlaceOrder(){
        placeOrderButton.click();
        return new PlaceOrderMenu(getDriver());
    }

    public List<CartItem> getCartItems(){
        return cartItems;
    }

    public void waitForTotal(){
        String prev = "prev";
        String next = "next";
        while (!prev.equals(next)){
            prev = productTotal.getText();
            try{Thread.sleep(500);} catch (InterruptedException e){}
            next = productTotal.getText();
        }
    }
}
