package pages;

import org.openqa.selenium.By;

public class SuccessRegistrationPage extends BasePage{

    private final By aboutCreatedAccount = By.xpath("//h1[text()='Your Account Has Been Created!']");

    // get info text about created account
    public String textAccountHasBeenCreated(){
        return find(aboutCreatedAccount).getText();
    }
}