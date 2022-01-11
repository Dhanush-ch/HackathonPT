package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POM_GoogleLogin {

	public WebDriver driver;
	
	public POM_GoogleLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	By zigwheels = By.xpath("//img[@alt='ZigWheels - New Cars, Used Cars, Bikes Prices, News, Reviews, QnA']");
	By loginBtn = By.id("forum_login_title_lg");
	By google = By.cssSelector("div[id='googleSignIn'] span[class='fnt-18']");
	By emailField = By.cssSelector("#identifierId");
	By nextBtn = By.xpath("//span[text() = 'Next']");
	By errMsg = By.xpath("//div[@class = 'o6cuMc']");
	
	public void gotoHomepage() {
		driver.findElement(zigwheels).click();
	}
	
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	
	
	public void usingGoogle() {
//		String url = "https://accounts.google.com/o/oauth2/auth/identifier?redirect_uri=storagerelay%3A%2F%2Fhttps%2Fwww.zigwheels.com%3Fid%3Dauth343951&response_type=permission%20id_token&scope=email%20profile%20openid&openid.realm&include_granted_scopes=true&client_id=591154493254.apps.googleusercontent.com&ss_domain=https%3A%2F%2Fwww.zigwheels.com&fetch_basic_profile=true&gsiwebsdk=2&flowName=GeneralOAuthFlow";

		driver.findElement(google).click();
	}
	
	public void giveEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}
	
	public void clickNext() {
		driver.findElement(nextBtn).click();
	}
	
	public WebElement getErrorMsg() {
		return driver.findElement(errMsg);
	}
	
	
	
	
	
	
	
}

