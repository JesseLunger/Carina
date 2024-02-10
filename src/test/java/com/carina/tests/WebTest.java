package com.carina.tests;

import com.carina.methods.mobile.gui.demoblaze.components.*;
import com.carina.methods.mobile.gui.demoblaze.pages.CartPage;
import com.carina.methods.mobile.gui.demoblaze.pages.HomePage;
import com.carina.methods.mobile.gui.demoblaze.pages.ProductPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class WebTest implements IAbstractTest {

    @Test
    public void signInTest(){
        WebDriver webDriver = getDriver();
        HomePage homePage = new HomePage(webDriver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());

        LoginMenu loginMenu = homePage.clickSignInHeader();
        loginMenu.typeUsername(R.TESTDATA.get("user_name"));
        loginMenu.typePassword(R.TESTDATA.get("password"));
        homePage = loginMenu.clickLogInButton();
        Assert.assertTrue(homePage.welcomeUserVisible(), "Welcome user element in header is not visible");
    }

    @Test
    public void buySingleTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());

        ProductPage productPage = homePage.getProducts().get(new Random().nextInt(homePage.getProducts().size())).clickProduct();
        productPage.clickAddToCart();
        CartPage cartPage = productPage.clickCart();
        PlaceOrderMenu placeOrderMenu = cartPage.clickPlaceOrder();

        placeOrderMenu.typeName("george");
        placeOrderMenu.typeCountry("US");
        placeOrderMenu.typeCity("TestyWebVille");
        placeOrderMenu.typeCardNumber("1111-1111-1111-1111");
        placeOrderMenu.typeMonth("03");
        placeOrderMenu.typeYear("2024");
        placeOrderMenu.clickSubmitButton();
        Assert.assertTrue(placeOrderMenu.checkMarkPresent(), "Order confirmation popup did not appear");
    }

    @Test
    public void addAllItemsToCartTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());

        ProductPage productPage = new ProductPage(getDriver());
        int numProducts = homePage.getProducts().size();
        for (int i = 0; i < numProducts; i++){
            ProductItem productItem = homePage.getProducts().get(i);
            productPage = productItem.clickProduct();
            productPage.clickAddToCart();
            homePage = productPage.clickHomeInHeader();
        }
        CartPage cartPage = productPage.clickCart();
        Assert.assertEquals(cartPage.getCartItems().size(), numProducts, "Number of items added does not match number in cart");
    }

    @Test
    public void deleteAllItemsFromCartTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());

        ProductPage productPage = homePage.getProducts().get(new Random().nextInt(homePage.getProducts().size())).clickProduct();
        productPage.clickAddToCart();
        homePage = productPage.clickHomeInHeader();
        productPage = homePage.getProducts().get(new Random().nextInt(homePage.getProducts().size())).clickProduct();
        productPage.clickAddToCart();
        CartPage cartPage = productPage.clickCart();

        int numItems = cartPage.getCartItems().size();
        for (int i = 0; i < numItems; i++){
            CartItem cartItem = cartPage.getCartItems().get(0);
            cartPage = cartItem.clickDeleteButton();
        }
        Assert.assertTrue(cartPage.getCartItems().isEmpty(), "Cart is not empty");
    }

    @Test
    public void PlayVideoTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());

        AboutUsVideo aboutUsVideo = homePage.clickAboutUs();
        aboutUsVideo.clickPlayButton();
        Assert.assertTrue(aboutUsVideo.remainingTimeUpdating(), "Video is not playing");
    }
}
