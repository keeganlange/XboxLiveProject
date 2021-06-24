package google.testcase.search;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import google.basepages.GoogleHomePage;
import google.basepages.GoogleMapPage;
import util.TestCaseBase;
import util.TestData;
import util.Waiting;

public class TC_02_GoogleMapSearch extends TestCaseBase {
	
	@Test(groups = { "firefox", "ChromeWin32", "exludedTest" })
	public void testSearchMap() throws Exception {
		String mapSearchResultPerficient = TestData.get("result.perficient");
		String mapSearchInput = TestData.get("input");
		
		
		GoogleHomePage googleHomePage = new GoogleHomePage();
		googleHomePage.open();
		googleHomePage.waitPageLoad();
		assert (googleHomePage.titleIs(GoogleHomePage.TITLE));
		
		GoogleMapPage googleMapPage = googleHomePage.gotoGoogleMap();
		googleMapPage.waitPageLoad();
		
		assert (googleMapPage.titleIs(GoogleMapPage.TITLE));
		
		googleMapPage.search(mapSearchInput);
		googleMapPage.waitPageLoad();
		assert (googleMapPage.searchResultTitleContains(mapSearchResultPerficient));
		
		WebElement restaurant = googleMapPage.findRestaurant();
		googleMapPage.directionsToRestaurant(mapSearchInput,restaurant);
		
		expected.put("suggested_route",TestData.get("result.suggestroute"));
		actualResult = googleMapPage.suggestedRoute.getText();
		assertion.equals(actualResult, expected, "suggested_route");
	}
}
