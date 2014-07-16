package testing;

import org.testng.annotations.Test;
import pages.ProductPage;
import utils.Log4Test;

/**
 * Created by Yuri on 7/11/2014.
 */
public class SimilarProductsTest extends BaseTest {

    @Test(dataProvider = "comparingModels", dataProviderClass = DataProviders.class)
    public void similarProductsTest(String comparingModels[]){
        ProductPage page = new ProductPage(driver);
        page.login();
        for (String model : comparingModels) {
            page.searchModel(model);
            page.validateProduct(model);
        }
       // page.searchModel(modelName2);
       // page.validateProduct(modelName2);
        Log4Test.info("Bingo!");


    }

}
