package com.carina.methods.saucedemo.android.utils;

import com.carina.methods.saucedemo.android.pages.LoginScreen;
import com.carina.methods.saucedemo.commons.pages.ProductScreenBase;
import org.testng.Assert;

public class AuthorizationUtil {

    public static ProductScreenBase logIn(LoginScreen loginScreen, String userName, String Password){
        loginScreen.typeUsername(userName);
        loginScreen.typePassword(Password);
        return loginScreen.clickLoginButton();
    }
}
