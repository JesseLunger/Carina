package com.carina.methods.mobile.gui.demoblaze.components;

import com.carina.methods.api.PutEmployeeMethod;
import com.carina.methods.mobile.gui.demoblaze.utils.Utils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;


public class AboutUsVideo extends AbstractUIObject {


    @FindBy(xpath = "//div[@id='example-video']")
    private ExtendedWebElement playButton;

    @FindBy(xpath = "//div [@class = 'video-js example-video-dimensions vjs-controls-enabled vjs-touch-enabled vjs-workinghover vjs-v7 vjs-has-started vjs-paused vjs-user-inactive']")
    private ExtendedWebElement videoPaused;

    public AboutUsVideo(WebDriver driver) {
        super(driver);
    }

    public void clickOnPlayButton(){
        Utils.waitForElementVisible(getDriver(), playButton);
        playButton.click();
    }


    public boolean playButtonInvisible(){
        return !videoPaused.isVisible();
    }



}
