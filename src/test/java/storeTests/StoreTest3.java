package storeTests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class StoreTest3 extends BaseTest {

  String expectedTitlePage = "My Account";

  @Test
  public void checkThatTitleAppearsOnAccountPageTest() {
    MainPage mainPage = new MainPage();
    String actualTitlePage = mainPage.openMainPage()
        .clickOnMyAccountButton()
        .clickOnLoginButton()
        .loginOnSite("testing12309862@test.com", "111002299338844")
        .getTittleAccountPage();

    Assertions.assertThat(actualTitlePage)
        .as("We are waiting title text on account page: [" + expectedTitlePage
            + "], and received text: [" + actualTitlePage + "]")
        .isEqualTo(expectedTitlePage);
  }
}