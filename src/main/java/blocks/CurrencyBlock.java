package blocks;

import org.openqa.selenium.By;

public class CurrencyBlock {

  private final By dollarCurrency = By.xpath("//button[@name='USD']");
  private final By euroCurrency = By.xpath("//button[@name='EUR']");
  private final By sterlingCurrency = By.xpath("//button[@name='GBP']");

}
