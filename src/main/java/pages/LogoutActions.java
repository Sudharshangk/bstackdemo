package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.TestUtil;

public class LogoutActions {
    WebDriver driver;
    TestUtil helper;

    public LogoutActions(WebDriver driver) {
        this.driver = driver;
        this.helper = new TestUtil(driver, java.time.Duration.ofSeconds(10));
    }

    public void performLogout() {
        try {
            helper.safeClick(LogoutElements.logoutLink);
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    helper.waitForVisible(LogoutElements.logoutLink));
        }
    }

    public boolean verifySigninVisible() {
        return helper.waitForVisible(LogoutElements.signinVisibleText).isDisplayed();
    }
    
    
    
}
