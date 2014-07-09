package testing;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TicketsPage;
import utils.Log4Test;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 04.07.14
 * Time: 21:04
 * To change this template use File | Settings | File Templates.
 */
public class BuyInfantTickets extends BaseTest {

    @Test
    public void buyTwoInfantTicktets(){
        Log4Test.info("--- Start BuyInfantTicket test ---");
        TicketsPage page = new TicketsPage(driver);
        Log4Test.info("Open ticket page");
        page.open();
        Assert.assertTrue(page.isOpened(), Log4Test.error("Page is not opened"));
        Log4Test.info("Choosing value of adults and infants");
        page.buyChildTicket(1,2);
        Assert.assertTrue(page.isError(), Log4Test.error("Error message is not displayed"));
        Log4Test.info("--- End of BuyInfantTicket test ---");
    }
}
