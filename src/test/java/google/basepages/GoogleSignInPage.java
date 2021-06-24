package google.basepages;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveMouseAction;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import util.FunctionUtil;
import util.Page;
import util.SystemUtil;
import util.TestCaseBase;
import util.Waiting;

public class GoogleSignInPage extends Page{
	public static String TITLE = "Google Accounts";
	
	@FindBy(id = "Email")
	public WebElement email;
	
	@FindBy(xpath="//input[@value='Next' and @type='submit']")
//	@FindBy(xpath="//input[@value='Next']")
	public WebElement button_Next;

	@FindBy(id = "Passwd")
	public WebElement password;

	@FindBy(id = "signIn")
	public WebElement signIn;

	@FindBy(id = "PersistentCookie")
	public WebElement staySignIn;



	public boolean titleContains(String title) {
		
		return (TestCaseBase.threadDriver.get().getTitle().contains(title));
	}

	public GoogleHomePage signIn(String usr, String pwd) throws Exception {
		email.sendKeys(usr);

		FunctionUtil.waitForElementExist(button_Next);

		button_Next.click();
		button_Next.submit();

		
		Waiting.until(password);
		password.sendKeys(pwd);
		
		if (staySignIn.isSelected()) {
			staySignIn.click();
		}
		

		signIn.click();

		return new GoogleHomePage();
	}

	public GoogleSignInPage waitPageLoad() throws InterruptedException {
		Waiting.until(email);
		return this;
	}

}
