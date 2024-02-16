package com.carina.tests;

import com.carina.methods.demoblaze.components.CartItem;
import com.carina.methods.demoblaze.components.ProductItem;
import com.carina.methods.demoblaze.pages.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class WebTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testSignIn() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page could not be opened");

        LoginMenuPage loginMenuPage = homePage.clickSignInHeader();
        loginMenuPage.typeUsername(R.TESTDATA.get("user_name"));
        loginMenuPage.typePassword(R.TESTDATA.get("password"));
        homePage = loginMenuPage.clickLogInButton();
        Assert.assertEquals("Welcome " + R.TESTDATA.get("user_name"), homePage.getUserName(), "Welcome user element in header is not visible");
    }

    @Test
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testBuySingle() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page could not be opened");
        int randomIndex = new Random().nextInt(homePage.getProducts().size());
        ProductPage productPage = homePage.getProducts().get(randomIndex).clickProduct();
        productPage.clickAddToCart();
        CartPage cartPage = productPage.clickCart();
        PlaceOrderFromPage placeOrderFromPage = cartPage.clickPlaceOrder();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        placeOrderFromPage.typeName("george");
        placeOrderFromPage.typeCountry("US");
        placeOrderFromPage.typeCity("TestyWebVille");
        placeOrderFromPage.typeCardNumber("1111-1111-1111-1111");
        placeOrderFromPage.typeMonth("03");
        placeOrderFromPage.typeYear("2024");
        OrderConfrimationPage orderConfrimationPage = placeOrderFromPage.clickSubmitButton();
        Assert.assertTrue(orderConfrimationPage.isCheckMarkPresent(), "Order confirmation popup did not appear");
    }

    @Test
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testAddAllItemsToCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page could not be opened");

        ProductPage productPage = new ProductPage(getDriver());
        int numProducts = homePage.getProducts().size();
        for (int i = 0; i < numProducts; i++) {
            ProductItem productItem = homePage.getProducts().get(i);
            System.out.println(homePage.getProducts().get(i).getProductName());
            productPage = productItem.clickProduct();
            productPage.clickAddToCart();
            homePage = productPage.clickHomeInHeader();
        }
        CartPage cartPage = productPage.clickCart();
        String prev = "prev";
        String next = "next";
        while (!prev.equals(next)) {
            prev = cartPage.getTotal();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            next = cartPage.getTotal();
        }
        SoftAssert softAssert = new SoftAssert();
        for (ProductItem productItem : homePage.getProducts()) {
            CartItem item = cartPage.getCartItemByName(productItem.getProductName());
            softAssert.assertNotNull(item, "Item: " + productItem.getProductName() + " missing from cart");
        }
        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testDeleteAllItemsFromCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page could not be opened");
        int randomIndex = new Random().nextInt(homePage.getProducts().size());
        ProductPage productPage = homePage.getProducts().get(randomIndex).clickProduct();
        productPage.clickAddToCart();
        homePage = productPage.clickHomeInHeader();
        randomIndex = new Random().nextInt(homePage.getProducts().size());
        productPage = homePage.getProducts().get(randomIndex).clickProduct();
        productPage.clickAddToCart();
        CartPage cartPage = productPage.clickCart();

        int numItems = cartPage.getCartItems().size();
        for (int i = 0; i < numItems; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            CartItem cartItem = cartPage.getCartItems().get(0);
            cartPage = cartItem.clickDeleteButton();
        }
        Assert.assertTrue(cartPage.getCartItems().isEmpty(), "Cart is not empty");
    }

    @Test
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testPlayVideo() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page could not be opened");

        AboutUsVideoPage aboutUsVideoPage = homePage.clickAboutUs();
        aboutUsVideoPage.clickPlayButton();
        String initRemainingTime = aboutUsVideoPage.getRemainingVideoPlayTime();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        String currentRemainingTime = aboutUsVideoPage.getRemainingVideoPlayTime();
        Assert.assertFalse(currentRemainingTime.equals(initRemainingTime), "Video is not playing");
    }
}
