package testCases;

import baseTest.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountDeletedPage;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class TC02_ValidLogin extends BaseClass {

    @Test
    public void testValidLogin(){
        log.info("Starting test: Valid Login");
        HomePage hp=new HomePage(driver);
        hp.clickLogin();
        RegisterPage rp=new RegisterPage(driver);
        if(rp.get_txt_msg1().equals("Login to your account")){
            System.out.println("Login page is visible");
            log.info("Login page is visible");
        }else{
            System.out.println("Login page is not visible");
            log.error("Login page is NOT visible");
        }

        rp.set_txt_loginemail("msk13@gmail.com");
        rp.set_txt_password("msk13");
        rp.clk_login();

        if(hp.getName()==true){
            System.out.println("User is logged in");
            log.info("User is logged in successfully");
            hp.clickDeleteAcc();
            AccountDeletedPage adp=new AccountDeletedPage(driver);
            if(adp.getTxt_accDeleted().equals("ACCOUNT DELETED!")) {
                System.out.println("Account deleted successfully");
                Assert.assertTrue(true);
            }else{
                System.out.println("Account deletion failed");
                Assert.fail();
            }

        }else{
            System.out.println("User is not logged in");
            log.error("User failed to log in");
            Assert.assertEquals(hp.getName(), true, "User should be logged in but is not.");
        }


    }
}
