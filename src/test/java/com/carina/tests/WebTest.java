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

import java.util.ArrayList;
import java.util.Random;

public class WebTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testSignIn() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page could not be opened");

        LoginMenuPage loginMenuPage = homePage.getHeader().clickSignInLink();
        loginMenuPage.typeUsername(R.TESTDATA.get("user_name"));
        loginMenuPage.typePassword(R.TESTDATA.get("password"));
        homePage = loginMenuPage.clickLogInButton();
        Assert.assertTrue(homePage.isPageOpened(), "Home page could not be opened");
        Assert.assertEquals("Welcome " + R.TESTDATA.get("user_name"), homePage.getHeader().getUserName(), "Welcome user element in header is not visible");
    }

    @Test
    @MethodOwner(owner = "Jesse Lunger" )
    @TestPriority(Priority.P1)
    public void testBuySingle() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page could not be opened");
        int randomIndex = new Random().nextInt(homePage.getProducts().size());
        ProductPage productPage = homePage.getProducts().get(randomIndex).clickProduct();
        Assert.assertTrue(productPage.isPageOpened(), "Products page could not be opened");
        productPage.clickAddToCartButton();
        CartPage cartPage = productPage.getHeader().clickCartLink();
        PlaceOrderFormPage placeOrderFormPage = cartPage.clickPlaceOrder();
        Assert.assertTrue(placeOrderFormPage.isPageOpened(), "Order form could not be opened");

        placeOrderFormPage.typeName("george");
        placeOrderFormPage.typeCountry("US");
        placeOrderFormPage.typeCity("TestyWebVille");
        placeOrderFormPage.typeCardNumber("1111-1111-1111-1111");
        placeOrderFormPage.typeMonth("03");
        placeOrderFormPage.typeYear("2024");
        OrderConfrimationPage orderConfrimationPage = placeOrderFormPage.clickSubmitButton();
        Assert.assertTrue(orderConfrimationPage.isCheckMarkPresent(), "Order confirmation popup did not appear");
    }

    @Test
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testAddAllItemsToCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page could not be opened");

        ArrayList<String> productNames = new ArrayList<>();

        ProductPage productPage = null;
        int numProducts = homePage.getProducts().size();
        for (int i = 0; i < numProducts; i++) {
            ProductItem productItem = homePage.getProducts().get(i);
            productNames.add(productItem.getProductName());
            System.out.println(homePage.getProducts().get(i).getProductName());
            productPage = productItem.clickProduct();
            productPage.clickAddToCartButton();
            homePage = productPage.getHeader().clickHomeLink();
        }
        Assert.assertTrue(productPage != null, "No Products were found");
        CartPage cartPage = productPage.getHeader().clickCartLink();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page could not be opened");

        pause(3);

        SoftAssert softAssert = new SoftAssert();
        for (String productName : productNames) {
            CartItem item = cartPage.getCartItemByName(productName);
            softAssert.assertNotNull(item, "Item: " + productName + " missing from cart");
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
        productPage.clickAddToCartButton();
        homePage = productPage.getHeader().clickHomeLink();
        randomIndex = new Random().nextInt(homePage.getProducts().size());
        productPage = homePage.getProducts().get(randomIndex).clickProduct();
        productPage.clickAddToCartButton();
        CartPage cartPage = productPage.getHeader().clickCartLink();

        int numItems = cartPage.getCartItems().size();
        for (int i = 0; i < numItems; i++) {
            CartItem cartItem = cartPage.getCartItems().get(0);
            cartPage = cartItem.clickDeleteButton();
            Assert.assertTrue(cartPage.isPageOpened(), "Cart page did not open");
            pause(1);
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

        AboutUsVideoPage aboutUsVideoPage = homePage.getHeader().clickAboutUsLink();
        aboutUsVideoPage.clickPlayButton();
        String initRemainingTime = aboutUsVideoPage.getRemainingVideoPlayTime();
        pause(2);
        String currentRemainingTime = aboutUsVideoPage.getRemainingVideoPlayTime();
        Assert.assertFalse(currentRemainingTime.equals(initRemainingTime), "Video is not playing");
    }
}
