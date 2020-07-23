package com.kayak.qa.utilities;

import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtilities extends TestBase{
	
	Logger log = Logger.getLogger(getClass().getSimpleName());
	
	public void launchBrowser(String browser) throws Exception {
		log.info("Launching Browser");

		// Check if parameter passed from TestNG is 'firefox'/chrome
		if (browser.toLowerCase().startsWith("ch" )) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			driver = new ChromeDriver(chromeOptions);
		} else if (browser.equalsIgnoreCase("ff") || browser.toLowerCase().startsWith("fi")) {
			// create firefox instance
			WebDriverManager.firefoxdriver().setup();
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("permissions.default.desktop-notification", 1);
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			driver = new FirefoxDriver(capabilities);
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new EdgeDriver();
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().window().maximize();
	}
	
	public void URL()
	{
		driver.get("https://www.kayak.com/");
	}
	
	
	public void quitBrowser()
	{
		driver.quit();
	}

	public void waitForPageElementToVisible(WebElement eleToWait) 
	    {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			wait.until(ExpectedConditions.visibilityOf(eleToWait));
			
		}
	
	
}
