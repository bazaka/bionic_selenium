package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Log4Test;

/**
 * Created by Yuri on 7/11/2014.
 */
public class ComparePage extends BasePage {

    private static final By visibleCatalog = By.id("compare-menu");
    private static final String productNameLocator = "//a[contains(text(), '%s')]";


    public ComparePage(WebDriver driver){
        super(driver);
    }

    public boolean productPresent(String modelName){
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.presenceOfElementLocated(visibleCatalog));
        Log4Test.info("Finding product name on the page");
        return driver.findElement(By.xpath(String.format(productNameLocator, modelName))).isDisplayed();
    }
    public void compareWorks(String modelName1, String modelName2){
        Assert.assertTrue(productPresent(modelName1), Log4Test.error("Product1 doesn't available on the screen"));
        Assert.assertTrue(productPresent(modelName2), Log4Test.error("Product2 doesn't available ob the screen"));
    }
}
