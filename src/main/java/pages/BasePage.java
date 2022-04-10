package pages;

import blocks.HeaderMenuBlock;
import blocks.MainMenuBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

  private static WebDriver driver;

  // Getter for driver
  public static WebDriver getDriver() {
    return driver;
  }

  // Setter for Driver
  public static void setDriver(WebDriver webDriver) {
    driver = webDriver;
  }

  // Getter for Main menu
  private MainMenuBlock mainMenuBlock = new MainMenuBlock(driver);

  public MainMenuBlock getMainMenuBlock() {
    return mainMenuBlock;
  }

  public WebElement find(By locator) {
    return getDriver().findElement(locator);
  }

  // Getter for Header menu
  private HeaderMenuBlock headerMenuBlock = new HeaderMenuBlock(driver);

  public HeaderMenuBlock getHeaderMenuBlock() {
    return headerMenuBlock;
  }

  // Method for Scroll to element
//    public static void scrollToElement(WebDriver driver, By element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//    }

}