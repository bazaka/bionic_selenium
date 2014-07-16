package testing;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.ProductPage;
import utils.Log4Test;

/**
 * Created by Yuri on 7/15/2014.
 */
public class CompareDifferentTest extends BaseTest {
    @Test(dataProvider = "comparingModels", dataProviderClass = DataProviders.class)
    public void compareDifferentTest (String comparingModels[]){
        ProductPage page = new ProductPage(driver);
        page.login();
        for (String model : comparingModels) {
            page.searchModel(model);
            page.addToCompare();
        }
        //page.searchModel(modelName2);
        //page.addToCompare();
        page.toCompareCatalog();

        ComparePage comparePage = new ComparePage(driver);
        //Assert.assertTrue(comparePage.areProductsPresent(products), Log4Test.error("Not all selected products are present in the comparison page."));
       // for (String model : comparingModels)
       // Assert.assertTrue(comparePage.compareWorks(comparingModels), Log4Test.error("Not all selected products are present in the comparison page."));
        Assert.assertTrue(comparePage.compareProductsDifference(comparingModels), Log4Test.error("Not all displayed properties are different."));
        Log4Test.info("Bingo!");
    }
}
