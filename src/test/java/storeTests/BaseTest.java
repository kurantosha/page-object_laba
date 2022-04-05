package storeTests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        BasePage.setDriver(driver);
        BasePage.getDriver().manage().window().maximize();
    }

    Faker faker = new Faker();

    @AfterMethod
    public void closeDriver() {
        BasePage.getDriver().quit();
    }

}
