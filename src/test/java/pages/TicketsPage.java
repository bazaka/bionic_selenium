package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 04.07.14
 * Time: 19:50
 * To change this template use File | Settings | File Templates.
 */
public class TicketsPage extends BasePage {

    /*
    private static final By aviaTickets = By.id("fatmenu_14");
    private static final By aviaDirection = By.xpath("//a[contains(@*, 'travel/IEV/MOW/')]");
    private static final By twoBabiesIcon = By.xpath("//*[@data-field='infants']/*[@class='persons']/div[2]");
    private static final By valueOfBabies = By.xpath("//*[@data-field='infants']/div[1]/span");
    private static final By startSearch = By.id("start_search");
    private static final By errorMessage = By.xpath("//*[@class='popup error_popup']");
                                                                                         */
    private static final String adultTickets = "//div[@class='adult_block']/div[%d]";
    private static final String infantTickets = "//div[@class='infants_block']/div[%d]";

      //string.format(str, variable format)
    public TicketsPage(WebDriver driver){
        super(driver);
        URL = "http://rozetka.com.ua/travel/IEV/MOW/";

    }




    public void buyChildTicket(int adults, int childrens, int infants){
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.findElement(By.xpath(String.format(adultTickets,adults))).click();
        driver.findElement(By.xpath(String.format(infantTickets,infants))).click();

       // driver.findElement(By.xpath())



    //driver.findElement(By.xpath(st))
    }

}
