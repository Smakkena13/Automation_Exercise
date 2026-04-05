package baseTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public EdgeOptions eo;

    @BeforeClass
    public void setUp(){
        eo=new EdgeOptions();
        File file= new File("C:\\Users\\Happy\\Downloads\\uBlock.crx");
        eo.addExtensions(file);

        driver=new EdgeDriver(eo);
        driver.get("https://automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(5));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        System.out.println("TC is passed!");
        driver.quit();
    }
    public String randomAlphabetic(){
        RandomStringUtils random=new RandomStringUtils();
        String alphabetic=random.randomAlphabetic(5);
        return alphabetic;
    }
    public String randomNumeric(){
        RandomStringUtils random=new RandomStringUtils();
        return random.randomNumeric(10);
    }
    public String randomAlpNum(){
        RandomStringUtils rm=new RandomStringUtils();
        String a=rm.randomAlphabetic(5);
        String b=rm.randomNumeric(3);

        String email=a+b;
        return email;
    }
}
