package testsCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.Base;

public class PaypalPaymentValidation extends Base {

	WebDriver driver= null;
	
	@BeforeMethod
	public void initializeBrowser(WebDriver driver) {
		this.driver=driver;
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
