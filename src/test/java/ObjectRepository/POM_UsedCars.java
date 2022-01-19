package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POM_UsedCars {

	public WebDriver driver;

	public POM_UsedCars(WebDriver driver) {
		this.driver = driver;
	}
	
	By zigwheels = By.xpath("//img[@alt='ZigWheels - New Cars, Used Cars, Bikes Prices, News, Reviews, QnA']");
	By usedcars = By.xpath("//a[normalize-space()='Used Cars']");
	public By city = By.xpath("//a[@title='Chennai']");
	public By popularModelsList = By.xpath("//div[@class='gsc_thin_scroll']");
	
	
	
	public void gotoHomepage() {
		driver.findElement(zigwheels).click();
	}
	
	public void clickUsedCars() {
		driver.findElement(usedcars).click();
	}
	
	public void selectCity() {
		driver.findElement(city).click();
	}
	
	

}
