package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage{
    public AccountCreatedPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//h2[@data-qa='account-created']")
    WebElement txt_accCreated;

    @FindBy(xpath="//div[@class='pull-right']//a")
    WebElement btn_continue;

    public String getTxt_accCreated(){
        return txt_accCreated.getText();
    }
    public void clk_continue(){
        btn_continue.click();
    }
}
