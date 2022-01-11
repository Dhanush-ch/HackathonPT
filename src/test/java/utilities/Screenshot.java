package utilities;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

public class Screenshot {
	
	
	public static String captureScreenshot(WebDriver driver) {
		
		Date date = new Date();
		String fileName = date.toString().replace(":", "_").replace(" ", "_") + ".png";
	
		
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("./screenshots/ErrorMessage/" + fileName);
		String screenshotPath = "./screenshots/ErrorMessage/" + fileName;
		
		
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			System.out.println("\n----- Error message captured -----");
			ExtentListeners.test.log(Status.INFO, "Error message captured");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return screenshotPath;
	}
	
}
