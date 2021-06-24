package yahoo.basepages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Page;
import util.Waiting;

public class YahooLoginPage extends Page {
	
	public static String TITLE = "Yahoo - login";

	@FindBy(id = "login-username")
	public WebElement input_email;
	
	@FindBy(id = "login-passwd")
	public WebElement input_pass;
	
	@FindBy(id = "login-signin")
	public WebElement button_submit;
	
	public YahooHomePage signIn(String usr, String pwd) throws Exception {
		Waiting.until(button_submit);
		
		input_email.sendKeys(usr);
		input_pass.sendKeys(pwd);
		
		button_submit.click();
		
		return new YahooHomePage();
	}

	public YahooLoginPage waitPageLoad() throws InterruptedException {
		Waiting.until(button_submit);
		return this;
	}
}
