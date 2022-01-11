package DriverSetup;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SetDriver {
	
	public static WebDriver driver;
	public static String browser;
	public static Row rowNum;
	
	public static Row getRow(int row) throws Exception {

		File file = new File("src/test/resources/hackathon.xlsx");
		FileInputStream fs = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fs);
		Sheet sheet1 = workbook.getSheet("Sheet1");
		rowNum = sheet1.getRow(row);
		return rowNum;
	}
	
	public static WebDriver getWebDriver() throws Exception {
		
		Cell cell0 = rowNum.getCell(0);
		browser = cell0.getStringCellValue();
		
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
//		else if(browser.equalsIgnoreCase("ie")) {
//			WebDriverManager.iedriver().setup();
//			driver = new InternetExplorerDriver();
//		}
		else {
			System.out.println("Not available!! Select Chrome or firefox");
		}
				
		driver.manage().window().maximize();
		driver.get("https://www.zigwheels.com/");
		
		return driver;
		
	}
	
	
	
	public static void main(String args[]) throws Exception {
		SetDriver d = new SetDriver();

	}
	
	
}
