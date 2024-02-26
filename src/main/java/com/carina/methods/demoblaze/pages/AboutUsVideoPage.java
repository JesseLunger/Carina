package com.carina.methods.demoblaze.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class AboutUsVideoPage extends AbstractPage {

    @FindBy(xpath = "//h5 [@id=\"videoModalLabel\"]")
    private ExtendedWebElement aboutUsLabel;

    @FindBy(xpath = "//button[@title='Play Video']")
    private ExtendedWebElement playButton;

    @FindBy(xpath = "//span[@class='vjs-remaining-time-display']")
    private ExtendedWebElement remainingTime;

    public AboutUsVideoPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(aboutUsLabel);
    }

    public void clickPlayButton() {
        playButton.click();
    }

    public String getRemainingVideoPlayTime() {
        return remainingTime.getText();
    }
}