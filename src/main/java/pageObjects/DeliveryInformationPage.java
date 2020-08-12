package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;

public class DeliveryInformationPage extends Base {
WebDriver driver= null;

public DeliveryInformationPage(WebDriver driver) {
this.driver=driver;	
}

//elements locator
By customerNameInput = By.id("isurname");
By customerEmailInput = By.id("iemail");
By customerPhoneInput = By.id("iphonenumber");
By remarksInput = By.id("iremarks");
By paypalMethod = By.xpath("//div[@class='paymentbuttonwrapper payment-method-type-online paymentmethod18']");
By newsletter = By.id("inewsletter");
By payOrderBtn = By.xpath("//input[@class='button_form cartbutton-button']");

//methods
public void customerInformation(String name, String email, String phone, String remark) throws IOException {
	driver.findElement(customerNameInput).sendKeys(name);
	takeScreenshots(driver,"devName");
	driver.findElement(customerEmailInput).sendKeys(email);
	takeScreenshots(driver,"devEmail");
	driver.findElement(customerPhoneInput).sendKeys(phone);
	takeScreenshots(driver,"devPhone");
	driver.findElement(remarksInput).sendKeys(remark);
	takeScreenshots(driver,"devRemarks");
	driver.findElement(paypalMethod).click();
	takeScreenshots(driver,"devPaypal");
	driver.findElement(newsletter).click();
	takeScreenshots(driver,"devNewsletter");
	driver.findElement(payOrderBtn).click();
	takeScreenshots(driver,"devPay");
}
}
