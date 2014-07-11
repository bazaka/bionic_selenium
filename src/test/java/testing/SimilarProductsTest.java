package testing;

import org.testng.annotations.Test;
import pages.ProductPage;
import utils.Log4Test;

/**
 * Created by Yuri on 7/11/2014.
 */
public class SimilarProductsTest extends BaseTest {

    @Test(dataProvider = "comparingModels")
    public void similarProductsTest(String modelName1, String modelName2){
        ProductPage page = new ProductPage(driver);
        page.login();
        page.searchModel(modelName1);
        page.validateProduct(modelName1);
        page.searchModel(modelName2);
        page.validateProduct(modelName2);
        Log4Test.info("Bingo!");


    }

}
