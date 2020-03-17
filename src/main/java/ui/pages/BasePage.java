package ui.pages;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import ui.util.DriverUtil;

public abstract class BasePage {

	protected WebDriver driver;
	private Properties props = getProperties();

	public BasePage() {
		try {
			String baseUrl = props.getProperty("baseUrl");
			String browser = props.getProperty("defaultBrowser");
			driver = DriverUtil.getDriver(driver, browser, baseUrl);
			Long implicitWaitTimeout = Long.parseLong(props.getProperty("implicitWaitTimeout"));
			driver.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Properties getProperties() {
		props = new Properties();
		String env = "qa";
		try {
			if (env.contains("qa")) {
				props.load(new FileInputStream("src/main/resources/env-qa.properties"));
			} else {
				System.out.println("else mein aa gya");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return props;
	}
}
