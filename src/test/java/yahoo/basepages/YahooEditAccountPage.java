package yahoo.basepages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Page;
import util.TestCaseBase;
import util.Waiting;
import yahoo.testcase.account.YahooEditAccountDataLoader;

public class YahooEditAccountPage extends Page {
	
	public static String TITLE = "Your Contact Information";
	
	@FindBy(id = "Title")
	public WebElement text_title;
	
	@FindBy(id = "GivenName")
	public WebElement text_firstName;
	
	@FindBy(id = "FamilyName")
	public WebElement text_lastName;
	
	@FindBy(id = "ImHandle0")
	public WebElement text_messenger;
	
	@FindBy(id = "MobileNumber0")
	public WebElement text_mobile;
	
	@FindBy(id = "PhoneNumber0")
	public WebElement text_homePhone;
	
	@FindBy(id = "PhoneNumber1")
	public WebElement text_workPhone;
	
	@FindBy(id = "PhoneNumber2")
	public WebElement text_homeFax;
	
	@FindBy(id = "PhoneNumber3")
	public WebElement text_workFax;
	
	@FindBy(id = "AddressTxt0")
	public WebElement text_homeAddress;
	
	@FindBy(id = "City0")
	public WebElement text_homeCity;
	
	@FindBy(id = "PostalCode0")
	public WebElement text_homeZIP;
	
	@FindBy(id = "AddressTxt1")
	public WebElement text_workAddress;
	
	@FindBy(id = "City1")
	public WebElement text_workCity;
	
	@FindBy(id = "PostalCode1")
	public WebElement text_workZIP;
	
	@FindBy(id = "WebsiteURL0")
	public WebElement text_website;
	
	@FindBy(id = "SaveBtn")
	public WebElement button_save;
	
	private List<CSVRecord> ha_records;
	private List<CSVRecord> hf_records;
	private List<CSVRecord> hp_records;
	private List<CSVRecord> m_records;
	private List<CSVRecord> n_records;
	private List<CSVRecord> s_records;
	private List<CSVRecord> wa_records;
	private List<CSVRecord> wf_records;
	private List<CSVRecord> wp_records;
	
	public YahooEditAccountPage readContents() throws Exception {
		ArrayList<Reader> csvData = new ArrayList<Reader>();
		csvData.add(new FileReader("testdata/yahoo/test_home_address.csv")); 
		csvData.add(new FileReader("testdata/yahoo/test_home_fax.csv")); 
		csvData.add(new FileReader("testdata/yahoo/test_home_phone.csv")); 
		csvData.add(new FileReader("testdata/yahoo/test_mobile.csv")); 
		csvData.add(new FileReader("testdata/yahoo/test_name.csv")); 
		//csvData.add(new FileReader("testdata/yahoo/test_success.csv")); 
		csvData.add(new FileReader("testdata/yahoo/test_work_address.csv")); 
		csvData.add(new FileReader("testdata/yahoo/test_work_fax.csv")); 
		csvData.add(new FileReader("testdata/yahoo/test_work_phone.csv")); 
		
		ha_records = CSVFormat.EXCEL.withHeader().parse(csvData.get(0)).getRecords();
		hf_records = CSVFormat.EXCEL.withHeader().parse(csvData.get(1)).getRecords();
		hp_records = CSVFormat.EXCEL.withHeader().parse(csvData.get(2)).getRecords();
		m_records = CSVFormat.EXCEL.withHeader().parse(csvData.get(3)).getRecords();
		n_records = CSVFormat.EXCEL.withHeader().parse(csvData.get(4)).getRecords();
		wa_records = CSVFormat.EXCEL.withHeader().parse(csvData.get(5)).getRecords();
		wf_records = CSVFormat.EXCEL.withHeader().parse(csvData.get(6)).getRecords();
		wp_records = CSVFormat.EXCEL.withHeader().parse(csvData.get(7)).getRecords();
		//s_records = CSVFormat.EXCEL.withHeader().parse(csvData.get(5)).getRecords();
		
		return this;
	}
	
	public YahooEditAccountPage clearContents() {
		Waiting.until(text_title);
		text_title.clear();
		text_firstName.clear();
		text_lastName.clear();
		//text_mobile.clear();
		//text_homePhone.clear();
		//text_workPhone.clear();
		//text_homeFax.clear();
		//text_workFax.clear();
		text_homeAddress.clear();
		text_homeCity.clear();
		text_homeZIP.clear();
		text_workAddress.clear();
		text_workCity.clear();
		text_workZIP.clear();
		
		return this;
	}
	
	public YahooPersonalInfoPage updateContactInfo(int index) throws Exception {
		Waiting.until(text_title);
		/*
		text_title.sendKeys(YahooEditAccountDataLoader.records.get(0).get(index).get("Title"));
		text_firstName.sendKeys(YahooEditAccountDataLoader.records.get(0).get(index).get("FirstName"));
		text_lastName.sendKeys(YahooEditAccountDataLoader.records.get(0).get(index).get("LastName"));
		text_homeAddress.sendKeys(YahooEditAccountDataLoader.records.get(1).get(index).get("Street"));
		text_homeCity.sendKeys(YahooEditAccountDataLoader.records.get(1).get(index).get("City"));
		text_homeZIP.sendKeys(YahooEditAccountDataLoader.records.get(1).get(index).get("ZIP"));
		text_workAddress.sendKeys(YahooEditAccountDataLoader.records.get(2).get(index).get("Street"));
		text_workCity.sendKeys(YahooEditAccountDataLoader.records.get(2).get(index).get("City"));
		text_workZIP.sendKeys(YahooEditAccountDataLoader.records.get(2).get(index).get("ZIP"));
		*/
		
		text_title.sendKeys(n_records.get(index).get("Title"));	
		text_firstName.sendKeys(n_records.get(index).get("FirstName"));
		text_lastName.sendKeys(n_records.get(index).get("LastName"));
		//text_mobile.sendKeys(m_records.get(index).get("Phone"));
		//text_homePhone.sendKeys(hp_records.get(index).get("Phone"));
		//text_workPhone.sendKeys(wp_records.get(index).get("Phone"));
		//text_homeFax.sendKeys(hf_records.get(index).get("Phone"));
		//text_workFax.sendKeys(wf_records.get(index).get("Phone"));
		text_homeAddress.sendKeys(ha_records.get(index).get("Street"));
		text_homeCity.sendKeys(ha_records.get(index).get("City"));
		text_homeZIP.sendKeys(ha_records.get(index).get("ZIP"));
		text_workAddress.sendKeys(wa_records.get(index).get("Street"));
		text_workCity.sendKeys(wa_records.get(index).get("City"));
		text_workZIP.sendKeys(wa_records.get(index).get("ZIP"));
		
		Waiting.implicitly(2);
		Waiting.until(button_save);
		button_save.click();		
		
		//Thread.sleep(1500);
		Waiting.implicitly(2);
		if (TestCaseBase.threadDriver.get().getCurrentUrl() != YahooPersonalInfoPage.URL) {
			Thread.sleep(1000);
			TestCaseBase.threadDriver.get().get(YahooPersonalInfoPage.URL);
		}
		
		return new YahooPersonalInfoPage();
	}
	
	public YahooEditAccountPage waitPageLoad() throws InterruptedException {
		Waiting.until(text_title);

		return this;
	}
	
	public int recordSize() {
		return ha_records.size();
	}

}
