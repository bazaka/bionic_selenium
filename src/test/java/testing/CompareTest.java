package testing;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ComparePage;
import utils.Log4Test;

/**
 * Created by Yuri on 7/10/2014.
 */
public class CompareTest extends BaseTest {
    @DataProvider(name="comparingModels")
    public Object[][] createData(){
        return new Object[][]{
                {"Apple iPhone 5s","Apple iPhone 5c"}
        };
    }

    @Test(dataProvider = "comparingModels")
    public void compareModelTest(String modelName1, String modelName2){

        ComparePage page = new ComparePage(driver);

        page.login();
        //page.open();
        //Assert.assertTrue(page.isOpened(), Log4Test.info("Page doesn't opened"));
        Log4Test.info("Searching model" +modelName1);
        page.searchModel(modelName1);

        page.addToCompare();

        page.searchModel(modelName2);
        page.addToCompare();
        page.toCompareCatalog();

       Log4Test.info("Checking that compare works");
        page.compareWorks(modelName1, modelName2);
        Log4Test.info("Bingo!!");

    }
}
