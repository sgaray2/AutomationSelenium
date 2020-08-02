package pageObjects;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	/*declaring driver to then assign it to the driver instance from our test*/ 
	WebDriver driver;
	
/*constructor, taking the driver instance from the calling class*/
	public HomePage(WebDriver driver) {
	this.driver=driver;	
	}

//creating the objects and providing the elements locator.
By addressInput = By.id("imysearchstring");
By cookies = By.className("cc-banner__btn-ok");
By selectedAddress = By.xpath("//a[@class='lp__place notranslate selected']");

//creating methods for objects actions method to send keys on the addressInput 
public void setAddress(String addressData) {
	driver.findElement(cookies).click();
	WebElement input = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(addressInput));
	input.click();
	//selecting my current location
	input.sendKeys(addressData);
	WebElement addressList = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(selectedAddress));
	addressList.click();
	

}
}

