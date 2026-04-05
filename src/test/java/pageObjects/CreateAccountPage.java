package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage{

    public CreateAccountPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "id_gender2")
    WebElement radio_gender;
    @FindBy(id = "password")
    WebElement txt_pswd;
    @FindBy(id="days")
    WebElement drp_day;
    @FindBy(id="months")
    WebElement drp_month;
    @FindBy(id="years")
    WebElement drp_year;
    @FindBy(xpath = "//input[@id='newsletter']")
    WebElement chk_news;
    @FindBy(xpath = "//b[contains(text(),'Add')]")
    WebElement txt_address;
    @FindBy(xpath = "//input[@id='first_name']")
    WebElement txt_fname;
    @FindBy(xpath = "//input[@id='last_name']")
    WebElement txt_lname;
    @FindBy(xpath = "//input[@id='company']")
    WebElement txt_company;
    @FindBy(xpath = "//input[@id='address1']")
    WebElement txt_add1;
    @FindBy(xpath = "//input[@id='address2']")
    WebElement txt_add2;
    @FindBy(xpath = "//select[@id='country']")
    WebElement drp_country;
    @FindBy(xpath = "//input[@id='state']")
    WebElement txt_state;
    @FindBy(xpath = "//input[@id='city']")
    WebElement txt_city;
    @FindBy(xpath = "//input[@id='zipcode']")
    WebElement txt_zipcode;
    @FindBy(xpath = "//input[@id='mobile_number']")
    WebElement txt_mobile;
    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    WebElement btn_cre_acc;

    public void btn_radio(){
        radio_gender.click();
    }
    public void setTxt_pswd(String p){
        txt_pswd.sendKeys(p);
    }
    public void setBtn_select1(String d){
        Select sc=new Select(drp_day);
        sc.selectByVisibleText(d);
    }
    public void setDrp_month(String m){
        Select sc1=new Select(drp_month);
        sc1.selectByVisibleText(m);
    }
    public void setDrp_year(String y){
        Select sc2=new Select(drp_year);
        sc2.selectByVisibleText(y);
    }
    public void clk_news(){
        chk_news.click();
    }
    public void scroll_Address(){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",txt_address);
    }

    public void setTxt_fname(String fname) {
        txt_fname.sendKeys(fname);
    }

    public void setTxt_lname(String lname) {
        txt_lname.sendKeys(lname);
    }

    public void setTxt_company(String company) {
        txt_company.sendKeys(company);
    }

    public void setTxt_add1(String add1) {
        txt_add1.sendKeys(add1);
    }

    public void setTxt_add2(String add2) {
        txt_add2.sendKeys(add2);
    }

    public void setDrp_country(String country) {
        Select sc = new Select(drp_country);
        sc.selectByVisibleText(country);
    }

    public void setTxt_state(String state) {
        txt_state.sendKeys(state);
    }

    public void setTxt_city(String city) {
        txt_city.sendKeys(city);
    }

    public void setTxt_zipcode(String zipcode) {
        txt_zipcode.sendKeys(zipcode);
    }

    public void setTxt_mobile(String mobile) {
        txt_mobile.sendKeys(mobile);
    }

    public void clk_cre_acc() {
        btn_cre_acc.click();
    }
}
