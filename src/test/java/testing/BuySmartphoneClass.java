package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


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
        driver.get("http://rozetka.com.ua/");
        driver.manage().window().maximize();
        String text = driver.findElement(By.className("m-cart-empty")).getText() ;
        Assert.assertEquals("Корзина пуста",text);

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("phones-mp3-gps")));
        builder.perform();                        //запустить последовательность действий

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/header/div[3]/div/div/table/tbody/tr/td[2]/div/div/ol/li/ul/li/a")).click(); //click
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.className("m-cat-subl-i-link")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.className("xhr lightblue sprite dropdown")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[2]/div/div[3]/div/div/div/ul/li/a")).click();









        driver.quit();


    }
}
