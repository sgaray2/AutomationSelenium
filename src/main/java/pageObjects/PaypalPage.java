package pageObjects;

import org.openqa.selenium.WebDriver;

public class PaypalPage {
WebDriver driver=null;

public PaypalPage(WebDriver driver) {
this.driver=driver;	
}

//method to get the current page title and validate in my TC.
public String getTitle() {
	String title = driver.getTitle();
	return title;
}
}
