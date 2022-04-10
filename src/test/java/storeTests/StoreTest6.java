package storeTests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.CamerasCardsPage;
import pages.MainPage;

public class StoreTest6 extends BaseTest {

  String product1 = "Canon EOS 5D";
  String product2 = "Nikon D300";
  int expectedQuantityProductFromPage = 2;
  double expectedOldPriceProduct = 122.00;
  double expectedNewPriceProduct = 98.00;
  double expectedExPriceProduct = 80.00;

  @Test
  public void checkThatCorrectnessAllPricesOfProductTest() {
    MainPage mainPage = new MainPage();
    int actualQuantityProductFromPage = mainPage.openMainPage()
        .getMainMenuBlock().clickOnCamerasTopMenuButton()
        .getProductsFromCamerasCardPage().size();

    CamerasCardsPage camerasCardsPage = new CamerasCardsPage();
    double actualOldPriceProduct = camerasCardsPage.getOldPriceProduct(product1);
    double actualNewPriceProduct = camerasCardsPage.getNewPriceProduct(product1);
    double actualExPriceProduct = camerasCardsPage.getExPriceProduct(product2);

    // Quantity Products From Page
    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(actualQuantityProductFromPage)
        .as("We are waiting quantity products: [" + expectedQuantityProductFromPage
            + "], and received: [" + actualQuantityProductFromPage + "]")
        .isEqualTo(expectedQuantityProductFromPage);

    // check the old Price Product
    softAssertions.assertThat(actualOldPriceProduct)
        .as("We are waiting old product price: [" + expectedOldPriceProduct + "], and received: ["
            + actualOldPriceProduct + "]")
        .isEqualTo(expectedOldPriceProduct);

    // check the new Price Product
    softAssertions.assertThat(actualNewPriceProduct)
        .as("We are waiting new product price: [" + expectedNewPriceProduct + "], and received: ["
            + actualNewPriceProduct + "]")
        .isEqualTo(expectedNewPriceProduct);

// check the Ex Price Product
    softAssertions.assertThat(actualExPriceProduct)
        .as("We are waiting Ex tax product price: [" + expectedExPriceProduct + "], and received: ["
            + actualExPriceProduct + "]")
        .isEqualTo(expectedExPriceProduct);

    softAssertions.assertAll();
  }
}