package pages;

import org.openqa.selenium.By;

public class LoginAccountPage extends BasePage {
    private final By emailInputField = By.id("input-email");
    private final By passwordInputField = By.id("input-password");
    private final By loginButton = By.xpath("//input[@value='Login']");

    // Enter email for login form
    public LoginAccountPage enteredEmailAs(String email) {
        find(emailInputField).sendKeys(email);
        return this;
    }

    // Enter password for login form
     public LoginAccountPage enteredPasswordAs(String password) {
        find(passwordInputField).sendKeys(password);
        return this;
    }

    // click on LOGIN button
    public AccountPage clickOnLoginButton(){
        find(loginButton).click();
        return new AccountPage();
    }
}