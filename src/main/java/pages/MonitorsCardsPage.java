package pages;

import blocks.ProductBlock;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

  public MonitorsCardsPage clickOnAddToWishList(String nameProduct) {
    List<ProductBlock> products = getProductsFromMonitorCardPage();
    for (ProductBlock product : products) {
      if (product.getNameAsString().equals(nameProduct)) {
        product.getAddToWishListButton().click();
      }
    }
    return this;
  }
}