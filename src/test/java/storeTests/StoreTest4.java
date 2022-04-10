package storeTests;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class StoreTest4 extends BaseTest {

  int quantityProductFromWishList = 2;
  String product1 = "Apple Cinema 30\"";
  String product2 = "Samsung SyncMaster 941BW";

  @Test
  public void checkThatItemsExistInWishListTest() {
    MainPage mainPage = new MainPage();
    List<String> namesProductsToWishList = mainPage.openMainPage()
        .clickOnMyAccountButton()
        .clickOnLoginButton()
        .loginOnSite("testing12309862@test.com", "111002299338844")
        .getMainMenuBlock().hoverMouseOverComponentsTopMenuButton()
        .getMainMenuBlock().clickOnMonitorsTopSubMenuButton()
        .clickOnAddToWishList(product1)
        .clickOnAddToWishList(product2)
        .getHeaderMenuBlock().clickOnWishListMenuButton()
        .getNamesToWishList();

    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(namesProductsToWishList.size())
        .as("We are waiting quantity products from Wish list: " + quantityProductFromWishList)
        .isEqualTo(quantityProductFromWishList);

    softAssertions.assertThat(namesProductsToWishList)
        .as("We are waiting names products from Wish list: " + product1 + ", " + product2
            + " but received: " + namesProductsToWishList)
        .containsExactlyInAnyOrder(product1, product2);

    softAssertions.assertAll();
  }

}