package com.carina.methods.SauceDemo.screens;

import com.carina.methods.SauceDemo.components.ProductInCart;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutScreen extends AbstractPage {

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

    public void typeFirstName(String firstName){
        firstNameField.type(firstName);
    }

    public void typeLastName(String lastName){
        lastNameField.type(lastName);
    }

    public void typeZipCode(String zipCode){
        zipCodeField.type(zipCode);
    }

    public CheckoutOverviewScreen clickContinueButton(){
        continueButton.click();
        return new CheckoutOverviewScreen(getDriver());
    }


}
