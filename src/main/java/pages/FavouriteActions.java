package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TestUtil;

public class FavouriteActions {
    WebDriver driver;
    TestUtil helper;

    public FavouriteActions(WebDriver driver) {
        this.driver = driver;
        this.helper = new TestUtil(driver, java.time.Duration.ofSeconds(10));
    }

    // Click heart icon for Google Pixel 4
    public void addGooglePixel4ToFavourites() {
        WebElement favIcon = helper.waitForClickable(FavouriteElements.googlePixel4Favourite);
        favIcon.click();
    }

    // Go to favourites page
    public void openFavouritesPage() {
        WebElement navFav = helper.waitForClickable(FavouriteElements.favouritesNav);
        navFav.click();
    }

    // Verify Google Pixel 4 is present in favourites
    public boolean verifyGooglePixel4Present() {
        WebElement favItem = helper.waitForVisible(FavouriteElements.googlePixel4InFavourites);
        return favItem.isDisplayed();
    }
    
 // Open Offer page
    public void openOfferPage() {
        WebElement offerLink = helper.waitForClickable(FavouriteElements.offerPageLink);
        offerLink.click();
    }

    // Verify Offer page is displayed
    public boolean verifyOfferPageDisplayed() {
        WebElement heading = helper.waitForVisible(FavouriteElements.offerPageHeading);
        return heading.isDisplayed();
    }
    

}
