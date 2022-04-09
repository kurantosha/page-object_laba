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
public class ProductBlock {

  private WebElement img;
  private WebElement nameAsWebElement;
  private String nameAsString;
  private String description;
  private String price;
  private String priceNew;
  private String priceOld;
  private String priceTax;
  private WebElement addToCartButton;
  private WebElement addToWishListButton;
  private WebElement addCompareProductButton;

  //div[@class='product-thumb']

  public ProductBlock(WebElement container) {
    try {
      this.img = container.findElement(By.xpath(".//div[@class='image']/a"));
    } catch (NoSuchElementException e) {
      this.img = null;
    }

    try {
      this.nameAsWebElement = container.findElement(By.xpath(".//div[@class='caption']//a"));
      this.nameAsString = nameAsWebElement.getText();
    } catch (NoSuchElementException e) {
      this.nameAsWebElement = null;
      this.nameAsString = null;
    }

    try {
      this.description = container.findElement(By.xpath(".//div[@class='caption']//p[1]"))
          .getText();
    } catch (NoSuchElementException e) {
      this.description = null;
    }

    try {
      this.price = StringUtils.substringBefore(
          container.findElement(By.xpath(".//p[@class='price']")).getText().trim(), " ");
    } catch (NoSuchElementException e) {
      this.price = null;
    }

    try {
      this.priceNew = container.findElement(
          By.xpath(".//p[@class='price']//span[@class='price-new']")).getText();
    } catch (NoSuchElementException e) {
      this.priceNew = null;
    }

    try {
      this.priceOld = container.findElement(
          By.xpath(".//p[@class='price']//span[@class='price-old']")).getText();
    } catch (NoSuchElementException e) {
      this.priceOld = null;
    }

    try {
      this.priceTax = container.findElement(
              By.xpath(".//p[@class='price']//span[@class='price-tax']")).getText()
          .replace("Ex Tax: ", "");
    } catch (NoSuchElementException e) {
      this.priceTax = null;
    }

    try {
      this.addToCartButton = container.findElement(
          By.xpath(".//button[contains(@onclick, 'cart.add')]"));
    } catch (NoSuchElementException e) {
      this.addToCartButton = null;
    }

    try {
      this.addToWishListButton = container.findElement(
          By.xpath(".//button[contains(@onclick, 'wishlist.add')]"));
    } catch (NoSuchElementException e) {
      this.addToWishListButton = null;
    }

    try {
      this.addCompareProductButton = container.findElement(
          By.xpath(".//button[contains(@onclick, 'compare.add')]"));
    } catch (NoSuchElementException e) {
      this.addCompareProductButton = null;
    }
  }
}
