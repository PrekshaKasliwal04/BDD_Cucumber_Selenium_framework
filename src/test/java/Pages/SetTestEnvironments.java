package Pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.reporters.Files;

import Leaseplan.Assignment.CommonMethod;
import Leaseplan.Assignment.ConstantPath;
import Leaseplan.Assignment.ObjectReader;
import Leaseplan.Assignment.PreDefinedActions;
import Leaseplan.Assignment.driver.DriverFactory;
import Pages.HomePage;

public class SetTestEnvironments extends CommonMethod {
	private final static Logger LOGGER = Logger.getLogger(PreDefinedActions.class);
	public static String TestCaseName;
	public String filePath;
	
	@BeforeSuite(alwaysRun = true)
	public final void beforeSuite(ITestContext testContext) throws Exception {
		init();
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method MethodName, ITestResult result) throws Exception {
		LOGGER.info("Test Started");
	}

	@AfterMethod(alwaysRun = true)
	public final void aftermethod(ITestResult result, Method MethodName) throws Exception {
		try {
			LOGGER.info("Test Finished  : " + TestCaseName);
		} finally {
			dr.set(null);
			DRIVER.quit();
			LOGGER.info("Browser is closed");
		}
	}

		@AfterSuite(alwaysRun = true)
		public final void afterSuite(ITestContext context) {
	LOGGER.info("Test case execution is completed");
		}

	/**
	 * This method is to read logger file.
	 */
	public final void init() {
		File log4jPropertiesFile = new File(ConstantPath.LOGGER_FILE_PATH);
		if (log4jPropertiesFile.exists()) {
			PropertyConfigurator.configure(ConstantPath.LOGGER_FILE_PATH);
		} else {
			Properties props = new Properties();

			try {
				props.load(
						SetTestEnvironments.class.getClassLoader().getResourceAsStream("properties/log4j.properties"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			PropertyConfigurator.configure(props);
		}
	}
}
