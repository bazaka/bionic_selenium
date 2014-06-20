package testpack;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 18.06.14
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */
public class smokeTest {

    @Test
    public void sTest() {
          int i = 1;

        while (i < 2147483647) {
            i++;
            if (i == 2147483647){
            System.out.print("Значение int переполнено");
                break;}

        }
        //To change body of created methods use File | Settings | File Templates.
    }




}










