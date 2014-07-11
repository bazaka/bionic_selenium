package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import utils.Log4Test;
import utils.PropertyLoader;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 12.06.14
 * Time: 18:23
 * To change this template use File | Settings | File Templates.
 */
public class WebDriverFactory {
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static WebDriver initDriver(String browserName)
    {
        WebDriver driver = null;
        if (browserName.equals(FIREFOX))
        {
            driver = new FirefoxDriver();
        } else
        if (browserName.equals(CHROME))
        {
            File file = new File(PropertyLoader.loadProperty("selenium.chrome.driver.path"));
            System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
            driver = new ChromeDriver();
        } else
            Assert.fail(Log4Test.error("WebDriver not defined"));
        return driver;
    }
}