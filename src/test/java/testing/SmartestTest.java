package testing;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 20.06.14
 * Time: 21:11
 * To change this template use File | Settings | File Templates.
 */
public class SmartestTest {

    @Test
    public void runTest() {
        Assert.assertEquals(1, 1);
        System.out.println("Hey, I am the text and I deserve to be read!");
    }
}
