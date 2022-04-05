package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage {

    private static WebDriver driver;

    private final By componentsTopMenuButton = By.xpath("//a[text()='Components']");
    private final By monitorsTopSubMenuButton = By.xpath("//a[contains(text(),'Monitors')]");


    // Getter for driver
    public static WebDriver getDriver() {
        return driver;
    }

    // Setter for Driver
    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public WebElement find(By locator) {
        return getDriver().findElement(locator);
    }


    // hover mouse over COMPONENTS button
    public MainPage hoverMouseOverComponentsTopMenuButton(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(find(componentsTopMenuButton)).build().perform();
        return new MainPage();
    }

    // click on MONITORS button
    public MonitorsCardsPage clickOnMonitorsTopSubMenuButton(){
        find(monitorsTopSubMenuButton).click();
        return new MonitorsCardsPage();
    }


    // Method for Scroll to element
//    public static void scrollToElement(WebDriver driver, By element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//    }

}