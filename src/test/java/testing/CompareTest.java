package testing;

import org.testng.annotations.Test;
import pages.ComparePage;
import pages.ProductPage;
import utils.Log4Test;

/**
 * Created by Yuri on 7/10/2014.
 */
public class CompareTest extends BaseTest {


    @Test(dataProvider = "comparingModels")
    public void compareModelTest(String modelName1, String modelName2){

        ProductPage page = new ProductPage(driver);

        page.login();
        //page.open();
        //Assert.assertTrue(page.isOpened(), Log4Test.info("Page doesn't opened"));
        Log4Test.info("Searching model" +modelName1);
        page.searchModel(modelName1);
        page.addToCompare();
        page.searchModel(modelName2);
        page.addToCompare();
        page.toCompareCatalog();

        ComparePage comparePage = new ComparePage(driver);
        Log4Test.info("Checking that compare works");
        comparePage.compareWorks(modelName1, modelName2);
        Log4Test.info("Bingo!!");

    }
}
