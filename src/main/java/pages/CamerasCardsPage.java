package pages;

import blocks.ProductBlock;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CamerasCardsPage extends BasePage {

  private By productContainer = By.xpath("//div[@class='product-thumb']");

  public List<ProductBlock> getProductsFromCamerasCardPage() {
    List<ProductBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(productContainer);
    for (WebElement container : containers) {
      ProductBlock productBlock = new ProductBlock(container);
      products.add(productBlock);
    }
    return products;
  }

  public double getOldPriceProduct(String nameProduct) {
    List<ProductBlock> products = getProductsFromCamerasCardPage();
    for (ProductBlock product : products) {
      if (product.getNameAsString().equals(nameProduct)) {
        String oldPrice = product.getPriceOld().substring(1);
        return Double.parseDouble(oldPrice);
      }
    }
    return 0;
  }

  public double getNewPriceProduct(String nameProduct) {
    List<ProductBlock> products = getProductsFromCamerasCardPage();
    for (ProductBlock product : products) {
      if (product.getNameAsString().equals(nameProduct)) {
        String newPrice = product.getPriceNew().substring(1);
        return Double.parseDouble(newPrice);
      }
    }
    return 0;
  }

  public double getExPriceProduct(String nameProduct) {
    List<ProductBlock> products = getProductsFromCamerasCardPage();
    for (ProductBlock product : products) {
      if (product.getNameAsString().equals(nameProduct)) {
        String exPrice = product.getPriceTax().substring(1);
        return Double.parseDouble(exPrice);
      }
    }
    return 0;
  }
}