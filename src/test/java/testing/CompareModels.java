package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Yuri on 7/4/2014.
 */
public class CompareModels {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions builder;}
/*
    public static final By firstGoodComparing = By.xpath(".//*[@name=\"goods_list\"]/div[1]//*[@name='tocomparison']");
    public static final By secondGoodComparing = By.xpath(".//*[@name=\"goods_list\"]/div[2]//*[@type='checkbox']");
    public static final By moveToFirstGood = By.xpath(".//*[@name='goods_list']/div[1]");
    public static final By moveToSecondGood = By.xpath(".//*[@name='goods_list']/div[2]");
    public static final By compareClick = By.xpath(".//*[@class='list-compare']//*[@class='lightblue arrow-link']");


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
    public void compareTwoModels(){
        builder.moveToElement(driver.findElement(FindSimilarGoods.phonesList)).perform();
        driver.findElement(FindSimilarGoods.phonesListClick).click();
        wait.until(ExpectedConditions.titleContains("MP3, GPS"));
        driver.findElement(FindSimilarGoods.clickOnSmart).click();
        wait.until(ExpectedConditions.elementToBeClickable(FindSimilarGoods.clickOnApple));
        driver.findElement(FindSimilarGoods.clickOnApple).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(FindSimilarGoods.clickOnApple));

        //to compare
        builder.moveToElement(driver.findElement(moveToFirstGood)).perform();
        while (!driver.findElement(firstGoodComparing).isSelected())
            driver.findElement(firstGoodComparing).click();

        builder.moveToElement(driver.findElement(moveToSecondGood)).perform();
        while (!driver.findElement(secondGoodComparing).isSelected())
            driver.findElement(secondGoodComparing).click();

        wait.until(ExpectedConditions.elementToBeClickable(compareClick)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(compareClick));






    }

    @AfterSuite
    public void postCondition(){
        if(driver!=null)
            driver.quit();
    }
}*/
