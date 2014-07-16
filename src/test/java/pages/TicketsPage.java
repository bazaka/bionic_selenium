package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log4Test;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 04.07.14
 * Time: 19:50
 * To change this template use File | Settings | File Templates.
 */
public class TicketsPage extends BasePage {


   // private static final By aviaTickets = By.id("fatmenu_14");
    //private static final By aviaDirection = By.xpath("//a[contains(@*, 'travel/IEV/MOW/')]");
    //private static final By twoBabiesIcon = By.xpath("//*[@data-field='infants']/*[@class='persons']/div[2]");
    //

    private static final By startSearch = By.id("start_search");
    private static final By errorMessage = By.xpath("//*[@class='popup error_popup']");

    private static final String adultTickets = "//div[@data-field='adults']/div[@class='persons']/div[%d]";
    private static final By valueOfAdults = By.xpath("//*[@data-field='adults']/div[1]/span");

    private static final String infantTickets = "//div[@data-field='infants']/div[@class='persons']/div[%d]";
    private static final By valueOfInfants = By.xpath("//*[@data-field='infants']/div[1]/span");


      //string.format(str, variable format)
    public TicketsPage(WebDriver driver){
        super(driver);
        URL = "http://rozetka.com.ua/travel/IEV/MOW/";

    }

    public void buyChildTicket(int adults, int infants){
        WebDriverWait wait = new WebDriverWait(driver,10);
        Log4Test.info("Choosing value of adults and infants");
        if (Integer.parseInt(driver.findElement(valueOfAdults).getText()) != adults)
            driver.findElement(By.xpath(String.format(adultTickets,adults))).click();

        if (Integer.parseInt(driver.findElement(valueOfInfants).getText()) != infants)
            driver.findElement(By.xpath(String.format(infantTickets,infants))).click();
        Log4Test.info("Start search");
        driver.findElement(startSearch).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        Log4Test.info("Bingo!");


    }
    public boolean isError(){

        return driver.findElements(errorMessage).size() > 0;
    }

}
