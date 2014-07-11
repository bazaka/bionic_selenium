package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Log4Test;

/**
 * Created by Yuri on 7/10/2014.
 */
public class ComparePage extends BasePage {
    private static final By searchString = By.className("header-search-input-text");
    private static final String productNameLocator = "//a[contains(text(), '%s')]";
    private static final By addProductToCompare = By.name("tocomparison");
    private static final By completeComparing = By.name("comparison_catalog");
    private static final By compareCatalog = By.xpath("//div[@name='comparison_catalog']/a");
    private static final By visibleCatalog = By.id("compare-menu");



    public ComparePage (WebDriver driver){
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
    public boolean productPresent(String modelName){
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.presenceOfElementLocated(visibleCatalog));
        Log4Test.info("Product name are avaliable on the page");
        return driver.findElement(By.xpath(String.format(productNameLocator,modelName))).isDisplayed();
    }
    public void compareWorks(String modelName1, String modelName2){
        Assert.assertTrue(productPresent(modelName1), Log4Test.error("Product1 doesn't available"));
        Assert.assertTrue(productPresent(modelName2), Log4Test.error("Product2 doesn't available"));
    }

}
