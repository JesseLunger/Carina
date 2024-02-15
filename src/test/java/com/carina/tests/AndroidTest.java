package com.carina.tests;

import com.carina.methods.SauceDemo.components.Product;
import com.carina.methods.SauceDemo.components.ProductInCart;
import com.carina.methods.SauceDemo.screens.*;
import com.carina.methods.demoblaze.pages.ProductPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;


public class AndroidTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test() 
    @MethodOwner(owner = "suiteOwner")
    @TestPriority(Priority.P1)
    public void testLogin() {
        LoginScreen loginScreen = new LoginScreen(getDriver());
        loginScreen.typeUsername("standard_user");
        loginScreen.typePassword("secret_sauce");
        ProductScreen productScreen = loginScreen.clickLoginButton();
        Assert.assertTrue(productScreen.isOpened(), "ProductScreen did not open");
    }

//    @Test(dependsOnMethods = "testLogin")
    @Test
    @MethodOwner(owner = "suiteOwner")
    @TestPriority(Priority.P4)
    public void testAddToCart(){
        SoftAssert softAssert = new SoftAssert();
        ProductScreen productScreen = new ProductScreen(getDriver());

        Product product1 = productScreen.getProductByName(R.TESTDATA.get("item1"));
        product1.clickAddToCartButton();
        softAssert.assertTrue(product1.removeFromCartButtonIsPresent());

        Product product2 = productScreen.getProductByName(R.TESTDATA.get("item2"));
        product2.clickAddToCartButton();
        softAssert.assertTrue(product2.removeFromCartButtonIsPresent());

        Product product3 = productScreen.getProductByName(R.TESTDATA.get("item3"));
        product3.clickAddToCartButton();
        softAssert.assertTrue(product3.removeFromCartButtonIsPresent());

        softAssert.assertAll("Not all products were selected");
    }

    @Test(dependsOnMethods = "testAddToCart")
    @MethodOwner(owner = "suiteOwner")
    @TestPriority(Priority.P1)
    public void testItemsInCart(){
        SoftAssert softAssert = new SoftAssert();

        ProductScreen productScreen = new ProductScreen(getDriver());
        CartScreen cartScreen = productScreen.clickCheckoutCartButton();

        ProductInCart productInCart = cartScreen.findByProductInCartName(R.TESTDATA.get("item3"));



//        Assert.assertTrue((cartScreen.getProductInCart().size() == 1), "Order vs Cart size mismatch");
    }

    @Test(dependsOnMethods = "testItemsInCart")
    @MethodOwner(owner = "suiteOwner")
    @TestPriority(Priority.P1)
    public void testCheckout(){
        CartScreen cartScreen = new CartScreen(getDriver());
        CheckoutScreen checkoutScreen = cartScreen.clickCheckoutButton();
        checkoutScreen.typeFirstName("test");
        checkoutScreen.typeLastName("guy");
        checkoutScreen.typeZipCode("97555");
        CheckoutOverviewScreen checkoutOverviewScreen = checkoutScreen.clickContinueButton();
        Assert.assertTrue(checkoutOverviewScreen.isOpened(), "Checkout overview screen did not open");

    }

    @Test(dependsOnMethods = "testCheckout")
    @MethodOwner(owner = "suiteOwner")
    @TestPriority(Priority.P1)
    public void testLogout(){
        CheckoutOverviewScreen checkoutOverviewScreen = new CheckoutOverviewScreen(getDriver());
        HamburgerMenuScreen hamburgerMenuScreen = checkoutOverviewScreen.clickHamburgerMenu();
        LoginScreen loginScreen = hamburgerMenuScreen.clickLogoutButton();
        Assert.assertTrue(loginScreen.isOpened(), "Home screen did not open");
    }

    @Test
    public void debugtest(){
        ProductScreen productScreen = new ProductScreen(getDriver());
        Assert.assertTrue(productScreen.isOpened());
    }

}
