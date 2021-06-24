package yahoo.testcase.search;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import yahoo.basepages.PerficientHomePage;
import util.FunctionUtil;
import util.TestCaseBase;
import yahoo.basepages.YahooHomePage;
import yahoo.basepages.YahooSearchResultsPage;

public class YahooSearch extends TestCaseBase {

	@Test(groups = { "firefox", "ChromeWin32", "IEWin32"})
	public void testSearch() throws Exception {
		YahooHomePage yahooHomePage = new YahooHomePage();
		yahooHomePage.open();
		yahooHomePage.waitPageLoad();
		Assert.assertTrue(yahooHomePage.titleIs(YahooHomePage.TITLE));
		
		yahooHomePage.search("perficient");
		YahooSearchResultsPage yahooSearchResultsPage = yahooHomePage.gotoYahooSearchResultsPage();
		yahooSearchResultsPage.waitPageLoad();
		Assert.assertTrue(yahooSearchResultsPage.titleIs("perficient - Yahoo Search Results"));
		
		PerficientHomePage perficientHomePage = yahooSearchResultsPage.clickFirstLink();
		
		perficientHomePage.waitPageLoad();
		Assert.assertTrue(perficientHomePage.titleIs(PerficientHomePage.TITLE));
	}
}
