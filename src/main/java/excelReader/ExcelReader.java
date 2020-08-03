package excelReader;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
   File f;
   FileInputStream fis;
   XSSFWorkbook wb;
   int rowsNumber;
   
	//Constructor for excelReader
	public ExcelReader(String path) {
		
		//Create an object of File class to open xlsx file, it receives the path of the file
		try {
		f= new File(path);
		
		//Create an object of FileInputStream class to read excel file
		fis= new FileInputStream(f);
		
		//create object of XSSFWorkbook class
		wb= new XSSFWorkbook(fis);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
		//read data from excel by providing row, cell and sheet
		public String getData(int row, int cell)
		{
			String data;
			
			XSSFSheet sheetReader = wb.getSheetAt(0);
			data=sheetReader.getRow(row).getCell(cell).getStringCellValue();
			
			return data;
		}
		
		//getting the rows number
		public int getRowsNumber(int sheet)
		{
			XSSFSheet sheetReader= wb.getSheetAt(sheet);
			int rowsNumber= sheetReader.getLastRowNum() +1;
			
			return rowsNumber;
		}
}
