package storeTests;

import blocks.ProductBlock;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MonitorsCardsPage;

import java.util.List;

public class StoreTest4 extends BaseTest {

    @Test
    public void checkThatItemsExistInWishListTest(){
        MainPage mainPage = new MainPage();
        mainPage.openMainPage()
                .clickOnMyAccountButton()
                .clickOnLoginButton()
                .enteredEmailAs("testing12309862@test.com")
                .enteredPasswordAs("111002299338844")
                .clickOnLoginButton()
                .hoverMouseOverComponentsTopMenuButton()
                .clickOnMonitorsTopSubMenuButton()
                .clickOnAddToWishList();

    }



}
