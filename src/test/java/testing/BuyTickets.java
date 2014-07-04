package testing;

import org.testng.Assert;
import pages.TicketsPage;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 04.07.14
 * Time: 21:04
 * To change this template use File | Settings | File Templates.
 */
public class BuyTickets extends BasicTest {
    public void buyTwoInfantTicktets(){
        TicketsPage page = new TicketsPage()
               page.buyTickets(0,0,2);
        Assert.assertTrue(page.isError());
    }
}
