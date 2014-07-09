package testing;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TicketsPage;
import utils.Log4Test;

public class TicketsTest extends BaseTest {

    @Test(dataProvider = "buyInfantTickets")
    public void buyTwoInfantTicktets(int adults, int infants){
    Log4Test.info("Start test");
    TicketsPage ticketPage = new TicketsPage(driver);
    Log4Test.info("Open ticket page");
    ticketPage.open();
    Assert.assertTrue(ticketPage.isOpened(), Log4Test.error("Page is not opened"));
    Log4Test.info("Choosing value of adults and infants");
    ticketPage.buyChildTicket(adults,infants);
    Assert.assertTrue(ticketPage.isError(), Log4Test.error("Error message is not displayed"));
    Log4Test.info("Bingo!");
    }
}