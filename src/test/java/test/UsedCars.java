package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ObjectRepository.POM_UsedCars;
import utilities.ExtentListeners;

public class UsedCars {

	POM_UsedCars usedcars;

	@Test(priority = 1)
	public void listUsedCars() throws Exception {
		
		try {
			
			WebDriverWait wait = new WebDriverWait(IdentifyBikes.getDriver(), Duration.ofSeconds(20));
			
			usedcars = new POM_UsedCars(IdentifyBikes.getDriver());
			
			Thread.sleep(3000);
			usedcars.gotoHomepage();
			Thread.sleep(2000);
			
			// To click Usedcars
			usedcars.clickUsedCars();
			
			// To Select City
			wait.until(ExpectedConditions.visibilityOfElementLocated(usedcars.city));
			usedcars.selectCity();
			
			// To List Popular models
			wait.until(ExpectedConditions.visibilityOfElementLocated(usedcars.popularModelsList));
			List<WebElement> popularModels = IdentifyBikes.getDriver().findElements(usedcars.popularModelsList);
			
			System.out.println("----- Popular models in Used Cars ----- ");
			
			for (WebElement element : popularModels) {
				System.out.println(element.getText());
				ExtentListeners.test.log(Status.INFO, element.getText());
			}
			ExtentListeners.test.log(Status.INFO, "Used cars of popular models Displayed");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			ExtentListeners.test.log(Status.FAIL, e.getMessage());
		}

	}
}
