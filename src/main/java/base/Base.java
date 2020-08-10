package base;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver = null;
	
	//browser config
	public WebDriver initialize() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 /*declaring implicit wait to tell my selenium test to wait 5 seconds
		 before throwing any exception*/
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 //driver.manage().window().maximize();
		 driver.get("https://www.lieferando.de");
		 return driver;
	}

		//close browser
		public void tearDown() {
		driver.quit();
		}
}
