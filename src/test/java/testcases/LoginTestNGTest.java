package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import pages.LoginActions;

public class LoginTestNGTest {
    WebDriver driver;
    LoginActions login;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get("https://bstackdemo.com/signin");  // 👈 Replace with your actual app URL
        login = new LoginActions(driver);
    }

    @Test
    public void testValidLogin() {
        login.openSigninPanel();
        login.chooseUsername("demouser");
        login.choosePassword("testingisfun99");
        login.submitLogin();
        Assert.assertTrue(login.verifyOrdersDisplayed(), "Orders tab not visible after valid login!");
    }

    @Test
    public void testInvalidLogin() {
        login.openSigninPanel();
        login.chooseUsername("wrong");
        login.choosePassword("wrong");
        login.submitLogin();
        Assert.assertFalse(login.verifyOrdersDisplayed(), "Orders should not be visible for invalid login!");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
