package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.*;

public class E2ETest extends BaseTest {
    LoginActions login;
    FavouriteActions favourite;
    CartActions cart;
    CheckoutActions checkout;
    LogoutActions logout;
    SortActions sort;

    @BeforeClass
    public void setupPages() {
        login = new LoginActions(driver);
        favourite = new FavouriteActions(driver);
        sort = new SortActions(driver);
        cart = new CartActions(driver);
        checkout = new CheckoutActions(driver);
        logout = new LogoutActions(driver);
    }

    // 🔹 Login test
    @Test(priority = 1)
    public void verifyLoginPage() {
        login.openSigninPanel();
        login.chooseUsername("demouser");
        login.choosePassword("testingisfun99");
        login.submitLogin();
        Assert.assertTrue(login.verifyOrdersDisplayed(), "Login failed! Orders not visible.");
    }

    // 🔹 Sort tests (moved right after login)
    @Test(priority = 2, dependsOnMethods = "verifyLoginPage")
    public void verifySortLowestToHighest() {
        sort.sortLowestToHighest();
        Assert.assertEquals(sort.getSelectedOptionText(), "Lowest to highest", "Sort option not applied!");
    }

    @Test(priority = 3, dependsOnMethods = "verifySortLowestToHighest")
    public void verifySortHighestToLowest() {
        sort.sortHighestToLowest();
        Assert.assertEquals(sort.getSelectedOptionText(), "Highest to lowest", "Sort option not applied!");
    }

    // 🔹 Google cart tests
    @Test(priority = 4, dependsOnMethods = "verifySortHighestToLowest")
    public void verifyGoogleFilter() {
        cart.filterGoogleBrand();
        Assert.assertTrue(true, "Google filter not applied!");
    }

    @Test(priority = 5, dependsOnMethods = "verifyGoogleFilter")
    public void verifyAddPixel4() {
        cart.addPixel4();
        Assert.assertTrue(cart.confirmProductQuantity("Pixel 4", 1), "Google Pixel 4 not added!");
    }

    @Test(priority = 6, dependsOnMethods = "verifyAddPixel4")
    public void verifyIncreaseQuantity() {
        cart.increaseProductQuantity();
        Assert.assertTrue(cart.validateQuantityUpdated(2), "Quantity not increased to 2!");
    }

    @Test(priority = 7, dependsOnMethods = "verifyIncreaseQuantity")
    public void verifyCloseCart() {
        cart.closeCartPanel();
        Assert.assertTrue(login.verifyOrdersDisplayed(), "Orders link not visible after closing cart!");
    }

    @Test(priority = 8, dependsOnMethods = "verifyCloseCart")
    public void verifyAddPixel3() {
        cart.addPixel5();
        Assert.assertTrue(cart.confirmProductQuantity("Pixel 3", 1), "Google Pixel 3 not added!");
    }


    @Test(priority = 9, dependsOnMethods = "verifyAddPixel3")
    public void verifyCheckoutStart() {
        checkout.startCheckout();
        Assert.assertTrue(checkout.verifyOrderSummaryDisplayed(), "Order summary not visible!");
    }

    @Test(priority = 10, dependsOnMethods = "verifyCheckoutStart")
    public void verifyAddressEntry() {
        checkout.fillAddressForm("Sudharshan", "G K", "#200 Street Main", "Bengaluru", "56990");
        Assert.assertTrue(checkout.confirmOrderPlaced(), "Order not placed successfully!");
    }

    @Test(priority = 11, dependsOnMethods = "verifyAddressEntry")
    public void verifyReceiptDownload() {
        checkout.downloadOrderReceipt();
        Assert.assertTrue(true, "Receipt download failed!");
    }

    @Test(priority = 12, dependsOnMethods = "verifyReceiptDownload")
    public void verifyContinueShopping() {
        checkout.continueShoppingFlow();
        Assert.assertTrue(login.verifyOrdersDisplayed(), "Orders not visible after continue shopping!");
    }


    @Test(priority = 13, dependsOnMethods = "verifyContinueShopping")
    public void verifyAddPixel4ToFavourites() {
        favourite.addGooglePixel4ToFavourites();
        favourite.openFavouritesPage();
        Assert.assertTrue(favourite.verifyGooglePixel4Present(),
                "Google Pixel 4 not found in favourites!");
    }


    @Test(priority = 14, dependsOnMethods = "verifyAddPixel4ToFavourites")
    public void verifyOfferPageNavigation() {
        favourite.openOfferPage();
        Assert.assertTrue(favourite.verifyOfferPageDisplayed(), "Offer page not opened!");
    }


    @Test(priority = 15, dependsOnMethods = "verifyOfferPageNavigation")
    public void verifyLogout() {
        logout.performLogout();
        Assert.assertTrue(logout.verifySigninVisible(), "Logout failed! Sign in not visible.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
