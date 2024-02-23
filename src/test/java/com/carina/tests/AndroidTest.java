package com.carina.tests;

import com.carina.methods.saucedemo.android.utils.AbstractMobileTest;
import com.carina.methods.saucedemo.android.utils.AuthenticationUtil;
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


public class AndroidTest extends AbstractMobileTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner()
    @TestPriority(Priority.P1)
    public void testLogin() {
        ProductScreenBase productScreen = authenticationUtil.logInStandardUser();
        Assert.assertTrue(productScreen.isOpened(), "ProductScreen failed to open");
    }

    @Test()
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P4)
    public void testImageData() {
        ProductScreenBase productScreen = authenticationUtil.logInStandardUser();
        Assert.assertTrue(productScreen.isOpened(), "ProductScreen failed to open");

        ProductScreenBase productScreenBase = initPage(ProductScreenBase.class);
        Assert.assertTrue(productScreenBase.isProductImagePresentByName(R.TESTDATA.get("item1")), "Product page image :" + R.TESTDATA.get("item1") + " is not present");
        ProductDetailsScreenBase productDetailsScreenBase = productScreenBase.clickProductImgByName(R.TESTDATA.get("item1"));
        Assert.assertTrue(productDetailsScreenBase.isProductImagePresent(), "Product details page image :" + R.TESTDATA.get("item1") + " is not present");
        productDetailsScreenBase.clickBackToProducts();
        Assert.assertTrue(productScreenBase.isOpened(), "Products page did not open after being redirected from product detials screen");
    }

    @Test()
    @MethodOwner(owner = "jesse Lunger")
    @TestPriority(Priority.P1)
    public void testAddToCartAndVerifyPrice() {
        SoftAssert softAssert = new SoftAssert();
        HashMap<String, String> itemInfo = new HashMap<>();

        ProductScreenBase productScreen = authenticationUtil.logInStandardUser();
        Assert.assertTrue(productScreen.isOpened(), "ProductScreen failed to open");

        for (int i = 1; i < 4; i++) {
            String itemName = R.TESTDATA.get("item" + i);
            itemInfo.put(itemName, productScreen.getCostByName(itemName));
            productScreen.clickCartButtonByName(itemName);

            ProductDetailsScreenBase productDetailsScreenBase = productScreen.clickProductImgByName(itemName);
            softAssert.assertEquals(productDetailsScreenBase.getPrice(), itemInfo.get(itemName), "Price mismatch product screen vs item description screen for: " + itemName);
            productDetailsScreenBase.clickBackToProducts();
        }

        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "jesse Lunger")
    @TestPriority(Priority.P1)
    public void testRemoveFromCartAndVerifyPrice() {
        SoftAssert softAssert = new SoftAssert();
        HashMap<String, String> itemInfo = new HashMap<>();

        ProductScreenBase productScreen = authenticationUtil.logInStandardUser();
        Assert.assertTrue(productScreen.isOpened(), "ProductScreen failed to open");

        for (int i = 1; i < 4; i++) {
            String itemName = R.TESTDATA.get("item" + i);
            itemInfo.put(itemName, productScreen.getCostByName(itemName));
            productScreen.clickCartButtonByName(itemName);
        }

        CartScreenBase cartScreenBase = initPage(ScreenHeaderBase.class).clickCheckoutButton();
        Assert.assertTrue(cartScreenBase.isOpened());

        for (int i = 1; i < 4; i++) {
            String itemName = R.TESTDATA.get("item" + i);
            softAssert.assertEquals(cartScreenBase.getCostByName(itemName), itemInfo.get(itemName), "Price mismatch: product screen vs cart screen for: " + itemName);
            cartScreenBase.clickRemoveButtonByName(itemName);
        }

        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testCheckout() {
        ProductScreenBase productScreen = authenticationUtil.logInStandardUser();
        Assert.assertTrue(productScreen.isOpened(), "ProductScreen failed to open");

        initPage(ScreenHeaderBase.class).clickCheckoutButton();
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

    @Test()
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testLogout() {
        LoginScreenBase loginScreen = initPage(LoginScreenBase.class);
        Assert.assertTrue(loginScreen.isOpened(), "login screen is not opened");

        ProductScreenBase productScreen = authenticationUtil.logInStandardUser();
        Assert.assertTrue(productScreen.isOpened(), "ProductScreen failed to open");

        HamburgerMenuScreenBase hamburgerMenuScreen = initPage(ScreenHeaderBase.class).clickHamburgerButton();
        hamburgerMenuScreen.clickLogoutButton();
        Assert.assertTrue(loginScreen.isOpened(), "Home screen did not open");
    }
}
