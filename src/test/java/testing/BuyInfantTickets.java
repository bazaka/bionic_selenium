package testing;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

    @DataProvider(name = "buyInfantTickets")
    public Object [][] createData(){
        return new Object[][]{
               new Object[] {2, 4},

        };
    }
    @Test(dataProvider = "buyInfantTickets")
    public void buyTwoInfantTicktets(int adults, int infants){
        Log4Test.info("--- Start BuyInfantTicket test ---");
        TicketsPage ticketPage = new TicketsPage(driver);
        Log4Test.info("Open ticket page");
        ticketPage.open();
        Assert.assertTrue(ticketPage.isOpened(), Log4Test.error("Page is not opened"));
        Log4Test.info("Choosing value of adults and infants");
        ticketPage.buyChildTicket(adults,infants);
        Assert.assertTrue(ticketPage.isError(), Log4Test.error("Error message is not displayed"));
        Log4Test.info("--- End of BuyInfantTicket test ---");
    }
}
