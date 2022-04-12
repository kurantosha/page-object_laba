package storeTests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class StoreTest1 extends BaseTest {

  String expectedResultText = "Your Account Has Been Created!";
  String password = faker.internet().password();

  @Test
  public void checkThatMessageWithValidCredentialsTest() {
    MainPage mainPage = new MainPage();
    String actualResultText = mainPage.openMainPage()
        .clickOnMyAccountButton()
        .clickOnRegisterButton()
        .enteredFirstNameAs(faker.name().firstName())
        .enteredLastNameAs(faker.name().lastName())
        .enteredEmailAs(faker.internet().emailAddress())
        .enteredPhoneAs(faker.phoneNumber().cellPhone())
        .enteredPasswordAs(password)
        .enteredPasswordConfirmAs(password)
        .clickPolicyCheckbox()
        .clickRegistrationAccountButton()
        .getTextAccountHasBeenCreated();

    Assertions.assertThat(actualResultText)
        .as("We are waiting for the text: [" + expectedResultText + "], and received text: ["
            + actualResultText + "]")
        .isEqualTo(expectedResultText);
  }
}