package StoreTests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class StoreTest1 extends BaseTest {
    String expectedResultText = "Your Account Has Been Created!";

    @Test
    public void checkThatMessageWithValidCredentialsTest() {
        MainPage mainPage = new MainPage();
        String actualResultText = mainPage.openMainPage()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .enteredFirstNameAs("Aaaa")
                .enteredLastNameAs("Bbb")
                .enteredEmailAs("testing12309862@test.com")
                .enteredPhoneAs("380501112233")
                .enteredPasswordAs("111002299338844")
                .enteredPasswordConfirmAs("111002299338844")
                .registrationAccount()
                .textAccountHasBeenCreated();

        Assertions.assertThat(actualResultText)
                .as("We are waiting for the text: [" + expectedResultText + "], and received text: [" + actualResultText + "]")
                .isEqualTo(expectedResultText);
    }
}