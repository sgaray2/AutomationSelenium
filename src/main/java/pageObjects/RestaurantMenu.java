package pageObjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class RestaurantMenu extends Base{

	WebDriver driver=null;
	
	public RestaurantMenu(WebDriver driver) {
		this.driver= driver;
	}
	
	//elements locators
	By suppenCategory = By.xpath("//a[contains(text(),'Suppen')]");
	By menuSelected = By.xpath("//div[@class='js-meal__add-to-basket-button menucard-meal__sidedish-button']");
	By orderBtn = By.xpath("//button[@class='basket__order-button cartbutton-button']");
	
	//methods
	public void selectCategory() throws IOException {
		driver.findElement(suppenCategory).click();
		takeScreenshots(driver,"suppenCategory");
	}
	
	public void selectMenu() throws IOException {
		WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(menuSelected));
		menu.click();
		takeScreenshots(driver,"menuSelected");
		driver.findElement(orderBtn).click();
	}
}
