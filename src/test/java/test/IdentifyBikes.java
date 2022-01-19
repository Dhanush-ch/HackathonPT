package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DriverSetup.SetDriver;
import ObjectRepository.POM_IdentifyBikes;
import utilities.ExtentListeners;

public class IdentifyBikes {

	public static WebDriver driver;
	public static String browser;
	POM_IdentifyBikes bikes;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	@BeforeSuite
	public void setDriver() throws Exception {
		SetDriver.getRow(1);
		driver = SetDriver.getWebDriver();
		bikes = new POM_IdentifyBikes(driver);
	}
	
	

	@Test(priority = 1)
	public void upcomingBikes() throws Exception {

		try {
			// Hover New Bikes
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(bikes.newBikess));
			bikes.selectnewBikes();

			// Select Bikes
			wait.until(ExpectedConditions.visibilityOfElementLocated(bikes.upcomingBikes));
			bikes.selectupcomingBikes();

			// Select Honda
			wait.until(ExpectedConditions.visibilityOfElementLocated(bikes.brand));
			bikes.selectBrand();

			//Get total No.of.Bikes
			int bikeCount = bikes.totalBikes();
			
			System.out.println("----- Upcoming bikes in Honda ----- ");
			
			//print Bike's ModelName, Price and Launch date
			for (int i = 1; i <= bikeCount; i++) {
				
				if(i==7) {
					continue;
				}
				
				String modelName = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li["+i+"]/div[1]/div[3]/a[1]/strong[1]")).getText();
				Float price = Float.parseFloat(driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li["+i+"]/div[1]/div[3]/div[1]")).getText().substring(4, 8));
				String launchDate= driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li["+i+"]/div[1]/div[3]/div[2]")).getText();
				if(price < 4.00) {					
					System.out.println(modelName +"\t"+ price  + "L\t" + launchDate + "\t");
					ExtentListeners.test.log(Status.INFO, modelName +"\t"+ price  + "L\t" + launchDate + "\t");
				}
				
				if(i == 6) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li["+i+"]/div[1]/div[3]/a[1]/strong[1]")));
					wait.until(ExpectedConditions.elementToBeClickable(bikes.viewMore()));
					js.executeScript("arguments[0].click();", bikes.viewMore());
				}
			}
			ExtentListeners.test.log(Status.INFO, "Bikes has been displayed");
			

			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			ExtentListeners.test.log(Status.INFO, e.getMessage());
		}
		

	}
}
