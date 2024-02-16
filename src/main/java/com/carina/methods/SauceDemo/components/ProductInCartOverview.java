package com.carina.methods.SauceDemo.components;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductInCartOverview extends AbstractUIObject implements IMobileUtils {

    String productName;
    @FindBy(xpath = ".//android.view.ViewGroup[@content-desc='test-Delete']")
    private ExtendedWebElement trashCanButton;
    @FindBy(xpath = ".//android.widget.TextView[@text='%s']")
    private ExtendedWebElement dynamicProductName;


    public ProductInCartOverview(WebDriver driver, SearchContext searchContext, String productName) {
        super(driver, searchContext);
        this.productName = productName;
    }

    // I have tried multiple differen't swipes, on multiple different objects, but cannot get
    // swipe to reveal trash button.

//    public void swipeProductLeft(){
//        dynamicProductName.format(productName).isPresent();
//        swipeInContainer(dynamicProductName.format(productName), Direction.LEFT, 3);
//    }


}
