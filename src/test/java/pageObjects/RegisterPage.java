package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    //constructor
    public RegisterPage(WebDriver driver){
        super(driver);
    }

    //locators
    @FindBy(xpath="//div[@class='signup-form']//h2")
    WebElement txt_msg;

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement txt_name;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    WebElement txt_email;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement btn_signup;
    @FindBy(xpath = "//b[contains(text(),'Acc')]")
    WebElement txt_acc_heading;

    //actions
    public String get_txt_msg(){
       return txt_msg.getText();
    }

    public void set_txt_name(String n){
        txt_name.sendKeys(n);
    }

    public void set_txt_email(String e){
        txt_email.sendKeys(e);
    }

    public void clk_signup(){
        btn_signup.click();
    }
    public String get_txt_acc(){
        return txt_acc_heading.getText();
    }


}
