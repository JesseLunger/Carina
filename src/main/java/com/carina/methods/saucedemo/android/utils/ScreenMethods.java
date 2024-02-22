package com.carina.methods.saucedemo.android.utils;

import com.carina.methods.saucedemo.commons.pages.LoginScreenBase;
import com.carina.methods.saucedemo.commons.pages.ProductScreenBase;
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

public class ScreenMethods {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static ProductScreenBase logIn(LoginScreenBase loginScreen, String userName, String Password) {
        loginScreen.typeUsername(userName);
        loginScreen.typePassword(Password);
        return loginScreen.clickLoginButton();
    }

    public static String elementScreenShotHash(File screenShot, Point location, int width, int height) {
        try {
            BufferedImage fullImage = ImageIO.read(screenShot);
            BufferedImage elementScreenShot = fullImage.getSubimage(location.getX(), location.getY(), width, height);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(elementScreenShot, "png", byteArrayOutputStream);
            byte[] screenshotBytes = byteArrayOutputStream.toByteArray();

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedData = messageDigest.digest(screenshotBytes);
            return Base64.getEncoder().encodeToString(hashedData);
        } catch (NoSuchAlgorithmException | IOException e) {
            LOGGER.debug(e.getMessage());
            return null;
        }
    }
}
