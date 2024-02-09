package com.carina.methods.mobile.gui.demoblaze.pages;

import com.carina.methods.mobile.gui.demoblaze.components.AboutUsVideo;
import com.carina.methods.mobile.gui.demoblaze.components.LoginMenu;
import com.carina.methods.mobile.gui.demoblaze.components.ProductItem;
import com.carina.methods.mobile.gui.demoblaze.utils.Utils;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class LandingPage extends AbstractPage {

    @FindBy (xpath = "//a[@id=\"nameofuser\"]")
    private ExtendedWebElement WelcomeUserName;

    @FindBy(xpath = "//a[@id='login2']")
    private ExtendedWebElement loginHeaderOption;

    @FindBy(xpath = "//a [contains(text(), 'About us')]")
    private ExtendedWebElement aboutUsHeaderOption;

    @FindBy(xpath = "//div[@class='col-lg-4 col-md-6 mb-4']")
    private List<ProductItem> products;

    @FindBy(xpath = "//div[@class='card h-100']")
    private ExtendedWebElement gridCard;

    @FindBy(xpath = "//a [@id= 'cartur']")
    private ExtendedWebElement cartHeaderOption;

    public LandingPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(loginHeaderOption);
        setPageAbsoluteURL(R.CONFIG.get("url"));
    }

    public LoginMenu clickSignInHeader(){
        Utils.waitForElementVisible(getDriver(), loginHeaderOption);
        loginHeaderOption.click();
        return new LoginMenu(getDriver());
    }

    public CartPage clickCart(){
        Utils.waitForElementVisible(getDriver(), cartHeaderOption);
        cartHeaderOption.click();
        return new CartPage(getDriver());
    }

    public AboutUsVideo clickAboutUs(){
        Utils.waitForElementVisible(getDriver(), aboutUsHeaderOption);
        aboutUsHeaderOption.click();
        return new AboutUsVideo(getDriver());
    }

    public ExtendedWebElement getWelcomeUserName() {
        return WelcomeUserName;
    }

    public ExtendedWebElement getLoginHeaderOption() {
        return loginHeaderOption;
    }

    public List<ProductItem> getProducts() {
        Utils.waitForElementVisible(getDriver(), gridCard);
        return products;
    }
}
