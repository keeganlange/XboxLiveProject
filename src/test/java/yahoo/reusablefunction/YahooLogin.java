package yahoo.reusablefunction;

import org.testng.Assert;

import util.TestData;
import yahoo.basepages.YahooHomePage;
import yahoo.basepages.YahooLoginPage;

public class YahooLogin {
	
	public static YahooHomePage signInDefaultUser() throws Exception {
		String email = TestData.get("email");
		String pwd = TestData.get("password");
		
		// Open browser, go to yahoo home page, test if user is at the home page
		YahooHomePage yahooHomePage = new YahooHomePage();
		yahooHomePage.open();
		yahooHomePage.waitPageLoad();
		Assert.assertTrue(yahooHomePage.titleIs(YahooHomePage.TITLE));
		
		// Navigate to yahoo login page, test if user is at the login page
		YahooLoginPage yahooLoginPage = yahooHomePage.gotoLoginPage();
		yahooLoginPage.waitPageLoad();
		Assert.assertTrue(yahooLoginPage.titleIs(YahooLoginPage.TITLE));

		// Signin to yahoo and navigate back to yahoo's home page, test that the user is signed in
		return yahooLoginPage.signIn(email, pwd);
	}

}
