package pages;

import org.openqa.selenium.By;

public class SortElements {
   
    public static By sortDropdown = By.tagName("select");
    public static By lowestToHighest = By.xpath("//option[@value='lowestprice']");
    public static By highestToLowest = By.xpath("//option[@value='highestprice']");

}
