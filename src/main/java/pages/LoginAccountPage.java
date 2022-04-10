package pages;

import org.openqa.selenium.By;

public class LoginAccountPage extends BasePage {

  private final By emailInputField = By.id("input-email");
  private final By passwordInputField = By.id("input-password");
  private final By loginButton = By.xpath("//input[@value='Login']");

  // authorisation on site (Login)
  public AccountPage loginOnSite(String email, String password) {
    find(emailInputField).sendKeys(email);
    find(passwordInputField).sendKeys(password);
    find(loginButton).click();
    return new AccountPage();
  }
}