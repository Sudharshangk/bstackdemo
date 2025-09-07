package pages;

import org.openqa.selenium.By;

public class LoginElements {
    public static By signinLink = By.id("signin");
    public static By usernameFieldContainer = By.xpath("//div[contains(@class,'css-1hwfws3')][.//div[text()='Select Username']]");
    public static By passwordFieldContainer = By.xpath("//div[contains(@class,'css-1hwfws3')][.//div[text()='Select Password']]");
    public static By submitLoginBtn = By.cssSelector("button[type='submit']");
    public static By ordersTab = By.id("orders");
}

//login-btn
//signin