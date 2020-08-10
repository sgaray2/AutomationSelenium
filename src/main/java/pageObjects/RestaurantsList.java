package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;


public class RestaurantsList extends Base {
	
	/*declaring driver to then assign it to the driver instance from our test*/ 
	WebDriver driver;

/*constructor, taking the driver instance from the calling class*/
public RestaurantsList(WebDriver driver) {
	this.driver=driver;
}

//elements locator
By restListAddress = By.xpath("//button[@class='topbar__title js-header-location-update notranslate show-location']");
By italianFood = By.xpath("//a[@class='filter-label subcatlink swiper-slide kitchen-types__category js-kitchen-types__kitchen-type swiper-slide-next']");
By restaurantSelected = By.id("irestaurantO3QNOPN1");
By addToCart = By.xpath("//div[@id='popularOP70OPN7R']//div[@class='js-meal__add-to-basket-button menucard-meal__sidedish-button']");
By addToCartBtn = By.xpath("//button[@class='cartbutton-button cartbutton-button-sidedishes add-btn-icon']");
By itemPrice = By.xpath("//div[@id='popularOP70OPN7R']//div[@class='meal__price notranslate'][contains(text(),'8,90')]");
By totalPrice = By.xpath("//span[@class='cart-sum-price notranslate'][contains(text(),'8,90')]");

//methods
public String getAddress() {
	WebElement addressTitle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(restListAddress));
	String address = addressTitle.getText();
	return address;
}

//click on italian food option
public void getItalianFood() {
	driver.findElement(italianFood).click();
}

//click on a restaurant from the italian list restaurants
public void selectRestaurant() {
	driver.findElement(restaurantSelected).click();
}

//click on an item from the restaurant menu
public void selectRestaurantItem() {
	driver.findElement(addToCart).click();
	WebElement addBtn = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
	addBtn.click();
}

public String getPrice()
    {
	WebElement priceW = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(itemPrice));
	String price = priceW.getText();
	return price;
}

public String getTotalPrice() {
	WebElement totalW = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(totalPrice));
	String total = totalW.getText();
	return total;
}

}
