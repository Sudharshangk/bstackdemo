package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;
import utils.DriverFactory;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();

        if (driver == null) {
            throw new RuntimeException("WebDriver was not initialized!");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        String baseUrl = ConfigReader.get("baseUrl");
        if (baseUrl == null || baseUrl.isEmpty()) {
            throw new RuntimeException("Base URL not found in config.properties");
        }

        driver.get(baseUrl);
    }

    @AfterClass(alwaysRun = true)
    public void tearDownSuite() {
        DriverFactory.quitDriver();        
    }
}
