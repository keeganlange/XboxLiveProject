package yahoo.basepages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Page;
import util.TestCaseBase;
import util.Waiting;

public class YahooSearchResultsPage extends Page {
	
	@FindBy(className = " ac-21th")
	public WebElement firstLink;
	
	@FindBy(className = "sbb")
	public WebElement pageLoad;
	
	public PerficientHomePage clickFirstLink() throws InterruptedException {
		Waiting.until(firstLink);
		firstLink.click();
		
		Thread.sleep(2000);
		
		if (TestCaseBase.browserFlag.equals("firefox")) {
			Set<String> windows = TestCaseBase.threadDriver.get().getWindowHandles();
			TestCaseBase.threadDriver.get().switchTo().window(windows.toArray()[1].toString());
		} else {
			ArrayList<String> tabs2 = new ArrayList<String>(TestCaseBase.threadDriver.get().getWindowHandles());
			TestCaseBase.threadDriver.get().switchTo().window(tabs2.get(1));
		}
		
		return new PerficientHomePage();
	}
	
	public YahooSearchResultsPage waitPageLoad() {
		Waiting.until(pageLoad);
		
		return this;
	}
	
}
