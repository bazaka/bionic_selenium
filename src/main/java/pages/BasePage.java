package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 04.07.14
 * Time: 19:43
 * To change this template use File | Settings | File Templates.
 */
//abstract
class BasePage {
    protected String URL;  //="rozetka"
    protected WebDriver driver;


    public BasePage(WebDriver driver){       //constructor     webdriv na vhod
        this.driver=driver;                      //initializ svoi driver      this - обратиться к классу отделяем зис.драйвер от вебдрайве.драйвер
    }

    public  void open(){
        driver.get(URL);
    }

    public  boolean isOpened(){
    return driver.getCurrentUrl().equals(URL) ;
    }




}
