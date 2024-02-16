package com.carina.tests;

import com.carina.methods.SauceDemo.components.ProductComponent;
import com.carina.methods.SauceDemo.components.ProductInCartComponent;
import com.carina.methods.SauceDemo.screens.*;
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
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testLogin() {
        LoginScreen loginScreen = new LoginScreen(getDriver());
        loginScreen.typeUsername("standard_user");
        loginScreen.typePassword("secret_sauce");
        ProductScreen productScreen = loginScreen.clickLoginButton();
        Assert.assertTrue(productScreen.isOpened(), "ProductScreen did not open");
    }

    @Test(dependsOnMethods = "testLogin")
    @MethodOwner(owner = "esse Lunger")
    @TestPriority(Priority.P4)
    public void testAddToCart() {
        SoftAssert softAssert = new SoftAssert();
        ProductScreen productScreen = new ProductScreen(getDriver());

        ProductComponent productComponent1 = productScreen.getProductByName(R.TESTDATA.get("item1"));
        productComponent1.clickAddToCartButton();
        softAssert.assertTrue(productComponent1.isRemoveFromCartButtonIsPresent());

        ProductComponent productComponent2 = productScreen.getProductByName(R.TESTDATA.get("item2"));
        productComponent2.clickAddToCartButton();
        softAssert.assertTrue(productComponent2.isRemoveFromCartButtonIsPresent());

        ProductComponent productComponent3 = productScreen.getProductByName(R.TESTDATA.get("item3"));
        productComponent3.clickAddToCartButton();
        softAssert.assertTrue(productComponent3.isRemoveFromCartButtonIsPresent());
        softAssert.assertAll("Not all products were selected");
    }

    @Test(dependsOnMethods = "testAddToCart")
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testItemsToCart() {
        CartScreen cartScreen = new CartScreen(getDriver());
        cartScreen.clickCheckoutHeaderButton();
        ProductInCartComponent productInCartComponent1 = cartScreen.findByProductInCartName(R.TESTDATA.get("item3"));
        productInCartComponent1.clickRemoveButton();
        Assert.assertFalse(productInCartComponent1.isPresent());
    }

    @Test(dependsOnMethods = "testItemsToCart")
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testCheckout() {
        CartScreen cartScreen = new CartScreen(getDriver());
        CheckoutScreen checkoutScreen = cartScreen.clickCheckoutButton();
        checkoutScreen.typeFirstName("test");
        checkoutScreen.typeLastName("guy");
        checkoutScreen.typeZipCode("97555");
        CheckoutOverviewScreen checkoutOverviewScreen = checkoutScreen.clickContinueButton();
        Assert.assertTrue(checkoutOverviewScreen.isOpened(), "Checkout overview screen did not open");
        OrderConfirmationScreen orderConfirmationScreen = checkoutOverviewScreen.clickFinishButton();
        Assert.assertTrue(orderConfirmationScreen.isOpened(), "Order confirmation screen did not open");
    }

    @Test(dependsOnMethods = "testCheckout")
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testLogout() {
        OrderConfirmationScreen orderConfirmationScreen = new OrderConfirmationScreen(getDriver());
        HamburgerMenuScreen hamburgerMenuScreen = orderConfirmationScreen.clickHamburgerMenu();
        LoginScreen loginScreen = hamburgerMenuScreen.clickLogoutButton();
        Assert.assertTrue(loginScreen.isOpened(), "Home screen did not open");
    }


//    @Test
//    public void debugTest(){
//        CheckoutOverviewScreen checkoutOverviewScreen = new CheckoutOverviewScreen(getDriver());
//
//    }
}
