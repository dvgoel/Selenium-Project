package ui.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

public class DriverUtil {
	private static Properties props;
	private static final String DRIVER_PROP_FILE = "src/main/resources/driver.properties";

	public static WebDriver getDriver(WebDriver driver, String browser, String baseUrl)
			throws FileNotFoundException, IOException {
		props = new Properties();
		props.load(new FileInputStream(DRIVER_PROP_FILE));

		switch (browser) {
		case "chrome":
			driver = initChromeDriver(driver);
			break;
		case "firefox":
			driver = initFirefoxDriver(driver);
			break;
		case "ie":
			driver = initIEDriver(driver);
		default:
			System.out.println("browser : " + browser + " is invalid, Launching Firefox as browser of choice..");
			driver = initChromeDriver(driver);
		}
		driver.get(baseUrl);
		driver.manage().window().maximize();
		return driver;
	}

	private static WebDriver initChromeDriver(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", props.getProperty(Constants.CHROME_DRIVER_WIN));
		driver = new ChromeDriver();
		return driver;
	}

	private static WebDriver initFirefoxDriver(WebDriver driver) {
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability(CapabilityType.BROWSER_VERSION, 48);
		System.setProperty("webdriver.gecko.driver", props.getProperty(Constants.FIREFOX_DRIVER_WIN));
		driver = new FirefoxDriver(options);
		return driver;
	}

	private static WebDriver initIEDriver(WebDriver driver) {
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.introduceFlakinessByIgnoringSecurityDomains();
		options.ignoreZoomSettings();

		System.setProperty("webdriver.ie.driver", props.getProperty(Constants.IE_DRIVER_WIN));
		driver = new InternetExplorerDriver(options);
		return driver;
	}

}
