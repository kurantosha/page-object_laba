package blocks;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CamerasCardsPage;
import pages.MainPage;
import pages.MonitorsCardsPage;

@Getter
@Setter
@EqualsAndHashCode
public class MainMenuBlock {

  private static WebDriver driver;
  private static Actions actions;

  private final By componentsTopMenuButton = By.xpath("//a[text()='Components']");
  private final By monitorsTopSubMenuButton = By.xpath("//a[contains(text(),'Monitors')]");
  private final By camerasTopMenuButton = By.xpath(
      "//ul[contains(@class,'navbar-nav')]//a[text()='Cameras']");

  public MainMenuBlock(WebDriver webDriver) {
    driver = webDriver;
    actions = new Actions(driver);
  }

  // Main menu - COMPONENTS button
  public MainPage hoverMouseOverComponentsTopMenuButton() {
    actions.moveToElement(driver.findElement(componentsTopMenuButton)).build().perform();
    return new MainPage();
  }

  // Submenu MONITORS button from COMPONENTS button
  public MonitorsCardsPage clickOnMonitorsTopSubMenuButton() {
    driver.findElement(monitorsTopSubMenuButton).click();
    return new MonitorsCardsPage();
  }

  // Main menu - CAMERAS button
  public CamerasCardsPage clickOnCamerasTopMenuButton() {
    driver.findElement(camerasTopMenuButton).click();
    return new CamerasCardsPage();
  }

}