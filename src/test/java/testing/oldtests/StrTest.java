package testing;
import core.Str;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Created by Yuri on 6/23/2014.
 */
public class StrTest {
    private Str length = new Str();

    @DataProvider(name = "provideLength")
    public Object[][] checkLenght(){
        return new Object[][]{
                {10, length.strok(2)},
        };
    }



    @Test(dataProvider = "provideLength")
    public void test(int rezult, int tensymb) {
        Assert.assertEquals(rezult, 10);
    }



}
