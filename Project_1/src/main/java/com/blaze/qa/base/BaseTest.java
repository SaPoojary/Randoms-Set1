package com.blaze.qa.base;

import com.blaze.qa.utils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static Properties config_prop;

    public BaseTest(){
        try{
            config_prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                    + "/src/main/java/com/blaze/qa/config/config.properties");
            config_prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initialize(){
        String browser = config_prop.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\SaPoojary\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }else{
            System.setProperty("webdriver.gecko.driver","C:\\Users\\SaPoojary\\Downloads\\geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLiCIT_WAIT, TimeUnit.SECONDS);

        driver.get(config_prop.getProperty("baseUrl"));
    }

}
