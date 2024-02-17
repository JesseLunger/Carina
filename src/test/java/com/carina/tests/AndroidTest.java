package com.carina.tests;

import com.carina.methods.saucedemo.android.pages.*;
import com.carina.methods.saucedemo.commons.components.ScreenHeaderBase;
import com.carina.methods.saucedemo.commons.pages.*;
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
import java.util.HashMap;


public class AndroidTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private HashMap<String, String> itemInfo = new HashMap<>();

    @Test()
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testLogin() {
        LoginScreen loginScreen = new LoginScreen(getDriver());
        loginScreen.typeUsername("standard_user");
        loginScreen.typePassword("secret_sauce");
        ProductScreenBase productScreen = loginScreen.clickLoginButton();
        Assert.assertTrue(productScreen.isOpened(), "ProductScreen did not open");
    }

    @Test(dependsOnMethods = "testLogin")
    @MethodOwner(owner = "jesse Lunger")
    @TestPriority(Priority.P1)
    public void testAddToCartAndVerifyPrice() {
        SoftAssert softAssert = new SoftAssert();
        ProductScreenBase productScreen = initPage(ProductScreenBase.class);

        for (int i = 1; i < 4; i++) {
            String itemName = R.TESTDATA.get("item" + i);
            itemInfo.put(itemName, productScreen.getCost(itemName));
            productScreen.clickCartButton(itemName);

            ProductDetailsScreenBase productDetailsScreenBase = productScreen.clickProductImg(itemName);
            softAssert.assertEquals(productDetailsScreenBase.getPrice(), itemInfo.get(itemName));
            productScreen = productDetailsScreenBase.clickBackToProducts();
        }

        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "testAddToCartAndVerifyPrice")
    @MethodOwner(owner = "jesse Lunger")
    @TestPriority(Priority.P1)
    public void testRemoveFromCartAndVerifyPrice() {
        SoftAssert softAssert = new SoftAssert();
        CartScreenBase cartScreenBase = initPage(ScreenHeaderBase.class).clickCheckoutButton();
        Assert.assertTrue(cartScreenBase.isOpened());
        for (int i = 1; i < 4; i++) {
            String itemName = R.TESTDATA.get("item" + i);
            softAssert.assertEquals(cartScreenBase.getCostByName(itemName), itemInfo.get(itemName), "Price mismatch for product " + itemName);
            cartScreenBase.clickRemoveButton(itemName);
        }
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "testRemoveFromCartAndVerifyPrice")
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testCheckout() {
        CartScreenBase cartScreenBase = initPage(CartScreenBase.class);
        CheckoutScreenBase checkoutScreen = cartScreenBase.clickCheckoutButton();
        checkoutScreen.typeFirstName("test");
        checkoutScreen.typeLastName("guy");
        checkoutScreen.typeZipCode("97555");
        CheckoutOverviewScreenBase checkoutOverviewScreen = checkoutScreen.clickContinueButton();
        Assert.assertTrue(checkoutOverviewScreen.isOpened(), "Checkout overview screen did not open");
        OrderConfirmationScreenBase orderConfirmationScreen = checkoutOverviewScreen.clickFinishButton();
        Assert.assertTrue(orderConfirmationScreen.isOpened(), "Order confirmation screen did not open");
        Assert.assertTrue(orderConfirmationScreen.isThankyouMessagePresent(), "Thank you message not present");
    }

    @Test(dependsOnMethods = "testCheckout")
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testLogout() {
        HamburgerMenuScreenBase hamburgerMenuScreen = initPage(ScreenHeaderBase.class).clickHamburgerButton();
        LoginScreen loginScreen = hamburgerMenuScreen.clickLogoutButton();
        Assert.assertTrue(loginScreen.isOpened(), "Home screen did not open");
    }

}
