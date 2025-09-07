package pages;

import org.openqa.selenium.By;

public class CheckoutElements {
    public static By checkoutNowBtn = By.cssSelector("div.buy-btn");
    public static By summaryHeading = By.xpath("//h3[text()='Order Summary']");

    public static By firstNameBox = By.id("firstNameInput");
    public static By lastNameBox = By.id("lastNameInput");
    public static By streetBox = By.id("addressLine1Input");
    public static By provinceBox = By.id("provinceInput");
    public static By postalBox = By.id("postCodeInput");
    public static By confirmAddressBtn = By.id("checkout-shipping-continue");

    public static By successMessage = By.id("confirmation-message");

    public static By downloadBill = By.id("downloadpdf");
    public static By continueBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
}
