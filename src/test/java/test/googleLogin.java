package test;

import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DriverSetup.SetDriver;
import ObjectRepository.POM_GoogleLogin;
import utilities.ExtentListeners;
import utilities.Screenshot;

public class googleLogin {

	POM_GoogleLogin gLogin;

	@Test(priority = 1)
	public void loginToGoogle() throws InterruptedException {

		gLogin = new POM_GoogleLogin(IdentifyBikes.getDriver());

		gLogin.gotoHomepage();
		Thread.sleep(2000);
		// Click Login/SignUp
//			Set<String> s = IdentifyBikes.getDriver().getWindowHandles();
//			Iterator<String> iterate = s.iterator();
//			String first_window = iterate.next();
		//
//			System.out.println("First window ID -------" + first_window);
		gLogin.clickLogin();

//			s = IdentifyBikes.getDriver().getWindowHandles();
//			iterate = s.iterator();
//			iterate.next();
//			String second_window = iterate.next();
//			System.out.println("Second Window id -------"+second_window);
		Thread.sleep(8000);
//			IdentifyBikes.getDriver().switchTo().activeElement();

//			WebIdentifyBikes.getDriver()Wait wait = new WebIdentifyBikes.getDriver()Wait(IdentifyBikes.getDriver(), Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Continue with Google']")));
		gLogin.usingGoogle();
//			Actions action = new Actions(IdentifyBikes.getDriver());
//			action.click(IdentifyBikes.getDriver().findElement(By.xpath("(//span[text() = 'Continue with Google'])[1]"))).perform();

	}

	@Test(priority = 2)
	public void withGoogle() throws Exception {

		try {
			
			gLogin = new POM_GoogleLogin(IdentifyBikes.getDriver());
			
			Set<String> s = IdentifyBikes.getDriver().getWindowHandles();
			Iterator<String> iterate = s.iterator();
			iterate.next();
			String third_window = iterate.next();
			
			IdentifyBikes.getDriver().switchTo().window(third_window);
			Thread.sleep(5000);
			Row row1 = SetDriver.getRow(1);
			String emailVal = row1.getCell(1).getStringCellValue();
			gLogin.giveEmail(emailVal);
			gLogin.clickNext();
			Thread.sleep(5000);
			
			// To capture the displayed error message
			String screenshotPath = Screenshot.captureScreenshot(IdentifyBikes.getDriver());
			
			ExtentListeners.test.addScreenCaptureFromPath(""+screenshotPath);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			ExtentListeners.test.log(Status.INFO, e.getMessage());
		}
	
	}
	
	
	@AfterSuite
	public void closeDriver() {
		IdentifyBikes.getDriver().quit();
	}
	
	
	
	

}
