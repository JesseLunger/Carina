package com.carina.methods.saucedemo.android.pages;

import com.carina.methods.saucedemo.commons.components.ScreenHeaderBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.carina.methods.saucedemo.commons.pages.ProductScreenBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductScreenBase.class)
public class ProductScreen extends ProductScreenBase {


    @FindBy(xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/parent::*/parent::*//android.widget.TextView[@text='ADD TO CART']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/parent::*/parent::*//android.widget.TextView[starts-with(@text, '$')]")
    private ExtendedWebElement productCost;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/parent::*/parent::*//android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement productImg;

    public ProductScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return pageTitle.isPresent();
    }

    @Override
    public void clickCartButton(String productName){
        swipe(addToCartButton.format(productName), 3);
        addToCartButton.format(productName).click();
    }

    @Override
    public String getCostByName(String productName){
        swipe(productCost.format(productName), 3);
        return productCost.format(productName).getText();
    }

    @Override
    public String getImage(String productName){
        swipe(productImg.format(productName), 3);
        return productImg.format(productName).getAttribute("src");
    }


}
