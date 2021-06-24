package yahoo.basepages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import util.FunctionUtil;
import util.Page;
import util.SystemUtil;
import util.TestCaseBase;
import util.TestData;
import util.Waiting;
import yahoo.testcase.account.YahooEditAccountInfoMult;

public class YahooHomePage extends Page {
	
	public static String TITLE="Yahoo";
	public static String URL="https://www.yahoo.com/";
	
	@FindBy(className = "list-title fz-l")
	public WebElement pageLoad;
	
	@FindBy(className = "Grid-U App-Title")
	public WebElement pageLoad_symbol_failure;
	
	@FindBy(className = "My(0) Fz(15px) D(ib) Fw(b)")
	public WebElement pageLoad_goofy;
	
	@FindBy(xpath = ".//*[@class='tab-label fz-xs accent sign-in ']/em")
	public WebElement login;
	
	@FindBy(className = "y-hdr-link sign-up")
	public WebElement createAccount;
	
	@FindBy(xpath = ".//*[@class=\"tab-label fz-xs accent \"]/em")
	public WebElement link_personalInfo;
	
	@FindBy(id = "yucs-acct-info-wrap")
	public WebElement link_personalInfo_symbol_failure;
	
	@FindBy(id="uh-settings")
	public WebElement link_personalInfo_goofy;
			
	@FindBy(linkText = "Hi, Dustin")
	public WebElement signedInUser;
	
	@FindBy(xpath =".//*[@class=\"Grid-U App-Title\"]")
	public WebElement signedInUser_symbol_failure;
	
	@FindBy(id="uh-profile")
	public WebElement signedInUser_goofy;
	/*
	@FindBy(xpath = ".//*[@class=\"uh-menu-btn P(0) Bd(0) Pos(r)\"]")
	public WebElement signedInUser_goofy;
	*/
	@FindBy(className = "y-menu y-fp-ln-pg pt-s y-social-login-menu y-social-signedin-menu account-switch-enabled")
	public WebElement menu;
	
	@FindBy(xpath = ".//*[@class=\"no-link-color signout-all ta-c btn\"]")
	public WebElement logout;
	
	//@FindBy(linkText = "Sign Out")
	@FindBy(id = "yucs-signout")	
	public WebElement logout_symbol_failure; 
	
	@FindBy(id = "yucs-fs-footer")	
	public WebElement logout_menu_symbol_failure; 
	
	@FindBy(id = "uh-signout")
	public WebElement logout_goofy;
	
	//@FindBy(xpath = ".//*[@id='p_30345610-tiles']/li[3]/div/div/a/em")
	//public WebElement mail;
	
	@FindBy(id = "p_13838465-p")
	public WebElement searchInput;
	
	@FindBy(id = "search-submit")
	public WebElement searchSubmit;
	

	public YahooHomePage open() throws Exception {
		//read the url from property file
		Properties PROPERTIES_RESOURCES = SystemUtil
				.loadPropertiesResources("/testdata_yahoo.properties");
		String URL = PROPERTIES_RESOURCES.getProperty("yahoo.url");
		TestCaseBase.threadDriver.get().navigate().to(URL);

		return this;
	}

	//goto sign in page
	public YahooLoginPage gotoLoginPage() throws Exception {
		Waiting.until(login);
		login.click();
		
		return new YahooLoginPage();
	}
	
	public YahooPersonalInfoPage gotoPersonalInfoPage() {
		if (FunctionUtil.isExist(link_personalInfo)) {
			Waiting.until(link_personalInfo);
			link_personalInfo.click();
		} else if (FunctionUtil.isExist(link_personalInfo_symbol_failure)) {
			((JavascriptExecutor)TestCaseBase.threadDriver.get()).executeScript("arguments[0].style.visibility='visible';", link_personalInfo_symbol_failure);
			
			//link_personalInfo_symbol_failure.click();
			
			TestCaseBase.threadDriver.get().get("https://login.yahoo.com/account/personalinfo?.intl=us&.lang=en-US&.done=https://www.yahoo.com/&.src=fpctx");
		} else if (FunctionUtil.isExist(link_personalInfo_goofy)) {
			((JavascriptExecutor)TestCaseBase.threadDriver.get()).executeScript("arguments[0].style.visibility='visible';", link_personalInfo_goofy);
			
			link_personalInfo_goofy.click();
		}
		
		return new YahooPersonalInfoPage();
	}
	
