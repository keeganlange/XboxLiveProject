package yahoo.testcase.account;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.TestCaseBase;
import yahoo.basepages.YahooEditAccountPage;
import yahoo.basepages.YahooHomePage;
import yahoo.basepages.YahooPersonalInfoPage;
import yahoo.reusablefunction.YahooLogin;

public class YahooEditAccountInfo extends TestCaseBase {
	/*
	public YahooEditAccountInfo() {
		
	}
	*/
	
	@Test(groups = { "firefox", "ChromeWin32", "IEWin32"})
	public void testEditAccountSingle() throws Exception {
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
		yahooEditAccountPage.clearContents();
		yahooPersonalInfoPage = yahooEditAccountPage.updateContactInfo(0);
		//TestCaseBase.threadDriver.get().get(YahooPersonalInfoPage.URL);
		yahooPersonalInfoPage.waitPageLoad();
		
		Assert.assertTrue(yahooPersonalInfoPage.titleIs(YahooPersonalInfoPage.TITLE));
		yahooEditAccountPage = yahooPersonalInfoPage.gotoEditAccountPage();
		yahooEditAccountPage.waitPageLoad();
		Assert.assertTrue(yahooEditAccountPage.titleIs(YahooEditAccountPage.TITLE));
	}
}
