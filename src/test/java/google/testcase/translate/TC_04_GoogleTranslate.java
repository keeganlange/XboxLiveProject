package google.testcase.translate;

import org.testng.Assert;
import org.testng.annotations.Test;
import google.basepages.GoogleTranslatePage;
import util.TestCaseBase;
import util.TestData;

public class TC_04_GoogleTranslate extends TestCaseBase {
	
	@Test(groups = { "firefox", "ChromeWin32" })
	public void testTranslate() throws Exception 
	{
		String input = TestData.get("translate.input");
		String expected = TestData.get("translate.result");

		GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage();
		googleTranslatePage.open();
		googleTranslatePage.waitPageLoad();
		Assert.assertTrue(googleTranslatePage.titleIs(GoogleTranslatePage.TITLE));
		
		googleTranslatePage.translateInput(input);
		googleTranslatePage.waitResultLoad();
	    Assert.assertTrue(googleTranslatePage.contain(expected));
	}
}
