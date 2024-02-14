package com.carina.tests;

import com.carina.methods.SauceDemo.components.Product;
import com.carina.methods.SauceDemo.screens.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
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
        Assert.assertTrue(productScreen.isOpen(), "ProductScreen did not open");
    }

    @Test(dependsOnMethods = "testLogin")
    @MethodOwner(owner = "suiteOwner")
    @TestPriority(Priority.P4)
    public void testAddToCart(){
        ProductScreen productScreen = new ProductScreen(getDriver());
        Product product = productScreen.getProducts().get(0);
        product.clickAddToCartButton();
        product = new ProductScreen(getDriver()).getProducts().get(0);
        Assert.assertTrue(product.hasBeenSelected(), "Product has not been selected");
    }

    @Test(dependsOnMethods = "testAddToCart")
    @MethodOwner(owner = "suiteOwner")
    @TestPriority(Priority.P1)
    public void testItemsInCart(){
        ProductScreen productScreen = new ProductScreen(getDriver());
        CartScreen cartScreen = productScreen.clickCheckoutCartButton();
        Assert.assertTrue((cartScreen.getProductInCart().size() == 1), "Order vs Cart size mismatch");
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
        Assert.assertTrue(checkoutOverviewScreen.isOpen(), "Checkout overview screen did not open");

    }

    @Test(dependsOnMethods = "testCheckout")
    @MethodOwner(owner = "suiteOwner")
    @TestPriority(Priority.P1)
    public void testLogout(){
        CheckoutOverviewScreen checkoutOverviewScreen = new CheckoutOverviewScreen(getDriver());
        HamburgerMenuScreen hamburgerMenuScreen = checkoutOverviewScreen.clickHamburgerMenu();
        LoginScreen loginScreen = hamburgerMenuScreen.clickLogoutButton();
        Assert.assertTrue(loginScreen.isOpen(), "Home screen did not open");
    }
}
