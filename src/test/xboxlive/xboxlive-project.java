package xboxlive;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class xboxlive-project
{
  
	String baseUrl = "https://www.xboxgamertag.com/";
	public WebDriver driver;

	@BeforeTest
	public void browserSetup() {

		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Keegan.Lange\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);

	}
	
	@Test
	public void top5gamers() {
		WebElement leaderboard = driver.findElement(By.linkText("Leaderboards"));
		leaderboard.click();
		
	}
	
	

	@AfterTest
	public void terminateBrowser() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		driver.close();
}
