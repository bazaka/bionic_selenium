package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Log4Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuri on 7/11/2014.
 */
public class ComparePage extends BasePage {

    private static final By visibleCatalog = By.id("compare-menu");
    private static final String productNameLocator = "//a[contains(text(), '%s')]";
    private static final By showDifferenceLnk = By.xpath("//*[@href='#only-different']");
    private static final By productsKeysLocator = By.xpath("//td[@class='detail-title']");
    private static final By productsDifferentKeysLocator = By.xpath("//tr[contains(@class, 'different')]/td[1]");
    private static final String productValuesLocator = "//td[@class='detail-title']/ancestor::tr/td[%d]";


    public ComparePage(WebDriver driver){
        super(driver);
    }

    public boolean productPresent(String modelName){
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.presenceOfElementLocated(visibleCatalog));
        Log4Test.info("Finding product name on the page");
        return driver.findElement(By.xpath(String.format(productNameLocator, modelName))).isDisplayed();
    }
    public void compareWorks(String [] comparingModels){
        Log4Test.info("Checking that compare works");
        for (String model : comparingModels)
            Assert.assertTrue(productPresent(model), Log4Test.error("Product1 doesn't available on the screen"));

    }

    public void showDifference() {
        Log4Test.info("Show the difference between the selected products.");
        driver.findElement(showDifferenceLnk).click();
    }

    public Boolean compareProductsDifference(String[] comparingModels) {
        Log4Test.info("Compare the difference between the selected products.");
        List<WebElement> productsKeys = getProductsKeys();
        List<List<WebElement>> productsValues = new ArrayList<List<WebElement>>();
        for (int i = 2; i <= comparingModels.length + 1; i++) {
            productsValues.add(getProductValues(i));
        }
        List<String> calculatedDifferentKeys = calculateDifferentKeys(productsKeys, productsValues);
        showDifference();
        List<String> differentKeys = getDifferentProductKeys();
        return calculatedDifferentKeys.size() == differentKeys.size() && calculatedDifferentKeys.containsAll(differentKeys);
    }

    public List<WebElement> getProductsKeys() {
        Log4Test.info("Getting product keys");
        return driver.findElements(productsKeysLocator);
    }

    public List<WebElement> getProductValues(int i) {
        Log4Test.info("Getting product value");
        return driver.findElements(By.xpath(String.format(productValuesLocator, i)));
    }

    public List<String> getDifferentProductKeys() {
        Log4Test.info("Getting different product keys");
        List<String> differentKeys = new ArrayList<String>();
        List<WebElement> foundDifferentKeys = driver.findElements(productsDifferentKeysLocator);

        for (WebElement element : foundDifferentKeys) {
            differentKeys.add(element.getText());
        }
        return differentKeys;
    }


    public List<String> calculateDifferentKeys(List<WebElement> productKeys, List<List<WebElement>> productsValues) {
        Log4Test.info("Calculate different keys");
        List<String> differentKeys = new ArrayList<String>();

        for (int i = 0; i < productKeys.size(); i++) {

            if (!productsValues.get(0).get(i).getText().equals(productsValues.get(1).get(i).getText())) {
                differentKeys.add(productKeys.get(i).getText());
            }
        }
        return differentKeys;
    }
}
