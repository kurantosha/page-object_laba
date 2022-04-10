package blocks;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
@Setter
@EqualsAndHashCode
public class WishListBlock {

  private WebElement img;
  private WebElement productNameAsWebElement;
  private String productNameAsString;
  private String model;
  private String stock;
  private String unitPrice;
  private WebElement addToCartButton;
  private WebElement removeProduct;

  public WishListBlock(WebElement container) {
    try {
      this.img = container.findElement(By.xpath(".//td[1]"));
    } catch (NoSuchElementException e) {
      this.img = null;
    }

    try {
      this.productNameAsWebElement = container.findElement(By.xpath(".//td[2]"));
      this.productNameAsString = productNameAsWebElement.getText();
    } catch (NoSuchElementException e) {
      this.productNameAsWebElement = null;
      this.productNameAsString = null;
    }

    try {
      this.model = container.findElement(By.xpath(".//td[3]")).getText();
    } catch (NoSuchElementException e) {
      this.model = null;
    }

    try {
      this.stock = container.findElement(By.xpath(".//td[4]")).getText();
    } catch (NoSuchElementException e) {
      this.stock = null;
    }

    try {
      this.unitPrice = StringUtils.substringBefore(
          container.findElement(By.xpath(".//td[5]")).getText().trim(), " ");
    } catch (NoSuchElementException e) {
      this.unitPrice = null;
    }

    try {
      this.addToCartButton = container.findElement(By.xpath(".//td[6]//button"));
    } catch (NoSuchElementException e) {
      this.addToCartButton = null;
    }

    try {
      this.removeProduct = container.findElement(By.xpath(".//td[6]//a"));
    } catch (NoSuchElementException e) {
      this.removeProduct = null;
    }
  }
}