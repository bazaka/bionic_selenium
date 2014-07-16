package testing;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Log4Test;

/**
 * Created by Yuri on 15.07.2014.
 */
public class HomeWork4 {


    @DataProvider
    public Object[][] testStrings() {
        return new Object[][] { {"hello,world"}, {"BionicUniversity"}, {"QaSelenium"} };
    }
    @Test(dataProvider = "testStrings")
    public void Test_String(String test_str)
    {
        Log4Test.info("Start HomeWork4 test");
        try{
            int expected_length=10;
            int actual_length=test_str.length();

            Assert.assertEquals(actual_length, expected_length);
            System.out.println("Length of the string matches the required value  "+expected_length+"\n");
        }
        catch(AssertionError ae)
        {
            System.out.println("Length of the string does not match the required length\n");
        }
    }
}