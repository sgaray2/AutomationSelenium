package base;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver = null;
	
	//browser config
	public WebDriver initialize() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 /*declaring implicit wait to tell my selenium test to wait 20 seconds
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
		
		public void takeScreenshots(WebDriver driver, String screenshotName) throws IOException {
			//my method will receive the driver instance from the calling class
			//and the screenshotName is to give a specific name for each screenshot taken.
			
			try {
				//takescreenshot interface from selenium, as we cannot create objects from interface
				//we typecast the driver. 
				TakesScreenshot ts= (TakesScreenshot)driver;
				
				//calling the method takeScreenShot and store in memory for now in a form of file.
				File source = ts.getScreenshotAs(OutputType.FILE);
				
				//Using fileUtils to copy the screenshot to a file.
				FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());	
		}
			}
}
