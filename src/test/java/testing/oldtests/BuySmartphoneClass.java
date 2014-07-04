package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;


/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 23.06.14
 * Time: 20:22
 * To change this template use File | Settings | File Templates.
 */
public class BuySmartphoneClass {
    @Test
    public void buySmartphoneTest(){
       // @Test
        WebDriver driver = new FirefoxDriver() ;
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("http://rozetka.com.ua/");
        driver.manage().window().maximize();
        String text = driver.findElement(By.className("m-cart-empty")).getText() ;


        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("phones-mp3-gps")));

        builder.perform();                        //запустить последовательность действий


       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("drop-elem")));
        driver.findElement(xpath("/html/body/header/div[3]/div/div/table/tbody/tr/td[2]/div/a")).click();
        wait.until(ExpectedConditions.titleContains("MP3, GPS"));

        driver.findElement(xpath("/html/body/div[1]/div[3]/div/div/div[2]/div[3]/ul/li[1]/ul/li[2]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div/div/div[2]/div[3]/ul/li[1]/ul/li[1]/a")));
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div[2]/div[3]/ul/li[1]/ul/li[1]/a")).click(); // all smart

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div/div/div[2]/div[3]/ul/li[1]/ul/li[1]/a")));

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[2]/div/div[3]/div[1]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[2]/div/div[3]/div[1]/div/div/ul/li[1]/a")));

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[2]/div/div[3]/div[1]/div/div/ul/li[1]/a")).click(); //sorting
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[2]/div/div[3]/div[1]/a")));

        driver.findElement(By.name("topurchasesfromcatalog")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("popup-checkout"))); //check that order window is opened

        driver.findElement(By.name("close")).click();       //close order window
        //driver.findElement(By.xpath("/html/body/div[1]/div/div/a/img")).click();
        //wait.until(ExpectedConditions.titleContains("Rozetka.ua"));     //back to the page
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("gift_checkbox")));

       String text1 = driver.findElement(By.name("open_cart")).getText() ;
        //Assert.assertFalse(text, text1);
       /*if (driver.findElement(By.name("open_cart")).getText().contains("1")){
            System.out.println("Cart has 1 order");
            driver.quit();
        }

       else System.out.println("Cart is empty");*/

        Assert.assertNotEquals(text, text1); // check that cart name before and cart name after are different
        driver.quit();
       // Assert.assertNotEquals(text, text1, "Cart has been changed");










        //driver.findElement(By.xpath("/html/body/header/div[3]/div/div/table/tbody/tr/td[2]/div/div/ol/li/ul/li/a")).click(); //click
        /*
        driver.findElement(By.className("m-cat-subl-i-link")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.className("xhr lightblue sprite dropdown")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[2]/div/div[3]/div/div/div/ul/li/a")).click();
        */








        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }
}
