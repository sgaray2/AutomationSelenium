package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestaurantMenu {

	WebDriver driver=null;
	
	public RestaurantMenu(WebDriver driver) {
		this.driver= driver;
	}
	
	//elements locators
	By suppenCategory = By.xpath("//a[contains(text(),'Suppen')]");
	
	
	
	//methods
	public void selectCategory() {
		driver.findElement(suppenCategory).click();
	}
}
