package utilites;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.InternetExplorerDriverManager;

public class Driver {
	
	/* Driver class is reusable class for webDriver and it checks the webDriver on the system.
	 * If there isn't any driver on the system, it downloads the driver and sets up the path and environment  
	 * For this purpose, I've used WebDriver manager
	 * And if I want to run my script on different browser, 
	 * all I have to do is change the browser name in the properties file.
	 */
	
	private static final String sauceURL = "https://helil:f1e966af-121b-43a1-9df2-3825eb0afa22@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	
	private static WebDriver driver;
	public static WebDriver getDriver() {
		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = PropertiesReader.getProperty("browser");
		}
		if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
			switch (browser) {
			case "firefox":
				FirefoxDriverManager.firefoxdriver().setup();
				FirefoxBinary ffBiary = new FirefoxBinary();
				FirefoxOptions options = new FirefoxOptions();
				options.setBinary(ffBiary);
				options.setHeadless(true);
				driver = new FirefoxDriver(options);
				break;
			case "ie":
				InternetExplorerDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			case "chrome":
				ChromeDriverManager.chromedriver().setup();
				ChromeOptions chromeoptions = new ChromeOptions();
				chromeoptions.addArguments("--disable-gpu");
				chromeoptions.addArguments("--no-sandbox");
				driver = new ChromeDriver(chromeoptions);
				break;
			case "sauceLabs":
				sauceConfig();
				break;
			case "chrome-headless":
			default:
				ChromeDriverManager.chromedriver().setup();
				ChromeOptions opts = new ChromeOptions();
				opts.addArguments("--headless");
				opts.addArguments("--disable-gpu");
				opts.addArguments("--no-sandbox");
				opts.addArguments("--window-size=1920,1080");
				driver = new ChromeDriver(opts);
			}
		}
		return driver;
	}
	
	public static void sauceConfig() {
		SafariOptions browserOptions = new SafariOptions();
		browserOptions.setCapability("platformName", "macOS 10.14");
		browserOptions.setCapability("browserVersion", "12");
		Map<String, Object> sauceOptions = new HashMap<>();
		browserOptions.setCapability("sauce:options", sauceOptions);
		try {
			driver = new RemoteWebDriver(new URL(sauceURL), browserOptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}

}
