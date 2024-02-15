package com.carina.methods.SauceDemo.screens;

import com.carina.methods.SauceDemo.commons.CheckoutBaseScreen;
import com.carina.methods.SauceDemo.components.ProductInCart;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutBaseScreen.class)
public class CheckoutScreen extends CheckoutBaseScreen{

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-First Name']")
    private ExtendedWebElement firstNameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Last Name']")
    private ExtendedWebElement lastNameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Zip/Postal Code']")
    private ExtendedWebElement zipCodeField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CONTINUE']")
    private ExtendedWebElement continueButton;

    public CheckoutScreen(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(firstNameField);
    }

    @Override
    public void typeFirstName(String firstName){
        firstNameField.type(firstName);
    }

    @Override
    public void typeLastName(String lastName){
        lastNameField.type(lastName);
    }

    @Override
    public void typeZipCode(String zipCode){
        zipCodeField.type(zipCode);
    }

    @Override
    public CheckoutOverviewScreen clickContinueButton(){
        continueButton.click();
        return new CheckoutOverviewScreen(getDriver());
    }

    @Override
    public boolean isOpened(){
        return screenTitle.format("CHECKOUT: INFORMATION").isPresent();
    }


}
