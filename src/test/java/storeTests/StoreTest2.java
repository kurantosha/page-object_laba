package storeTests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class StoreTest2 extends BaseTest {

  String expectedErrorMessage = "First Name must be between 1 and 32 characters!";
  String password = faker.internet().password();

  @Test
  public void checkThatMessageWithInvalidCredentialsTest() {
    MainPage mainPage = new MainPage();
    String actualErrorMessage = mainPage.openMainPage()
        .clickOnMyAccountButton()
        .clickOnRegisterButton()
        .enteredLastNameAs(faker.name().lastName())
        .enteredEmailAs(faker.internet().emailAddress())
        .enteredPhoneAs(faker.phoneNumber().phoneNumber())
        .enteredPasswordAs(password)
        .enteredPasswordConfirmAs(password)
        .registrationAccount(expectedErrorMessage);

    Assertions.assertThat(actualErrorMessage)
        .as("We are waiting error message: [" + expectedErrorMessage + "], and received text: ["
            + actualErrorMessage + "]")
        .isEqualTo(expectedErrorMessage);
  }
}