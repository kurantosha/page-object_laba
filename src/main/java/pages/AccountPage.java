package pages;

import org.openqa.selenium.By;

public class AccountPage extends BasePage{
    private final By accountTitle = By.xpath("//h2[text()='My Account']");


    // get Title on Account page
    public String tittleAccountPage()
    {
        return find(accountTitle).getText();
    }

}
