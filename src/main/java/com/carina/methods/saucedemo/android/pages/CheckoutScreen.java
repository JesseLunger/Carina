package com.carina.methods.saucedemo.android.pages;

import com.carina.methods.saucedemo.commons.pages.CheckoutOverviewScreenBase;
import com.carina.methods.saucedemo.commons.pages.CheckoutScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutScreenBase.class)
public class CheckoutScreen extends CheckoutScreenBase {

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: INFORMATION']")
    private ExtendedWebElement checkoutInformationPageTitle;

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
    }

    @Override
    public boolean isOpened() {
        return checkoutInformationPageTitle.isPresent();
    }

    @Override
    public void typeFirstName(String firstName) {
        firstNameField.type(firstName);
    }

    @Override
    public void typeLastName(String lastName) {
        lastNameField.type(lastName);
    }

    @Override
    public void typeZipCode(String zipCode) {
        zipCodeField.type(zipCode);
    }

    @Override
    public CheckoutOverviewScreenBase clickContinueButton() {
        continueButton.click();
        return initPage(CheckoutOverviewScreenBase.class);
    }

}
