package testCases;

import baseTest.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class TC03_InvalidLogin extends BaseClass {
    @Test
    public void testInvalidLogin() {
        HomePage hp = new HomePage(driver);
        hp.clickLogin();
        RegisterPage rp=new RegisterPage(driver);
        if(rp.get_txt_msg1().equalsIgnoreCase("Login to your account")){
            rp.set_txt_loginemail("msk13@gmail.com");
            rp.set_txt_password("msk");
            rp.clk_login();
            try{
                String msg=rp.getIncorrectmsg();
                if(msg.equalsIgnoreCase("Your email or password is incorrect!")){
                    System.out.println("login failed! invalid credentials");
                    Assert.assertTrue(true);
                }else{
                    System.out.println("login success- valid credentials");
                    Assert.fail();
                }
            }catch (Exception e){
                System.out.println("message: "+e.getMessage());
                Assert.fail();
            }

        }else{
            System.out.println("not on login page");
            Assert.fail();
        }
    }
}
