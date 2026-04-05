package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDeletedPage extends BasePage{
    public AccountDeletedPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//h2[@data-qa='account-deleted']")
    WebElement txt_accDeleted;

    @FindBy(xpath="//div[@class='pull-right']//a")
    WebElement btn_continue;

    public String getTxt_accDeleted(){
        return txt_accDeleted.getText();
    }
    public void clk_continue(){
        btn_continue.click();
    }
}
