package blocks;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MyWishListPage;

@Getter
@Setter
@EqualsAndHashCode
public class HeaderMenuBlock {

  private static WebDriver driver;

  private final By wishListHeaderMenuButton = By.id("wishlist-total");

  public HeaderMenuBlock(WebDriver webDriver) {
    driver = webDriver;
  }

  // "Wish List" Button
  public MyWishListPage clickOnWishListMenuButton() {
    driver.findElement(wishListHeaderMenuButton).click();
    return new MyWishListPage();
  }

}