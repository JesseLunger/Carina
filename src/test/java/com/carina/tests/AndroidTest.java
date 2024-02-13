package com.carina.tests;

import com.carina.methods.SauceDemo.components.Product;
import com.carina.methods.SauceDemo.screens.*;
import com.carina.methods.mobile.gui.demoblaze.pages.ProductPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.checkerframework.checker.units.qual.C;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.invoke.MethodHandles;


public class AndroidTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "suiteOwner")
    @TestPriority(Priority.P2)
    public void testLogin() {
        HomeScreen homeScreen = new HomeScreen(getDriver());
        homeScreen.typeUsername("standard_user");
        homeScreen.typePassword("secret_sauce");
        ProductScreen productScreen = homeScreen.clickLoginButton();
        Assert.assertTrue(productScreen.isOpen());

    }

    @Test
    @MethodOwner(owner = "suiteOwner")
    @TestPriority(Priority.P2)
    public void testAddToCart(){
        ProductScreen productScreen = new ProductScreen(getDriver());

        for (Product product : productScreen.getProducts()) {
            product.clickAddToCartButton();
        }


    }



//        CartScreen cartScreen = productScreen.clickCheckoutCartButton();
////        CartScreen cartScreen = new CartScreen(getDriver());
//        cartScreen.getProductInCart().get(0).clickRemoveButton();
//        CheckoutScreen checkoutScreen = cartScreen.clickCheckoutButton();
//        checkoutScreen.typeFirstName("test");
//        checkoutScreen.typeLastName("guy");
//        checkoutScreen.typeZipCode("97555");
//        CheckoutOverviewScreen checkoutOverviewScreen = checkoutScreen.clickContinueButton();
//        OrderConfirmationScreen orderConfirmationScreen = checkoutOverviewScreen.clickFinishButton();
//        orderConfirmationScreen.clickBackToHomeButton();





}
