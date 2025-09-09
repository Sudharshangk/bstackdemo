package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestUtil;

import java.time.Duration;

public class CartActions {
    WebDriver driver;
    TestUtil helper;

    public CartActions(WebDriver driver) {
        this.driver = driver;
        this.helper = new TestUtil(driver, Duration.ofSeconds(10));
    }

    //  Filters
    public void filterGoogleBrand() {
        helper.safeClickWithRetry(CartElements.googleFilterCheckbox, 3);
    }

    //  Google Products
    public void addPixel4() {
        helper.safeClickWithRetry(CartElements.pixel4Add, 3);
    }

    public void addPixel5() {
        helper.safeClickWithRetry(CartElements.pixel3Add, 3);
    }

    // Cart Actions
    public void increaseProductQuantity() {
        helper.waitForVisible(CartElements.sideCart);
        helper.safeClickWithRetry(CartElements.addQuantityBtn, 3);
    }

    public boolean validateQuantityUpdated(int expectedQty) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(driver -> {
                WebElement qtyElement = driver.findElement(
                    By.cssSelector(".float-cart__shelf-container .shelf-item__details p.desc"));
                return qtyElement.getText().contains("Quantity: " + expectedQty);
            });
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void closeCartPanel() {
        helper.safeClickWithRetry(CartElements.closeCartIcon, 3);
    }

    //  Generic product quantity validator
    public boolean confirmProductQuantity(String productName, int expectedQty) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(driver -> {
                WebElement productContainer = driver.findElement(
                    By.xpath("//div[contains(@class,'shelf-item')]//p[@class='title' and contains(text(),'" + productName + "')]/..")
                );
                WebElement qtyElement = productContainer.findElement(By.xpath(".//p[@class='desc']"));
                System.out.println("DEBUG → Product found: " + qtyElement.getText());
                return qtyElement.getText().contains("Quantity: " + expectedQty);
            });
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
