package ui.pages;

import org.openqa.selenium.WebDriver;

public class SecondPage {

	WebDriver driver;

	public SecondPage(WebDriver driver) {
		this.driver = driver;
	}

	public void getTitle() {
		System.out.println(driver.getTitle());
	}
}
