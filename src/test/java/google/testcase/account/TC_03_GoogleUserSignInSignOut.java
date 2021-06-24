package google.testcase.account;

import org.testng.Assert;
import org.testng.annotations.Test;
import google.basepages.GoogleHomePage;
import google.basepages.GoogleSignInPage;
import google.reusablefunction.LoginActivity;
import util.TestCaseBase;
import util.TestData;
import util.Waiting;

public class TC_03_GoogleUserSignInSignOut extends TestCaseBase {
	
	@Test(groups={"ChromeWin32", "firefox"})
	public void testSignIn() throws Exception 
	{	
		GoogleHomePage googleHomePage = LoginActivity.signInDefaultUser();
		googleHomePage.waitPageLoad();
		Assert.assertTrue(googleHomePage.titleIs(GoogleHomePage.TITLE));
		expectedLogin("true"); //expected the user is signed in after the logout.
		Assert.assertTrue(googleHomePage.isUserSignedIn());
		
		googleHomePage.logout();
		googleHomePage.waitPageLoad();
		Waiting.until(googleHomePage.loginLink);
		
		Assert.assertTrue(googleHomePage.titleIs(GoogleHomePage.TITLE));
		expectedLogin("false"); //expected the user is not signed in after the logout.
		Assert.assertTrue(!googleHomePage.isUserSignedIn());
	}
	
	public void expectedLogin(String expected) {
		log.info("expected Signed In=" + expected);
	}

}
