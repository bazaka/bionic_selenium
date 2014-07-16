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
public class TicketsTest extends BaseTest {


    @Test(dataProvider = "buyInfantTickets", dataProviderClass = DataProviders.class)
    public void buyTwoInfantTicktets(int adults, int infants){

        TicketsPage ticketPage = new TicketsPage(driver);

        ticketPage.open();
        Assert.assertTrue(ticketPage.isOpened(), Log4Test.error("Page is not opened"));
        ticketPage.buyChildTicket(adults,infants);
        Assert.assertTrue(ticketPage.isError(), Log4Test.error("Error message is not displayed"));
        Log4Test.info("Bingo!");
    }
}
