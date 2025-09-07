package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.TestUtil;

import java.time.Duration;

public class LoginActions {
    WebDriver driver;
    TestUtil helper;

    public LoginActions(WebDriver driver) {
        this.driver = driver;
        this.helper = new TestUtil(driver, Duration.ofSeconds(10));
    }

    public void openSigninPanel() {
        helper.safeClick(LoginElements.signinLink);
    }

    public void chooseUsername(String uname) {
        helper.selectReactDropdown(LoginElements.usernameFieldContainer, uname);
    }

    public void choosePassword(String pwd) {
        helper.selectReactDropdown(LoginElements.passwordFieldContainer, pwd);
    }

    public void submitLogin() {
        helper.safeClick(LoginElements.submitLoginBtn);
    }

    public boolean verifyOrdersDisplayed() {
        return helper.waitForVisible(LoginElements.ordersTab).isDisplayed();
    }
    public boolean verifyOrdersNotDisplayed() {
        try {
            // This will use default timeout (10s)
            WebElement orders = helper.waitForVisible(By.id("orders"));
            return false; // Element appeared — invalid login failed
        } catch (org.openqa.selenium.TimeoutException e) {
            return true; // Element did NOT appear — expected behavior
        }
    }
}
