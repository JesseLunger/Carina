package com.carina.methods.mobile.gui.demoblaze.pages;

import com.carina.methods.mobile.gui.demoblaze.components.AboutUsVideo;
import com.carina.methods.mobile.gui.demoblaze.components.LoginMenu;
import com.carina.methods.mobile.gui.demoblaze.components.ProductItem;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//a[@href='prod.html?idp_=9']")
    private ExtendedWebElement pageLoadedMarker;

    @FindBy(xpath = "//a[@id='login2']")
    private ExtendedWebElement loginHeaderOption;

    @FindBy (xpath = "//a[@id='nameofuser']")
    private ExtendedWebElement welcomeUserName;

    @FindBy(xpath = "//h5 [@id='logInModalLabel']")
    private ExtendedWebElement logInMenuHeader;

    @FindBy(xpath = "//a [contains(text(), 'About us')]")
    private ExtendedWebElement aboutUsHeaderOption;

    @FindBy(xpath = "//div[@class='col-lg-4 col-md-6 mb-4']")
    private List<ProductItem> products;

    @FindBy(xpath = "//div[@class='card h-100']")
    private ExtendedWebElement gridCard;

    @FindBy(xpath = "//a [@id= 'cartur']")
    private ExtendedWebElement cartHeaderOption;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageLoadedMarker); //not working page
        setPageAbsoluteURL(R.CONFIG.get("url"));

    }

    public LoginMenu clickSignInHeader(){
        loginHeaderOption.click();
        return new LoginMenu(getDriver());
    }

    public CartPage clickCart(){
        cartHeaderOption.click();
        return new CartPage(getDriver());
    }

    public AboutUsVideo clickAboutUs(){
        aboutUsHeaderOption.click();
        return new AboutUsVideo(getDriver());
    }

    public Boolean welcomeUserVisible(){
        return welcomeUserName.isVisible();
    }

    public List<ProductItem> getProducts() {
        return products;
    }
}
