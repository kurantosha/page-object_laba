package pages;

import blocks.WishListBlock;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyWishListPage extends BasePage {

  private By productContainer = By.xpath("//table//tbody//tr");

  public List<WishListBlock> getAllProductsFromWishList() {
    List<WishListBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(productContainer);
    for (WebElement container : containers) {
      WishListBlock wishListBlock = new WishListBlock(container);
      products.add(wishListBlock);
    }
    return products;
  }

  public List<String> getNamesToWishList() {
    List<String> namesProductsWishList = new ArrayList<>();
    List<WishListBlock> products = getAllProductsFromWishList();
    for (WishListBlock product : products) {
      namesProductsWishList.add(product.getProductNameAsString());
    }
    return namesProductsWishList;
  }

}