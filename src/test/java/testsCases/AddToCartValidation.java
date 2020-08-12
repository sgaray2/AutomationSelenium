package testsCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.HomePage;
import pageObjects.RestaurantsList;

public class AddToCartValidation extends Base {
	
	public String addressData = "Bayerische Straﬂe 25, Berlin"; 
	
	@BeforeMethod
	public void initializeBrowser() 
	{
		//calling the initialize method created in base class.
		driver = initialize();
	}

	@Test
	public void addItemToCart() throws IOException {
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
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
