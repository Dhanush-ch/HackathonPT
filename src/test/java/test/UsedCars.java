package test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ObjectRepository.POM_UsedCars;
import utilities.ExtentListeners;

public class UsedCars {

	POM_UsedCars usedcars;

	@Test(priority = 1)
	public void listUsedCars() throws Exception {
		
		try {
			
			usedcars = new POM_UsedCars(IdentifyBikes.getDriver());
			
			Thread.sleep(3000);
			usedcars.gotoHomepage();
			Thread.sleep(2000);
			
			// To click Usedcars
			usedcars.clickUsedCars();
			
			// To Select City
			usedcars.selectCity();
			
			// To List Popular models
			List<WebElement> popularModels = IdentifyBikes.getDriver().findElements(usedcars.popularModelsList);
			
			System.out.println("----- Popular models in Used Cars ----- ");
			
			for (WebElement element : popularModels) {
				System.out.println(element.getText());
				ExtentListeners.test.log(Status.INFO, element.getText() + ", ");
			}
			ExtentListeners.test.log(Status.INFO, "Used cars of popular models Displayed");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			ExtentListeners.test.log(Status.INFO, e.getMessage());
		}

	}
}
