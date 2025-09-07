package pages;

import org.openqa.selenium.By;

public class LogoutElements {
    public static By logoutLink = By.xpath("//span[@id='signin' and text()='Logout']");
    public static By signinVisibleText = By.xpath("//span[@id='signin' and text()='Sign In']");
}
