package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 04.07.14
 * Time: 20:15
 * To change this template use File | Settings | File Templates.
 */
public class BasicTest {
    public static WebDriver driver;
    public static WebDriverWait wait;  //delete
    public static Actions builder;             //delete

    @BeforeSuite
    public void preCondition(){    //name initEnv
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
       // driver.get("http://rozetka.com.ua");       //all delete
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //wait = new WebDriverWait(driver,10);
        //builder = new Actions(driver);

    }
    @AfterSuite
    public void postCondition(){
        if(driver!=null)
            driver.quit();
    }
}
