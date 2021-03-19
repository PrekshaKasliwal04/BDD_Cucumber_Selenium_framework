package Pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Leaseplan.Assignment.CommonMethod;
import Leaseplan.Assignment.ObjectReader;

public class HomePage extends CommonMethod {
	private ObjectReader HomePagePropertiesReader = new ObjectReader();
	private Properties homePageProperties;

	private HomePage instance;
	public static String environment, URL;

	public HomePage getInstance() throws IOException {
		if (instance == null) {
			synchronized (HomePage.class) {
				if (instance == null) {
					instance = new HomePage(DRIVER);
				}
			}
		}
		return instance;
	}

	public HomePage(WebDriver driver) throws IOException {
		homePageProperties = HomePagePropertiesReader.getObjectRepository("HomePage");
	}

	public final boolean verifyElementsOfHomePage(String key) throws Exception {
		return verifyElementIsPresent(homePageProperties.getProperty(key));
	}
	public final boolean waitForElementsOfHomePage(String key) throws Exception {
		return verifyElementIsVisible(homePageProperties.getProperty(key));
	}
	public final void clickOnElementsOfHomePage(String key) throws Exception {
		click(homePageProperties.getProperty(key));
	}
	

}

