
package pages;

import org.openqa.selenium.By;

public class FavouriteElements {
    // ✅ Heart (favourite) button inside Google Pixel 4 card (id=17)
    public static By googlePixel4Favourite = By.xpath("//div[@id='17']//button[contains(@class,'MuiIconButton-root')]");

    // ✅ Navbar favourite link
    public static By favouritesNav = By.id("favourites");

    // ✅ Verify Google Pixel 4 inside favourites page
    public static By googlePixel4InFavourites = By.xpath("//div[@id='17']");

 // Offer page link in navbar
    public static By offerPageLink = By.id("offers");

    // Offer page heading (to verify page opened)
    public static By offerPageHeading = By.xpath("//div[text()='Sorry we do not have any promotional offers in your city.']");


}
