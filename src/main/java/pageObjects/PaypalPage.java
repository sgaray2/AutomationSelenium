package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import base.Base;

public class PaypalPage extends Base {
WebDriver driver=null;

public PaypalPage(WebDriver driver) {
this.driver=driver;	
}

//method to get the current page title and validate in my TC.
public String getTitle() throws IOException {
	String title = driver.getTitle();
	takeScreenshots(driver,"PaypalPage");
	return title;
}
}
