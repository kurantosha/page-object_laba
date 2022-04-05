package StoreTests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class StoreTest2 extends BaseTest{
    String expectedErrorMessage = "First Name must be between 1 and 32 characters!";

    @Test
    public void checkThatMessageWithInvalidCredentialsTest(){
        MainPage mainPage = new MainPage();
        boolean errorMessageForRegistration = mainPage.openMainPage()
                .clickOnMyAccountButton()
                .clickOnRegisterButton()
                .enteredLastNameAs("Bbb")
                .enteredEmailAs("testing12309863@test.com")
                .enteredPhoneAs("380501112233")
                .enteredPasswordAs("111002299338844")
                .enteredPasswordConfirmAs("111002299338844")
//                .registrationAccount();
                .registrationAccount(expectedErrorMessage);

        Assertions.assertThat(errorMessageForRegistration)
                .as("Error message [" + expectedErrorMessage + "] not found")
                .isTrue();
    }
}