package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yuri on 7/4/2014.
 */
public class FindSimilarGoods {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions builder;


    public static final By phonesList = By.id("phones-mp3-gps");
    public static final By phonesListClick = By.xpath("//a[contains(@*, 'phones-mp3-gps')]");
    public static final By clickOnSmart = By.xpath(".//*[@name='menu_categories_left']/li[1]//li[2]/a");
    public static final By clickOnApple = By.xpath(".//*[@name='menu_categories_left']/li[2]//li[1]/a");
    public static final By firstGood = By.xpath(".//*[@name=\"goods_list\"]/div[1]//*[@class='gtile-i-title']");
    public static final By secondGood = By.xpath(".//*[@name=\"goods_list\"]/div[2]//*[@class='gtile-i-title']");



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
    public void findSimilarGoods()

    {
        builder.moveToElement(driver.findElement(phonesList)).perform();
        driver.findElement(phonesListClick).click();
        wait.until(ExpectedConditions.titleContains("MP3, GPS"));
        driver.findElement(clickOnSmart).click();
        wait.until(ExpectedConditions.elementToBeClickable(clickOnApple));
        driver.findElement(clickOnApple).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(clickOnApple));

        String model1 = driver.findElement(firstGood).getText();
        String model2 = driver.findElement(secondGood).getText();

        Assert.assertEquals(model1.startsWith("Apple iPhone 5s"), model2.startsWith("Apple iPhone 5s"));


       /*  List[] str = new List[2];
       for(int i=1; i<3; i++){

            //builder.moveToElement(By.xpath(".//*[@name=\"goods_list\"]/div[" + i + "]"));
            str[i].add(driver.findElement(By.xpath(".//*[@name=\"goods_list\"]/div[" + i + "]//*[@class='gtile-i-title']")).getText());
            //str. = driver.findElement(By.xpath(".//*[@name=\"goods_list\"]/div[" + i + "]//*[@class='gtile-i-title']")).getText();
            System.out.println(str[i]);
        }*/


    }
    /*@Test
    public void findAndCheckSimilarGoads(){




        builder.moveToElement(driver.findElement(By.id("phones-mp3-gps")));
        builder.perform();

        driver.findElement(By.xpath(".//*[@id='phones-mp3-gps']/div/a")).click();  //click on the smartphones
        wait.until(ExpectedConditions.titleContains("MP3, GPS"));

        driver.findElement(By.xpath(".//*[@id='head_banner_container']/div[3]/div/div/div[1]/div/div/div[4]/div/div/div[1]/div/div[1]/div/ul/li[8]/a/span")).click(); //click "all smartphones"
        wait.until(ExpectedConditions.elementToBeClickable(By.className("gtile-i-wrap")));


        if (!driver.findElement(By.xpath(".//*[@id='sort_producer']/li[23]/label/input")).isSelected())  // click on the "Samsung" checkbox
            driver.findElement(By.xpath(".//*[@id='sort_producer']/li[23]/label/input")).click();
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath(".//*[@id='sort_producer']/li[23]/label/input")));

        if (!driver.findElement(By.xpath(".//*[@id='sort_24983']/li[1]/label/input")).isSelected())    //click on the "2 cores" checkbox
            driver.findElement(By.xpath(".//*[@id='sort_24983']/li[1]/label/input")).click();
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath(".//*[@id='sort_24983']/li[1]/label/input")));

        if (!driver.findElement(By.xpath(".//*[@id='sort_23777']/li[1]/label/input")).isSelected()) //click on the 4" display size
            driver.findElement(By.xpath(".//*[@id='sort_23777']/li[1]/label/input")).click();
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath(".//*[@id='sort_23777']/li[1]/label/input")));

        builder.moveToElement(driver.findElement(By.id("image_item735259"))).perform();
        if (!driver.findElement(By.xpath(".//*[@id='block_with_goods']/div/div[1]/div[1]/div[1]/div/div/div[5]/div[1]/label/input")).isSelected()) //click on the comparison checkbox
            driver.findElement(By.xpath(".//*[@id='block_with_goods']/div/div[1]/div[1]/div[1]/div/div/div[5]/div[1]/label/input")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("list-compare")));



        builder.moveToElement(driver.findElement(By.id("image_item287281"))).perform();
        if(!driver.findElement(By.xpath(".//*[@id='block_with_goods']/div/div[1]/div[2]/div[1]/div/div/div[6]/div[1]/label/input")).isSelected()) // click on the comparison checkbox
            driver.findElement(By.xpath(".//*[@id='block_with_goods']/div/div[1]/div[2]/div[1]/div/div/div[6]/div[1]/label/input")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='block_with_goods']/div/div[1]/div[2]/div[1]/div/div/div[6]/div[1]/span/a")));


        driver.findElement(By.xpath(".//*[@id='block_with_goods']/div/div[1]/div[2]/div[1]/div/div/div[6]/div[1]/span/a")).click();  //click on the "compare" button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("compare-menu")));

        String osFirstPhone = driver.findElement(By.xpath(".//*[@id='head_banner_container']/div[3]/div/div/div[2]/table/tbody/tr[2]/td[2]")).getText(); // get type of operating system of 1st phone
        String osSecondPhone = driver.findElement(By.xpath(".//*[@id='head_banner_container']/div[3]/div/div/div[2]/table/tbody/tr[2]/td[3]")).getText(); // get type of operating system of 2nd phone
        Assert.assertEquals(osFirstPhone, osSecondPhone); // check similarity of OS of phones

        driver.findElement(By.className("xhr")).click(); // go to the "only different" menu
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='head_banner_container']/div[3]/div/div/div[2]/table/tbody/tr[2]/td[2]"))); // element "OS" is invisible on the page

        // "ONLY DIFFERENT" MENU IS WORKING BECAUSE ALL SIMILAR ELEMENTS (SUCH AS "Operating System") ARE INVISIBLE ON THE PAGE

    }*/

    @AfterSuite
    public void postCondition(){
        if(driver!=null)
            driver.quit();
    }


}
