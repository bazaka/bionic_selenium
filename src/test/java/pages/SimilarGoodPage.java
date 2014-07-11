package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Yuri on 7/9/2014.
 */
public class SimilarGoodPage{//} extends BasePage{

    public static Actions builder;

    public static final By phonesList = By.id("phones-mp3-gps");
    public static final By phonesListClick = By.xpath("//a[contains(@*, 'phones-mp3-gps')]");
    public static final By clickOnSmart = By.xpath(".//*[@name='menu_categories_left']/li[1]//li[2]/a");
    public static final By clickOnApple = By.xpath(".//*[@name='menu_categories_left']/li[2]//li[1]/a");
    public static final By firstGood = By.xpath(".//*[@name=\"goods_list\"]/div[1]//*[@class='gtile-i-title']");
    public static final By secondGood = By.xpath(".//*[@name=\"goods_list\"]/div[2]//*[@class='gtile-i-title']");

    public void findSimilarGoods(){

    }

    public SimilarGoodPage(WebDriver driver){   //?
       // super(driver);
        //URL = "http://rozetka.com.ua";
    }


}
