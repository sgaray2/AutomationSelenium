package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeliveryInformationPage {
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
public void customerInformation(String name, String email, String phone, String remark) {
	driver.findElement(customerNameInput).sendKeys(name);
	driver.findElement(customerEmailInput).sendKeys(email);
	driver.findElement(customerPhoneInput).sendKeys(phone);
	driver.findElement(remarksInput).sendKeys(remark);
	driver.findElement(paypalMethod).click();
	driver.findElement(newsletter).click();
	driver.findElement(payOrderBtn).click();
}
}
