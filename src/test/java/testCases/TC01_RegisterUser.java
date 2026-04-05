package testCases;

import baseTest.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class TC01_RegisterUser extends BaseClass{

    @Test(priority = 1,groups = {"regression"})
    void testRegister(){
        HomePage hp=new HomePage(driver);
        hp.clickLogin();

        RegisterPage rp=new RegisterPage(driver);
        String msg=rp.get_txt_msg();
        if(msg.equalsIgnoreCase("New User Signup!")){
            System.out.println("on register page!");

            rp.set_txt_name(randomAlphabetic());
            rp.set_txt_email(randomAlpNum()+"@gmail.com");
            rp.clk_signup();
            String a_msg = rp.get_txt_acc();
            if (a_msg.equalsIgnoreCase("ENTER ACCOUNT INFORMATION")) {
                System.out.println("on create account page!");
                Assert.assertTrue(true);
            }
             else{
                System.out.println("not on create account page!");
                Assert.assertTrue(false);
            }
        }else{
            System.out.println("on register page!");
            Assert.fail();
        }

    }
    @Test(priority = 2,dependsOnMethods={"testRegister"},groups = {"regression"})
    void testRegisterDetails() {
        CreateAccountPage ca = new CreateAccountPage(driver);
            ca.btn_radio();
            ca.setTxt_pswd("msk13");
            ca.setBtn_select1("12");
            ca.setDrp_month("May");
            ca.setDrp_year("2002");
            ca.clk_news();
            ca.scroll_Address();
            ca.setTxt_fname("makkena");
            ca.setTxt_lname("sk");
            ca.setTxt_company("abc");
            ca.setTxt_add1("hyd");
            ca.setTxt_add2("hyd");
            ca.setDrp_country("India");
            ca.setTxt_state("Telangana");
            ca.setTxt_city("Hyderabad");
            ca.setTxt_zipcode("500068");
            ca.setTxt_mobile(randomNumeric());
            ca.clk_cre_acc();
            Assert.assertTrue(true);

    }

    @Test(priority = 3,dependsOnMethods={"testRegisterDetails"})
    void testAccCreated(){
        AccountCreatedPage acp=new AccountCreatedPage(driver);
        String msg=acp.getTxt_accCreated();
        if(msg.equalsIgnoreCase("ACCOUNT CREATED!")) {
            System.out.println("account created successfully!");
            acp.clk_continue();
            Assert.assertTrue(true);
        }else{
            System.out.println("account creation failed!");
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 4,dependsOnMethods = {"testAccCreated"})
    void testDeleteAcc(){
        HomePage hp=new HomePage(driver);
        if(hp.getName()==true) {
            hp.clickDeleteAcc();
            AccountDeletedPage adp = new AccountDeletedPage(driver);
            String msg = adp.getTxt_accDeleted();
            if (msg.equalsIgnoreCase("ACCOUNT DELETED!")) {
                System.out.println("account deleted successfully!");
                adp.clk_continue();
                Assert.assertTrue(true);
            } else {
                System.out.println("account deletion failed!");
                Assert.fail();
            }
        }
    }


}
