package com.carina.methods.saucedemo.commons.pages;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSauceDemoScreenBase extends AbstractPage implements IMobileUtils {

    public AbstractSauceDemoScreenBase(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        throw new UnsupportedOperationException("IsOpened not implemented");
    }

}
