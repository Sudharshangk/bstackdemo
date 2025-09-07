package pages;

import org.openqa.selenium.By;

public class CartElements {
    // 🔹 Google Filter
    public static By googleFilterCheckbox = By.xpath("//label[span[text()='Google']]");

    // 🔹 Google Products
    public static By pixel4Add = By.xpath("//div[@id='17']//div[@class='shelf-item__buy-btn']");
    public static By pixel3Add = By.xpath("//div[@id='18']//div[@class='shelf-item__buy-btn']");

    // 🔹 Cart Panel
    public static By sideCart = By.cssSelector(".float-cart.float-cart--open");
    public static By addQuantityBtn = By.cssSelector(".float-cart.float-cart--open .shelf-item__price .change-product-button:nth-of-type(2)");
    public static By closeCartIcon = By.cssSelector(".float-cart__close-btn");
}
