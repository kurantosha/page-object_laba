package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RegisterAccountPage extends BasePage {

  private final By firstNameInput = By.id("input-firstname");
  private final By lastNameInput = By.id("input-lastname");
  private final By emailInput = By.id("input-email");
  private final By phoneInput = By.id("input-telephone");
  private final By passwordInput = By.id("input-password");
  private final By privacyPolicyCheckbox = By.xpath("//input[@type='checkbox']");
  private final By passwordConfirmInput = By.id("input-confirm");
  private final By continueButton = By.xpath("//input[@type='submit']");
  private final By errorMessageRegistrationField = By.xpath("//div[@class='text-danger']");

  // Method for input FirstName
  public RegisterAccountPage enteredFirstNameAs(String firstName) {
    find(firstNameInput).sendKeys(firstName);
    return this;
  }

  // Method for input LastName
  public RegisterAccountPage enteredLastNameAs(String lastName) {
    find(lastNameInput).sendKeys(lastName);
    return this;
  }

  // Method for input Email
  public RegisterAccountPage enteredEmailAs(String email) {
    find(emailInput).sendKeys(email);
    return this;
  }

  // Method for input Phone
  public RegisterAccountPage enteredPhoneAs(String phone) {
    find(phoneInput).sendKeys(phone);
    return this;
  }

  // Method for input Password
  public RegisterAccountPage enteredPasswordAs(String password) {
    find(passwordInput).sendKeys(password);
    return this;
  }

  // Method for input PasswordConfirm
  public RegisterAccountPage enteredPasswordConfirmAs(String passwordConfirm) {
    find(passwordConfirmInput).sendKeys(passwordConfirm);
    return this;
  }

  // Method for click on RegistrationButton with valid data
  public SuccessRegistrationPage registrationAccount() {
    find(privacyPolicyCheckbox).click();
    find(continueButton).click();
    return new SuccessRegistrationPage();
  }

  // Method for click on RegistrationButton with invalid data
  public String registrationAccount(String errorMessage) {
    find(privacyPolicyCheckbox).click();
    find(continueButton).click();
    // find error message
    List<WebElement> elements = getDriver().findElements(errorMessageRegistrationField);
    List<String> errors = new ArrayList();
    for (WebElement element : elements) {
      String error = element.getText();
      if (!error.equals(errorMessage)) {
        errors.add(error);
      } else {
        return errorMessage;
      }
    }
    return String.valueOf(errors);
  }

}