package testCases;

import baseTest.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class TC04_LogoutUser extends BaseClass {
    @Test
    public void testLogout() {
        HomePage hp = new HomePage(driver);
        hp.clickLogin();
        RegisterPage rp = new RegisterPage(driver);
        if (rp.get_txt_msg1().equalsIgnoreCase("Login to your account")) {
            rp.set_txt_loginemail("msk13@gmail.com");
            rp.set_txt_password("msk13");
            rp.clk_login();
            try{
                boolean msg=hp.getName();
                if(msg==true){
                    hp.clickLogout();
                    if(driver.getTitle().equalsIgnoreCase("Automation Exercise - Signup / Login")){
                        Assert.assertTrue(true);
                    }else{
                        System.out.println("not on login page");
                        Assert.fail();
                    }
                }else{
                    System.out.println("logged in as username not visible");
                    Assert.fail();
                }
            }catch(Exception e){
                System.out.println("message: "+e.getMessage());
                Assert.fail();
            }
        }else{
            System.out.println("not in login page");
            Assert.assertEquals(rp.get_txt_msg1(),"Login to your account");
            Assert.fail();
        }
    }
}
