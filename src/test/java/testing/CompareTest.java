package testing;

import org.testng.annotations.Test;
import pages.ComparePage;
import pages.ProductPage;
import utils.Log4Test;

/**
 * Created by Yuri on 7/10/2014.
 */
public class CompareTest extends BaseTest {


    @Test(dataProvider = "comparingModels", dataProviderClass = DataProviders.class)
    public void compareModelTest(String comparingModels[]){

        ProductPage page = new ProductPage(driver);
        page.login();
        //page.open();
        //Assert.assertTrue(page.isOpened(), Log4Test.info("Page doesn't opened"));
        for (String models : comparingModels) {

            page.searchModel(models);
            page.addToCompare();
        }
        page.toCompareCatalog();

        ComparePage comparePage = new ComparePage(driver);

        comparePage.compareWorks(comparingModels);
        Log4Test.info("Bingo!!");

    }
}
