package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestUtil;

import java.time.Duration;

public class CheckoutActions {
    WebDriver driver;
    TestUtil helper;

    public CheckoutActions(WebDriver driver) {
        this.driver = driver;
        this.helper = new TestUtil(driver, Duration.ofSeconds(10));
    }

    public void startCheckout() {
        helper.safeClick(CheckoutElements.checkoutNowBtn);
    }

    public boolean verifyOrderSummaryDisplayed() {
        return helper.waitForVisible(CheckoutElements.summaryHeading).isDisplayed();
    }

    public void fillAddressForm(String fname, String lname, String street, String state, String postal) {
        helper.sendKeys(CheckoutElements.firstNameBox, fname);
        helper.sendKeys(CheckoutElements.lastNameBox, lname);
        helper.sendKeys(CheckoutElements.streetBox, street);
        helper.sendKeys(CheckoutElements.provinceBox, state);
        helper.sendKeys(CheckoutElements.postalBox, postal);
        helper.safeClick(CheckoutElements.confirmAddressBtn);
    }

    public boolean confirmOrderPlaced() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
            WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutElements.successMessage));
            return confirm.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void downloadOrderReceipt() {
        helper.safeClick(CheckoutElements.downloadBill);
    }

    public void continueShoppingFlow() {
        helper.safeClick(CheckoutElements.continueBtn);
    }
}
