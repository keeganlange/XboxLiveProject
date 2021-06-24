package xboxProject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;


public class xboxlive{
  
	String baseUrl = "https://www.xboxgamertag.com/";
	public WebDriver driver;

	@BeforeMethod
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
		// Click the leader board
		WebElement leaderboard = driver.findElement(By.linkText("Leaderboards"));
		leaderboard.click();
		// Make lists to hold to gamers and score values for comparison later
		// I understand that it would be better to store a list of tuples 
		ArrayList<String> gamers = new ArrayList<String>();
		ArrayList<String> scores = new ArrayList<String>();
		
		// get the list of gamers
		WebElement listOfGamers = driver.findElement(By.className("row"));
		String[] theList = listOfGamers.getText().split("\n");
		int count = 0;
		// This iterates through and grabs the scores and gamer tags of the first 5 and adds them to the 2 ArrayLists create before
		for(int i = 0; i < theList.length-1; i++) {
			// Ensure it doesn't get an error from trying to index out of bounds
			try {
				String x = theList[i+2];
			}catch (Exception e) {
				break;
			}
			if(theList[i].matches("[1-5]")) {
				System.out.println(theList[i+1]);
				gamers.add(theList[i+1]);
				scores.add(theList[i+2]);
				System.out.println(theList[i+2]);
				count += 1;
			}
			else if(count >= 5){
				System.out.println("Done");
				break;
			}
		}
		// cleans the scores to be converted to ints and ensures that they are ranked correctly
		for(int j = 0; j < gamers.size()-1; j++) {
			String cleaner = scores.get(j).replace(",", "");
			int intScoreGreater = Integer.parseInt(cleaner);
			System.out.println(intScoreGreater);
			cleaner = scores.get(j+1).replace(",", "");
			int intScoreLesser = Integer.parseInt(cleaner);
			System.out.println(intScoreLesser);
			Assert.assertTrue(intScoreGreater > intScoreLesser);
		}
		
		
	}
	
	
	@Test
	public void xblUser() {
		// I understand that this is hard coded if it was different that the first 4 games would be validated differently
		List<String> first4Games = new ArrayList<String>();
		first4Games.add("League of Legends");first4Games.add("Fortnite");first4Games.add("DARK SOULS™ II");first4Games.add("Skyrim");
		// Grab the search box
		WebElement searchBox = driver.findElement(By.name("s"));
		// Input gamer tag
		searchBox.sendKeys("Duskamo");
		searchBox.sendKeys(Keys.ENTER);
		
		// For loop displays the first 4 games and ensures they are displayed on the page and its the correct 4
		List<WebElement> allGames = driver.findElements(By.className("game-card-desc"));
		for(int i = 0; i < allGames.size() - 1; i++) {
			if(i >= 4) {
				break;
			}
			
			WebElement gameTitle = allGames.get(i).findElement(By.tagName("h3"));
			System.out.println(gameTitle.getText());
			if(gameTitle.isDisplayed()) {
				System.out.println("Title is displayed");
			}else {
				System.out.println("Title is NOT displayed");
			}
			
			assert first4Games.contains(gameTitle.getText());
		}
	}
	

	@AfterMethod
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
}

