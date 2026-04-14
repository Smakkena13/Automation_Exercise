package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    //constructor
    public HomePage(WebDriver driver){
      super(driver);
    }

    //locators
    @FindBy(xpath="//ul[@class='nav navbar-nav']//li[4]//a")
    WebElement lnk_login;
    @FindBy(xpath="//ul[@class='nav navbar-nav']//li[4]//a")
    WebElement lnk_logout;
    @FindBy(xpath="//ul[@class='nav navbar-nav']//li[5]//a")
    WebElement txt_delete_acc;
    @FindBy(xpath="//ul[@class='nav navbar-nav']//li[10]//b")
    WebElement txt_name;

    //acions
    public void clickLogin(){
        lnk_login.click();
    }
    public void clickLogout(){
        lnk_logout.click();
    }
    public boolean getName(){
        return txt_name.isDisplayed();
    }
    public void clickDeleteAcc(){
        txt_delete_acc.click();
    }


}
