package ui.pages.test;

import org.testng.annotations.Test;

import ui.pages.BasePage;
import ui.pages.HomePage;
import ui.pages.SecondPage;

public class HomePageTest extends BasePage {
	
	HomePage homePageObject = new HomePage(driver);
	SecondPage secondPageObject = new SecondPage(driver);
	
	@Test
	public void search() {
		homePageObject.getTitle();
	}
	
	@Test
	public void searchs() {
		secondPageObject.getTitle();
	}
}
