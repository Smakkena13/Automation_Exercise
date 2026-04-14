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
    @FindBy(xpath="//div[@class='login-form']//h2")
    WebElement txt_msg1;
    @FindBy(xpath = "(//input[@name='email'])[1]")
    WebElement txt_loginemail;

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement txt_name;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    WebElement txt_email;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement btn_signup;
    @FindBy(xpath = "//b[contains(text(),'Acc')]")
    WebElement txt_acc_heading;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement txt_password;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement btn_login;
    @FindBy(xpath = "//p[contains(text(),'incorrect!')]")
    WebElement txt_incorrect_msg;

    //actions
    public String getIncorrectmsg(){
        return txt_incorrect_msg.getText();
    }
    public String get_txt_msg(){
       return txt_msg.getText();
    }
    public String get_txt_msg1(){
        return txt_msg1.getText();
    }
    public void set_txt_loginemail(String e){
        txt_loginemail.sendKeys(e);
    }
    public void set_txt_password(String p){
        txt_password.sendKeys(p);
    }

    public void set_txt_name(String n){
        txt_name.sendKeys(n);
    }

    public void set_txt_email(String e){
        txt_email.sendKeys(e);
    }
    public void clk_login(){
        btn_login.click();
    }
    public void clk_signup(){
        btn_signup.click();
    }
    public String get_txt_acc(){
        return txt_acc_heading.getText();
    }


}
