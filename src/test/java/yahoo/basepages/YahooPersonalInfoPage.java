package yahoo.basepages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Page;
import util.Waiting;

public class YahooPersonalInfoPage extends Page {
	
	public static String TITLE = "Personal Info - Yahoo Account Settings";
	public static String URL = "https://login.yahoo.com/account/personalinfo";
	
	@FindBy(xpath = ".//*[@class=\"spread\"][1]")
	public WebElement link_editAccount;
	
	@FindBy(xpath = ".//*[@class='content-title']/h1")
	public WebElement pageLoad;
	
	public YahooEditAccountPage gotoEditAccountPage() {
		//Waiting.until(link_editAccount);
		Waiting.implicitly(2);
		link_editAccount.click();
		
		return new YahooEditAccountPage();
	}
	
	public YahooPersonalInfoPage waitPageLoad() throws InterruptedException {
		Waiting.until(pageLoad);

		return this;
	}
}
