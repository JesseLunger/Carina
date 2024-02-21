package com.carina.methods.demoblaze.pages;

import com.carina.methods.demoblaze.components.Header;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OrderConfrimationPage extends BasePage {


    @FindBy(xpath = "//h2[contains(text(), \"Thank you for your purchase!\")]")
    private ExtendedWebElement thankYouMessage;
    @FindBy(xpath = "//div [@class='sa-placeholder']")
    private ExtendedWebElement checkMark;


    public OrderConfrimationPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(thankYouMessage);
        setPageAbsoluteURL(R.CONFIG.get("url"));
    }

    @Override
    public boolean isOpened() {
        return thankYouMessage.isPresent();
    }


    public boolean isCheckMarkPresent() {
        return checkMark.isPresent();
    }
}
