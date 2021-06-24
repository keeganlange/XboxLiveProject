package google.testcase.search;

import org.testng.Assert;
import org.testng.annotations.Test;
import google.basepages.GoogleHomePage;
import google.basepages.GoogleWebSearchResultPage;
import google.basepages.PerficientHomePage;
import util.FunctionUtil;
import util.TestCaseBase;
import util.TestData;

public class TC_01_GoogleWebSearch extends TestCaseBase {
	
	@Test(groups = { "firefox", "ChromeWin32"})
	public void testSearchWeb() throws Exception {
		String searchItem = TestData.get("input.search");
		
		GoogleHomePage googleHomePage = new GoogleHomePage();
		googleHomePage.open();	
		googleHomePage.waitPageLoad();
		Assert.assertTrue(googleHomePage.titleIs(GoogleHomePage.TITLE));

		GoogleWebSearchResultPage googleWebSearchResultPage = googleHomePage.search(searchItem);
		googleWebSearchResultPage.waitPageLoad();
		Assert.assertTrue(googleWebSearchResultPage.titleIs(searchItem));

		PerficientHomePage perficientHomePage = googleWebSearchResultPage.clickFirstLink();
		FunctionUtil.switchToNewWindow();//switch to new window
		perficientHomePage.waitPageLoad();
		Assert.assertTrue(perficientHomePage.titleIs(PerficientHomePage.TITLE));
	}
}
