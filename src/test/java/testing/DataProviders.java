package testing;

import org.testng.annotations.DataProvider;

/**
 * Created by Yuri on 7/15/2014.
 */
public class DataProviders {
    @DataProvider(name="comparingModels")
    public static Object[][] createData(){
        return new Object[][]{
                {new String[] {"Apple iPhone 5s","Apple iPhone 5c"}}
        };
    }

    @DataProvider(name = "buyInfantTickets")
    public static Object [][] createData1(){
        return new Object[][]{
                new Object[] {1, 2},

        };
    }

}