	//sign out
	public YahooHomePage logout() throws InterruptedException {		
		/*
		if (FunctionUtil.isExist(logout)) {
			((JavascriptExecutor)TestCaseBase.threadDriver.get()).executeScript("arguments[0].style.visibility='visible';", logout);
			
			logout.click();
		} else if (FunctionUtil.isExist(logout_goofy)) {
			((JavascriptExecutor)TestCaseBase.threadDriver.get()).executeScript("arguments[0].style.visibility='visible';", logout_goofy);
			
			logout_goofy.click();
		} else if (FunctionUtil.isExist(logout_symbol_failure)) {
			//((JavascriptExecutor)TestCaseBase.threadDriver.get()).executeScript("arguments[0].style.visibility='visible';", logout_menu_symbol_failure);
			((JavascriptExecutor)TestCaseBase.threadDriver.get()).executeScript("arguments[0].style.visibility='visible';", logout_symbol_failure);
			
			Waiting.until(logout_symbol_failure);
			
			//TestCaseBase.threadDriver.get().get("https://login.yahoo.com/config/login/?.crumb=UtB44vmXZMc&logout=1&.direct=1&.done=https://www.yahoo.com/&logout_all=1");
			logout_symbol_failure.click();
		}
		*/		
		
		if (TestCaseBase.threadDriver.get().findElements(By.xpath(".//*[@class=\"no-link-color signout-all ta-c btn\"]")).size() > 0) {
			((JavascriptExecutor)TestCaseBase.threadDriver.get()).executeScript("arguments[0].style.visibility='visible';", logout);
			if (FunctionUtil.isExist(logout)) {
				logout.click();
			}
			//logout.click();	
		} else if (TestCaseBase.threadDriver.get().findElements(By.id("yucs-signout")).size() > 0) {
			((JavascriptExecutor)TestCaseBase.threadDriver.get()).executeScript("arguments[0].style.visibility='visible';", logout_symbol_failure);
			if (FunctionUtil.isExist(logout_symbol_failure)) {
				((JavascriptExecutor)TestCaseBase.threadDriver.get()).executeScript("arguments[0].style.visibility='visible';", logout_menu_symbol_failure);
				
				//logout_symbol_failure.click();
				TestCaseBase.threadDriver.get().get("https://login.yahoo.com/config/login/?.crumb=UtB44vmXZMc&logout=1&.direct=1&.done=https://www.yahoo.com/&logout_all=1");
				TestCaseBase.threadDriver.get().get("https://yahoo.com");
			}
			//TestCaseBase.threadDriver.get().get("https://login.yahoo.com/config/login/?.crumb=UtB44vmXZMc&logout=1&.direct=1&.done=https://www.yahoo.com/&logout_all=1");
			//logout_symbol_failure.click();
		} else if (TestCaseBase.threadDriver.get().findElements(By.id("uh-signout")).size() > 0) {
			((JavascriptExecutor)TestCaseBase.threadDriver.get()).executeScript("arguments[0].style.visibility='visible';", logout_goofy);
			if (FunctionUtil.isExist(logout_goofy)) {
				logout_goofy.click();
			}
			//logout_goofy.click();
		} 
		
		return this;
	}
	
	//this is for assertion. checking if user is signed in
	public boolean isUserSignedIn() {
		//String browserFlag = TestCaseBase.browserFlag;
		boolean result = false;
		
		if (FunctionUtil.isExist(signedInUser)) {
			result = true;
		} else if (FunctionUtil.isExist(signedInUser_symbol_failure)) {
			result = true;
		} else if (FunctionUtil.isExist(signedInUser_goofy)) {
			result = true;
		} 
		
		/*
		if (TestCaseBase.threadDriver.get().findElements(By.linkText("Hi, Dustin")).size() >= 0) {
			((JavascriptExecutor)TestCaseBase.threadDriver.get()).executeScript("arguments[0].style.visibility='visible';", signedInUser);
			result = true;
			
		} else if (TestCaseBase.threadDriver.get().findElements(By.linkText("Dustin")).size() >= 0) {
			((JavascriptExecutor)TestCaseBase.threadDriver.get()).executeScript("arguments[0].style.visibility='visible';", signedInUser_symbol_failure);
			result = true;
			
		} else if (TestCaseBase.threadDriver.get().findElements(By.linkText("Hi, Dustin")).size() >= 0) {
			((JavascriptExecutor)TestCaseBase.threadDriver.get()).executeScript("arguments[0].style.visibility='visible';", signedInUser_goofy);
			result = true;
		}
		*/
		log.info("actual Signed In="+result);
		
		return result;
	}
	
	//use this method to wait until the page loads. 
	//usually it is not the page loads but a specific element loads
	//here we use loginLink, because our test cases need to use this link
	//so if this link is visible, the test cases can continue
	public YahooHomePage waitPageLoad() throws InterruptedException {
		//Thread.sleep(2000);
		//Waiting.implicitly(2);
		
		if (FunctionUtil.isExist(pageLoad)) {
			Waiting.until(pageLoad,5000);
		} else if (FunctionUtil.isExist(pageLoad_symbol_failure)) {
			Waiting.until(pageLoad_symbol_failure,5000);
		} else if (FunctionUtil.isExist(pageLoad_goofy)) {
			Waiting.until(pageLoad_goofy,5000);
		} 		
		
		return this;
	}
	
	public YahooHomePage search (String search) {
		Waiting.until(searchInput);
		searchInput.clear();
		searchInput.sendKeys(search);
		
		return this;
	}
	
	public YahooSearchResultsPage gotoYahooSearchResultsPage() {
		Waiting.until(searchSubmit);
		searchSubmit.click();
		
		return new YahooSearchResultsPage();
	}
}
