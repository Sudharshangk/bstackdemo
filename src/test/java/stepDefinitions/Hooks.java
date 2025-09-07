package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ConfigReader;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();

        String baseUrl = ConfigReader.get("baseUrl");
        if (baseUrl == null || baseUrl.isEmpty()) {
            throw new RuntimeException("Base URL not found in config.properties");
        }

        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
