package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Log4Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yuri on 7/10/2014.
 */
public class ProductPage extends BasePage {
    private static final By searchString = By.className("header-search-input-text");
    private static final String productNameLocator = "//a[contains(text(), '%s')]";
    private static final By addProductToCompare = By.name("tocomparison");
    private static final By completeComparing = By.name("comparison_catalog");
    private static final By compareCatalog = By.xpath("//div[@name='comparison_catalog']/a");




    public ProductPage(WebDriver driver){
        super(driver);
    }

    public void login()
    {
        BasePage openPage = new BasePage(driver);
        openPage.open();
       // Assert.assertTrue(openPage.isOpened(), Log4Test.error("Could not open page"));
    }
    public boolean searchModel (String modelName){
        Log4Test.info("Entering product name: " +modelName);
        driver.findElement(searchString).clear();
        driver.findElement(searchString).sendKeys(modelName);
        driver.findElement(searchString).sendKeys(Keys.ENTER);
        Log4Test.info("Checking successfull finding ");
        return driver.findElement(By.xpath(String.format(productNameLocator,modelName))).isDisplayed();

    }
    public void validateProduct (String modelName){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(String.format(productNameLocator, modelName)), modelName));
        Log4Test.info("Getting product Name");
        String productName = driver.findElement(By.xpath(String.format(productNameLocator, modelName))).getText();
        Log4Test.info("Validate product Name");
        Assert.assertTrue(productName.contains(modelName));
    }
    public void addToCompare(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        Log4Test.info("Adding to compare");
        driver.findElement(addProductToCompare).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(completeComparing, "Добавлен"));
        //wait.until(ExpectedConditions.presenceOfElementLocated(visibleCatalog));
        Log4Test.info("Product is added");
    }
    public void toCompareCatalog(){


        driver.findElement(compareCatalog).click();
        Log4Test.info("To compare catalog");
    }


}
