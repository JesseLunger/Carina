package com.carina.methods.saucedemo.android.utils;

import com.carina.methods.saucedemo.android.pages.LoginScreen;
import com.carina.methods.saucedemo.commons.pages.LoginScreenBase;
import com.carina.methods.saucedemo.commons.pages.ProductScreenBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.IDriverPool;
import org.openqa.selenium.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AuthenticationUtil implements ICustomTypePageFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public ProductScreenBase logIn(String userName, String Password) {
        LoginScreenBase loginScreen = initPage(LoginScreenBase.class);
        loginScreen.typeUsername(userName);
        loginScreen.typePassword(Password);
        return loginScreen.clickLoginButton();
    }

    public ProductScreenBase logInStandardUser(){
        LoginScreenBase loginScreen = initPage(LoginScreenBase.class);
        loginScreen.typeUsername(R.TESTDATA.get("android_user_name"));
        loginScreen.typePassword(R.TESTDATA.get("android_password"));
        return loginScreen.clickLoginButton();
    }
}
