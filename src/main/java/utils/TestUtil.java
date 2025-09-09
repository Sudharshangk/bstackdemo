package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

public class TestUtil {

    private WebDriver driver;
    private WebDriverWait wait;

    public TestUtil(WebDriver driver, Duration i) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, i);
    }

    // Scroll into view + wait for visibility + click
    public void safeClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    // New robust version with retry logic
    public void safeClickWithRetry(By locator, int maxAttempts) {
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                safeClick(locator);
                return;
            } catch (Exception e) {
                attempts++;
                pause(1); 
            }
        }
        throw new RuntimeException("Failed to click element after " + maxAttempts + " attempts: " + locator);
    }

    // Wait for visibility
    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait until element is clickable
    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Reusable method for react-select dropdowns
    public void selectReactDropdown(By containerLocator, String valueToSelect) {
        safeClick(containerLocator);
        WebElement input = waitForVisible(containerLocator)
                .findElement(By.cssSelector("input[id^='react-select']"));
        input.sendKeys(valueToSelect);
        input.sendKeys(Keys.ENTER);
    }

    // Stable method for react-select dropdowns
    public void selectReactDropdownStable(By inputLocator, String valueToSelect) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(inputLocator));
        input.sendKeys(valueToSelect);
        input.sendKeys(Keys.ENTER);
    }

    // Send keys safely
    public void sendKeys(By locator, String text) {
        WebElement element = waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Wait for element to be invisible
    public static boolean waitForInvisible(WebDriver driver, By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Pause utility method
    public void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
