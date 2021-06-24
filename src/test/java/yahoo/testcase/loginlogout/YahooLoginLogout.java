package yahoo.testcase.loginlogout;

import org.testng.Assert;
import org.testng.annotations.Test;

import yahoo.reusablefunction.YahooLogin;
import yahoo.basepages.YahooHomePage;
import util.TestCaseBase;

public class YahooLoginLogout extends TestCaseBase {
	
	@Test(groups = { "firefox", "ChromeWin32", "IEWin32"})
	public void testLoginLogout() throws Exception {
		// test data
		YahooHomePage yahooHomePage = YahooLogin.signInDefaultUser();
		yahooHomePage.waitPageLoad(); //here
		Assert.assertTrue(yahooHomePage.isUserSignedIn());
		
		// Logout and test if the user is logged out
		yahooHomePage.logout();
		yahooHomePage.waitPageLoad();
		Thread.sleep(5000);
		Assert.assertTrue(!yahooHomePage.isUserSignedIn());		
	}
}
