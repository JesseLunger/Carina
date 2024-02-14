package com.carina.methods.demoblaze.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PlaceOrderFromPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='name']")
    private ExtendedWebElement nameField;

    @FindBy(xpath = "//input[@id='country']")
    private ExtendedWebElement countryField;

    @FindBy(xpath = "//input[@id='city']")
    private ExtendedWebElement cityField;

    @FindBy(xpath = "//input[@id='card']")
    private ExtendedWebElement creditCardField;

    @FindBy(xpath = "//input[@id='month']")
    private ExtendedWebElement monthField;
    
    @FindBy(xpath = "//input[@id='year']")
    private ExtendedWebElement yearField;

    @FindBy(xpath = "//button[@onclick ='purchaseOrder()']")
    private ExtendedWebElement submitButton;

    public PlaceOrderFromPage(WebDriver driver) {
        super(driver);
    }

    public void typeName(String name){
        nameField.type(name);
    }

    public void typeCountry(String country){
        countryField.type(country);
    }

    public void typeCity(String city){
        cityField.type(city);
    }

    public void typeCardNumber(String cardNumber){
        creditCardField.type(cardNumber);
    }

    public void typeMonth(String month){
        monthField.type(month);
    }

    public void typeYear(String year){
        yearField.type(year);
    }

    public OrderConfrimationPage clickSubmitButton(){
        submitButton.click();
        return new OrderConfrimationPage(getDriver());
    }
}
