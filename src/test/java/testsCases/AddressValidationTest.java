package testsCases;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;

import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.RestaurantsList;

public class AddressValidationTest extends Base {
	public String expectedResult = "Düsseldorfer Straße 51, 10707 Berlin";
	public String addressData = "Düsseldorfer Straße 51, 10707 Berlin";
		
	@BeforeTest
	public void initializeBrowser() {
		//calling the initialize method created in base class.
		driver = initialize();
	}
	
		@Test
		public void addressTest() {
			//creating a new HomePage object and passing the driver
			HomePage homePageObj = new HomePage(driver);
			//calling the method setAddress defined in HomePage
			homePageObj.setAddress(addressData);
			//Creating a new restaurant list object and passing the driver
			RestaurantsList restList = new RestaurantsList(driver);
			//saving the actual result
			String actualResult = restList.getAddress();
			//Validating the results
			Assert.assertEquals(actualResult, expectedResult);	
		}
		
		@AfterTest
		public void closeBrowser() {
			tearDown();
		}
		
		}
	
