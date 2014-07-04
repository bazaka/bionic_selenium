package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yuri on 7/1/2014.
 */
public class InfantRozetkaTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions builder;


    private static final By aviaTickets = By.id("fatmenu_14");
    private static final By aviaDirection = By.xpath("//a[contains(@*, 'travel/IEV/MOW/')]");
    private static final By twoBabiesIcon = By.xpath("//*[@data-field='infants']/*[@class='persons']/div[2]");
    private static final By valueOfBabies = By.xpath("//*[@data-field='infants']/div[1]/span");
    private static final By startSearch = By.id("start_search");
    private static final By errorMessage = By.xpath("//*[@class='popup error_popup']");



    @BeforeSuite
    public void preCondition(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://rozetka.com.ua");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
        builder = new Actions(driver);

    }

    @Test
    public void orderTicketForBabies(){

        builder.moveToElement(driver.findElement(aviaTickets)).perform();

        wait.until(ExpectedConditions.elementToBeClickable(aviaDirection)).click();


        //driver.findElement(aviaDirection).click(); //click to tickets order menu
        wait.until(ExpectedConditions.elementToBeClickable(twoBabiesIcon)).click();
        //wait.until(ExpectedConditions.textToBePresentInElementLocated(valueOfAdultMan,"0"));

        //driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div/div[2]/div[2]/div[2]/div[1]")).click(); //click on the adult man icon
        //String text = driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div/div[2]/div[2]/div[1]/span")).getText();
        //Assert.assertEquals(text,"1");
        //wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//*[@id='content']/div/div/div/div/div[2]/div[2]/div[1]/span"),"0")); // checked that 0 adult man was chosen

        //driver.findElement(twoBabiesIcon).click(); // click on 2 babies
        wait.until(ExpectedConditions.textToBePresentInElementLocated(valueOfBabies,"2"));

        driver.findElement(startSearch).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        String errorText = "Младенцев не может быть больше, чем взрослых(младенцев - 2, взрослых - 1)";
        Assert.assertEquals(driver.findElement(errorMessage).getText(), errorText);

    }


    @AfterSuite
    public void postCondition(){
        if(driver!=null)
            driver.quit();
    }


}

