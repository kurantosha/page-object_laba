package pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage {

  private final By myAccountHeaderMenuButton = By.xpath("//i[contains(@class, 'fa-user')]");
  private final By registerHeaderSubMenuButton = By.xpath("//a[text()='Register']");
  private final By loginHeaderSubMenuButton = By.xpath("//a[text()='Login']");

  // open MAIN page
  public MainPage openMainPage() {
    getDriver().get("https://demo.opencart.com/");
    return this;
  }

  // click on MyAccount button
  public MainPage clickOnMyAccountButton() {
    find(myAccountHeaderMenuButton).click();
    return this;
  }

  // click on REGISTERED button
  public RegisterAccountPage clickOnRegisterButton() {
    find(registerHeaderSubMenuButton).click();
    return new RegisterAccountPage();
  }

  // click on LOGIN button
  public LoginAccountPage clickOnLoginButton() {
    find(loginHeaderSubMenuButton).click();
    return new LoginAccountPage();
  }
}