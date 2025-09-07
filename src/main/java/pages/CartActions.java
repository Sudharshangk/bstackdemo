package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TestUtil;

public class CartActions {
    WebDriver driver;
    TestUtil helper;

    public CartActions(WebDriver driver) {
        this.driver = driver;
        this.helper = new TestUtil(driver, java.time.Duration.ofSeconds(10));
    }

    // 🔹 Filters
    public void filterGoogleBrand() {
        helper.safeClick(CartElements.googleFilterCheckbox);
    }

    // 🔹 Google Products
    public void addPixel4() {
        helper.safeClick(CartElements.pixel4Add);
    }

    public void addPixel5() {
        helper.safeClick(CartElements.pixel3Add);
    }

    // 🔹 Cart Actions
    public void increaseProductQuantity() {
        helper.waitForVisible(CartElements.sideCart);
        helper.safeClick(CartElements.addQuantityBtn);
    }

    public boolean validateQuantityUpdated(int expectedQty) {
        try {
            WebElement qtyElement = driver.findElement(
                By.cssSelector(".float-cart__shelf-container .shelf-item__details p.desc"));
            return qtyElement.getText().contains("Quantity: " + expectedQty);
        } catch (Exception e) {
            return false;
        }
    }

    public void closeCartPanel() {
        helper.safeClick(CartElements.closeCartIcon);
    }

    // 🔹 Generic product quantity validator
    public boolean confirmProductQuantity(String productName, int expectedQty) {
        try {
            WebElement productContainer = driver.findElement(
                By.xpath("//div[contains(@class,'shelf-item')]//p[@class='title' and contains(text(),'" + productName + "')]/..")
            );
            WebElement qtyElement = productContainer.findElement(By.xpath(".//p[@class='desc']"));
            System.out.println("DEBUG → Product found: " + qtyElement.getText());
            return qtyElement.getText().contains("Quantity: " + expectedQty);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
