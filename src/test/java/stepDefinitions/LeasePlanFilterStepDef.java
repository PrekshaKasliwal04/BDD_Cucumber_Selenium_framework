package stepDefinitions;

import java.io.IOException;

import Leaseplan.Assignment.PreDefinedActions;
import Leaseplan.Assignment.driver.DriverFactory;
import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LeasePlanFilterStepDef {

	DriverFactory driver = new DriverFactory();
	@Given("User is on Lease Plan Business website")
	public final void openURL() throws Exception {
		HomePage homePage = new HomePage(PreDefinedActions.getDriver()).getInstance();
		driver.setDriver("firefox");
		homePage.waitForElementsOfHomePage("acceptCookie");
		homePage.clickOnElementsOfHomePage("acceptCookies");

	}
	@When("User views car from best deal popular filter")
	public void bestDealCar() throws Exception {
		HomePage homePage = new HomePage(PreDefinedActions.getDriver()).getInstance();
		homePage.clickOnElementsOfHomePage("popularFilter");
		homePage.clickOnElementsOfHomePage("bestDeals");
		homePage.clickOnElementsOfHomePage("save");
		homePage.clickOnElementsOfHomePage("viewCar");		
	}
 
	@Then("User should see Car details")
	public void carDetailsPage() throws IOException {
        HomePage homePage = new HomePage(PreDefinedActions.getDriver()).getInstance();
        homePage.getUrlOfCurrentPage().contains("our-cars");     
	}
 
	
	

	

}
