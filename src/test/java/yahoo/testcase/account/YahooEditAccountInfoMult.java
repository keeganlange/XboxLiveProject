package yahoo.testcase.account;

import java.util.List;

import org.apache.commons.csv.CSVRecord;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.TestCaseBase;
import yahoo.basepages.YahooEditAccountPage;
import yahoo.basepages.YahooHomePage;
import yahoo.basepages.YahooPersonalInfoPage;
import yahoo.reusablefunction.YahooLogin;

public class YahooEditAccountInfoMult extends TestCaseBase {
	/*
	private List<List<CSVRecord>> records;
	private int index;
	
	public YahooEditAccountInfoMult(List<List<CSVRecord>> records, int index) {
		this.records = records;
		this.index = index;
	}
	*/
	//@Test(groups = { "firefox", "ChromeWin32", "IEWin32"})
	public void testEditAccountMultiple() throws Exception {
		// login and test
		YahooHomePage yahooHomePage = YahooLogin.signInDefaultUser();
		yahooHomePage.waitPageLoad(); // here
		Assert.assertTrue(yahooHomePage.isUserSignedIn());
		
		// navigate to personal info page and edit account page and test
		YahooPersonalInfoPage yahooPersonalInfoPage = yahooHomePage.gotoPersonalInfoPage();
		yahooPersonalInfoPage.waitPageLoad();
		Assert.assertTrue(yahooPersonalInfoPage.titleIs(YahooPersonalInfoPage.TITLE));
		YahooEditAccountPage yahooEditAccountPage = yahooPersonalInfoPage.gotoEditAccountPage();
		yahooEditAccountPage.waitPageLoad();
		Assert.assertTrue(yahooEditAccountPage.titleIs(YahooEditAccountPage.TITLE));
		
		//test contact information
		yahooEditAccountPage.readContents();
		int recordSize = yahooEditAccountPage.recordSize();
		
		for (int i = 0; i < recordSize; i++) {
			yahooEditAccountPage.readContents();
			yahooEditAccountPage.clearContents();
			yahooPersonalInfoPage = yahooEditAccountPage.updateContactInfo(i);
			yahooPersonalInfoPage.waitPageLoad();
			
			Assert.assertTrue(yahooPersonalInfoPage.titleIs(YahooPersonalInfoPage.TITLE));
			yahooEditAccountPage = yahooPersonalInfoPage.gotoEditAccountPage();
			yahooEditAccountPage.waitPageLoad();
			Assert.assertTrue(yahooEditAccountPage.titleIs(YahooEditAccountPage.TITLE));
		}
	}
}
