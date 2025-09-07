package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.TestUtil;

import java.time.Duration;

public class SortActions {
    WebDriver driver;
    TestUtil helper;

    public SortActions(WebDriver driver) {
        this.driver = driver;
        this.helper = new TestUtil(driver, Duration.ofSeconds(10));
    }

    public void sortLowestToHighest() {
        WebElement dropdown = helper.waitForVisible(SortElements.sortDropdown);
        new Select(dropdown).selectByValue("lowestprice");
    }

    public void sortHighestToLowest() {
        WebElement dropdown = helper.waitForVisible(SortElements.sortDropdown);
        new Select(dropdown).selectByValue("highestprice");
    }

    public String getSelectedOptionText() {
        WebElement dropdown = helper.waitForVisible(SortElements.sortDropdown);
        return new Select(dropdown).getFirstSelectedOption().getText().trim();
    }
}
