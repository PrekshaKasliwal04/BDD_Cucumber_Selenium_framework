package Leaseplan.Assignment.driver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import Leaseplan.Assignment.CommonVariables;
import Leaseplan.Assignment.ConstantPath;

public class DriverFactory {
	private final static Logger LOGGER = Logger.getLogger(DriverFactory.class);

	public static WebDriver setDriver(String browserType) {
		WebDriver driver;
		switch (browserType.toUpperCase()) {
		case "CHROME":
			driver = initChromeDriver();
			break;
		case "FIREFOX":
			driver = initFirefoxDriver();
			break;
		default:
			LOGGER.info("Browser : " + browserType + " Currently we support windows based browsers - Chrome and Firefox, Launching Firefox as Default browser..");
			driver = initFirefoxDriver();
		}
		return driver;
	}

	// Method to open chrome browser
	private static WebDriver initChromeDriver() {
		LOGGER.info("Launching chrome browser..");

		if (new File(ConstantPath.CHROME_EXE_PATH).exists()) {
			// This is for Eclipse IDE
			System.setProperty("webdriver.chrome.driver", ConstantPath.CHROME_EXE_PATH);
		} else {
			File chromeDriver = new File("lib" + File.separator + "chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
		}
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leaseplan.com/en-be/");
		driver.navigate().to("https://www.leaseplan.com/en-be/business/showroom");		
		driver.manage().timeouts().implicitlyWait(CommonVariables.IMPLICITWAIT, TimeUnit.SECONDS);
		driver.manage().getCookies(); 
		driver.manage().getCookieNamed("Accept Cookies");
		return driver;
	}

	// Method to open Firefox browser
	private static WebDriver initFirefoxDriver() {
		LOGGER.info("Launching Firefox browser..");

		System.setProperty("webdriver.gecko.driver", "lib" + File.separator + "geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
	    WebDriver	driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leaseplan.com/en-be/");
		driver.navigate().to("https://www.leaseplan.com/en-be/business/showroom");
		driver.manage().getCookies(); 
		driver.manage().getCookieNamed("Accept Cookies");		
		return driver;
	
	}

}
