package baseTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.ConfigurationSource;

import java.io.*;

import org.apache.logging.log4j.Logger;
import Utilities.LoggerUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public EdgeOptions eo;
    public static final Logger log;
    Properties p;

    static {
        try {
            File file = new File("C:\\Users\\Happy\\IdeaProjects\\Automation_Exercise\\log4j2.xml");

            if (file.exists()) {
                ConfigurationSource source = new ConfigurationSource(
                        new FileInputStream(file), file
                );
                Configurator.initialize(null, source);
                System.out.println("Log4j2 initialized manually ✅");
            } else {
                System.out.println("❌ log4j2.xml NOT FOUND at given path!");
            }

            // Debug: Print where Log4j2 loaded config from
            LoggerContext context = (LoggerContext) LogManager.getContext(false);
            System.out.println("Config loaded from: " + context.getConfigLocation());

        } catch (Exception e) {
            System.out.println("❌ Exception: " + e.getMessage());
            e.printStackTrace();
        }

        log = LogManager.getLogger(BaseClass.class);
    }

    @BeforeClass(groups = {"regression","sanity"})
    @Parameters({"browser"})
    public void setUp(String br) throws IOException {
        log.info("====== Test Started ======");
        log.info("Setting up EdgeDriver...");

        switch (br.toLowerCase()){
            case "edge": driver=new EdgeDriver();
            break;
            case "chrome": driver=new ChromeDriver();
            break;
            case "firefox": driver=new FirefoxDriver();
            break;
            default:
                System.out.println("Invalid browser name provided: " + br);
                return;
        }
        eo=new EdgeOptions();
        File file= new File("C:\\Users\\Happy\\Downloads\\uBlock.crx");
        eo.addExtensions(file);
        p=new Properties();
        FileInputStream f = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
        p.load(f);

        driver.get(p.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(5));
        driver.manage().window().maximize();
        log.info("Browser launched and maximized successfully");
    }

    @AfterClass(groups={"regression","sanity"})
    public void tearDown(){
        log.info("Closing browser...");
        driver.quit();
        log.info("====== Test Ended ======");
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
    public String captureScreenshot(String rname){
        SimpleDateFormat df=new SimpleDateFormat("yyyyMMddmmss");
        Date d=new Date();
        String currdate= df.format(d);

        TakesScreenshot ts= (TakesScreenshot) driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        String targetFilepath=System.getProperty("user.dir")+"\\screenshots\\"+rname+"_"+currdate+"_"+".png";
        File target=new File(targetFilepath);

        source.renameTo(target);
        return targetFilepath;

    }
}
