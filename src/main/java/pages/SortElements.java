package pages;

import org.openqa.selenium.By;

public class SortElements {
    // Make sure this is public static so other classes can access it as SortElements.sortDropdown
    public static By sortDropdown = By.tagName("select");
    public static By lowestToHighest = By.xpath("//option[@value='lowestprice']");
    public static By highestToLowest = By.xpath("//option[@value='highestprice']");

}
