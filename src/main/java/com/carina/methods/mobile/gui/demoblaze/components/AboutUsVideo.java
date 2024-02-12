package com.carina.methods.mobile.gui.demoblaze.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class AboutUsVideo extends AbstractUIObject {

    @FindBy(xpath = "//button[@title='Play Video']")
    private ExtendedWebElement playButton;

    @FindBy(xpath = "//span[@class='vjs-remaining-time-display']")
    private ExtendedWebElement remainingTime;

    public AboutUsVideo(WebDriver driver) {
        super(driver);
    }

    public void clickPlayButton(){
        playButton.click();
    }

    public boolean remainingTimeUpdating(){
        String initRemainingTime = remainingTime.getText();
        try{Thread.sleep(2000);} catch (InterruptedException e){}
        return !remainingTime.getText().equals(initRemainingTime);
    }
}