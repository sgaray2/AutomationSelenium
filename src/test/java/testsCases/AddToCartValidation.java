package testsCases;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.HomePage;
import pageObjects.RestaurantsList;

public class AddToCartValidation extends Base {
	
	public String addressData = "Bayerische Straﬂe 25, Berlin"; 
	
	@BeforeTest
	public void initializeBrowser() 
	{
		//calling the initialize method created in base class.
		driver = initialize();
	}

	@Test
	public void addItemToCart() {
		//Creating a home page object
		HomePage hp = new HomePage(driver);
		hp.setAddress(addressData);
		//Creating a restaurant list object
		RestaurantsList rl = new RestaurantsList(driver);
		rl.getItalianFood();
		rl.selectRestaurant();
		rl.selectRestaurantItem();
		
		//Saving the item and total prices
		String itemPrice = rl.getPrice();
		String totalPriceExpected = rl.getTotalPrice();
		
		//Compare the item price against the total price shown.
		Assert.assertEquals(itemPrice, totalPriceExpected);
		
	}
	
	@AfterTest
	public void closeBrowser() {
		tearDown();
	}
}
