package testsCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.DeliveryInformationPage;
import pageObjects.HomePage;
import pageObjects.PaypalPage;
import pageObjects.RestaurantMenu;
import pageObjects.RestaurantsList;

public class PaypalPaymentValidation extends Base {

	WebDriver driver= null;
	String expectedResult = "Loggen Sie sich bei PayPal ein";
	
	@BeforeMethod
	public void initializeBrowser() {
		driver = initialize();
	}
	
	@Test
	public void paypalPaymentValidation() throws InterruptedException {
		//home page
		HomePage hp= new HomePage(driver);
		hp.setAddress("Bayerische strasse 25A");
		
		//restaurants list
		RestaurantsList rl= new RestaurantsList(driver);
		rl.showMoreCategories();
		rl.insertCategory("Vegan");
		rl.deliveryFilters();
		rl.selectVeganRestaurant();
		
		//restaurant menu
		RestaurantMenu rm = new RestaurantMenu(driver);
		rm.selectMenu();
		
		//delivery information
		DeliveryInformationPage dip= new DeliveryInformationPage(driver);
		dip.customerInformation("Sabrina Garay", "sabrigaray@gmail.com", "+491773322445", "door bell: 1A");
		
		//Paypal page
		PaypalPage pp = new PaypalPage(driver);
		String actualTitle = pp.getTitle();
		Assert.assertEquals(actualTitle, expectedResult);
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
