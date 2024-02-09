package com.carina.tests;

import com.carina.methods.mobile.gui.demoblaze.components.*;
import com.carina.methods.mobile.gui.demoblaze.pages.CartPage;
import com.carina.methods.mobile.gui.demoblaze.pages.LandingPage;
import com.carina.methods.mobile.gui.demoblaze.pages.ProductPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class WebTest implements IAbstractTest {

    @Test
    public void signInTest(){
        WebDriver webDriver = getDriver();
        LandingPage landingPage = new LandingPage(webDriver);

        landingPage.open();
        Assert.assertTrue(landingPage.isPageOpened());
        LoginMenu loginMenu = landingPage.clickSignInHeader();

        new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(10)) // Adjust timeout as needed
                .pollingEvery(Duration.ofMillis(500)) // Polling interval
                .ignoring(Exception.class) // Ignore exceptions
                .until(ExpectedConditions.visibilityOf(loginMenu.getUsernameField().getElement()));

        loginMenu.typeUsername(R.TESTDATA.get("user_name"));
        loginMenu.typePassword(R.TESTDATA.get("password"));
        loginMenu.clickLogIn();

        new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(4)) // Adjust timeout as needed
                .pollingEvery(Duration.ofMillis(500)) // Polling interval
                .ignoring(Exception.class) // Ignore exceptions
                .until(ExpectedConditions.visibilityOf(landingPage.getWelcomeUserName().getElement()));
    }

    @Test
    public void buySingleTest(){
        LandingPage landingPage = new LandingPage(getDriver());
        landingPage.open();
        Assert.assertTrue(landingPage.isPageOpened());
        ProductPage productPage = landingPage.getProducts().get(new Random().nextInt(landingPage.getProducts().size())).clickProduct();
        productPage.clickAddToCart();
        CartPage cartPage = productPage.clickCart();

        PlaceOrderMenu placeOrderMenu = cartPage.clickPlaceOrder();
        placeOrderMenu.typeName("george");
        placeOrderMenu.typeCountry("US");
        placeOrderMenu.typeCity("TestyWebVille");
        placeOrderMenu.typeCardNumber("1111-1111-1111-1111");
        placeOrderMenu.typeMonth("03");
        placeOrderMenu.typeYear("2024");
        placeOrderMenu.clickSubmit();
        Assert.assertTrue(placeOrderMenu.checkMarkPresent());
    }

    @Test
    public void addAllItemsToCartTest(){
        LandingPage landingPage = new LandingPage(getDriver());
        landingPage.open();
        Assert.assertTrue(landingPage.isPageOpened());

        for (int i = 0; i < landingPage.getProducts().size(); i++){
            ProductItem productItem = landingPage.getProducts().get(i);
            ProductPage productPage = productItem.clickProduct();
            productPage.clickAddToCart();
            landingPage = productPage.clickHomeInHeader();
        }
    }

    @Test
    public void deleteAllItemsFromCart(){
        addAllItemsToCartTest();
        LandingPage landingPage = new LandingPage(getDriver());
        CartPage cartPage = landingPage.clickCart();
        for (int i = 0; i < cartPage.getCartItems().size(); i++){
            CartItem cartItem = cartPage.getCartItems().get(i);
            cartItem.clickDeleteButton();
            cartPage = new CartPage(getDriver());
        }
        Assert.assertTrue(cartPage.getCartItems().isEmpty());
    }

    @Test
    public void PlayVideo(){
        LandingPage landingPage = new LandingPage(getDriver());
        landingPage.open();
        Assert.assertTrue(landingPage.isPageOpened());
        AboutUsVideo aboutUsVideo = landingPage.clickAboutUs();
        aboutUsVideo.clickOnPlayButton();
        Assert.assertTrue(aboutUsVideo.playButtonInvisible());
    }

}
