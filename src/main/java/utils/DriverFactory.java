package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static WebDriver driver;

    // Initialize driver (called from BaseTest or Hooks)
    public static void initDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        }
    }

    // Return current driver
    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver(); // safety check
        }
        return driver;
    }

    // Quit and reset driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
