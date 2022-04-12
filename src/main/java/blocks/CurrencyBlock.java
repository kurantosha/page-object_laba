package blocks;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CurrencyBlock {

  @Getter
  @Setter
//  @EqualsAndHashCode
  private final By dollarCurrency = By.xpath("//button[@name='USD']");
  private final By euroCurrency = By.xpath("//button[@name='EUR']");
  private final By sterlingCurrency = By.xpath("//button[@name='GBP']");

  private static WebDriver driver;

  private final By currencyList = By.id("wishlist-total");

}
