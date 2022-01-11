package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class POM_IdentifyBikes {
	
	public WebDriver driver;
	
	public POM_IdentifyBikes(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public By newBikess  = By.xpath("//a[@data-track-component='navigation'][normalize-space()='New Bikes']");
	public By upcomingBikes = By.xpath("//a[normalize-space()='Upcoming Bikes'  or @href = '/upcoming-bikes']");
	public By brand = By.id("makeId");
	public By bikesCount = By.xpath("//span[@class = 'fnt-12 i-b mt-10 ml-5']");
	public By viewMoreBtn = By.xpath("//span[@data-track-label = 'view-more-models-button']");
	
	public void selectnewBikes() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(newBikess)).perform();
	}
	
	public void selectupcomingBikes() {
		driver.findElement(upcomingBikes).click();
	}
	
	public void selectBrand() {
		Select manufacturer = new Select(driver.findElement(brand));
		manufacturer.selectByVisibleText("Honda");
	}
	
	public int totalBikes() {
		String totalBike = driver.findElement(bikesCount).getText();
		int bikeCount = Integer.parseInt(totalBike.replaceAll("[^0-9]", ""));
		return bikeCount;
	}
	
	public WebElement viewMore() {
		return driver.findElement(viewMoreBtn);
	}

}
