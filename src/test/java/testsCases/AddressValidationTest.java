package testsCases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import excelReader.ExcelReader;

import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.RestaurantsList;

public class AddressValidationTest extends Base {
	public String addressData = "";
	public String path= System.getProperty("user.dir");
		
	@BeforeMethod
	public void initializeBrowser() {
		//calling the initialize method created in base class.
		driver = initialize();
	}
	
		@Test(dataProvider="Address")
		public void addressTest(String address, String expectedAddress) {
			//Creating an excel object to access the data
			
			
			//creating a new HomePage object and passing the driver
			HomePage homePageObj = new HomePage(driver);
			//calling the method setAddress defined in HomePage
			homePageObj.setAddress(address);
			//Creating a new restaurant list object and passing the driver
			RestaurantsList restList = new RestaurantsList(driver);
			//saving the actual result
			String actualResult = restList.getAddress();
			//Validating the results
			Assert.assertEquals(actualResult, expectedAddress);
		}
		
		@DataProvider(name="Address")
		public Object [][] addressInput()
		{
			//Creating an excelreader object and passing the path of my file
		ExcelReader excel= new ExcelReader("C:\\Users\\Beba\\eclipse-workspace\\AutomationDeliveryPractice\\src\\main\\java\\data\\DataTest.xlsx");
		//getting the number of rows
		int rows= excel.getRowsNumber(0);
		Object [][] data= new Object[rows][2];
		
		//looping the excel and getting the data
		for(int i=0; i < rows;i++)
		{	
			data[i][0]= excel.getData(i, 0);
			data[i][1]= excel.getData(i, 1);
		}
		return data;
		}
		
		@AfterMethod
		public void closeBrowser() {
			tearDown();
		}
		
		}
	
