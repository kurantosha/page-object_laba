package pages;

import blocks.ProductBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MonitorsCardsPage extends BasePage {

  private By productContainer = By.xpath("//div[@class='product-thumb']");

  public List<ProductBlock> getProductsFromMonitorCardPage() {
    List<ProductBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(productContainer);
    for (WebElement container : containers) {
      ProductBlock productBlock = new ProductBlock(container);
      products.add(productBlock);
    }
    return products;
  }

  public MonitorsCardsPage clickOnAddToWishList() {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
    List<ProductBlock> products = getProductsFromMonitorCardPage();
    products.get(0).getAddToWishListButton().click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(productContainer));
    products.get(1).getAddToWishListButton().click();

    return this;
  }

}

//    for (ProductBlock product : products) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(productContainer));
//        product.getAddToWishListButton().click();
//        }


