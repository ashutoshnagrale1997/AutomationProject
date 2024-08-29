package SSquareIT.Day20Framework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

//	private WebElement myAccount;
//	private WebElement loginButton;
//
//	public LandingPage(WebDriver driver) {
//		myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
//		loginButton = driver.findElement(By.xpath("//li//a[text()='Login']"));
//	}

	static WebDriver driver;

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccount;
	@FindBy(xpath = "//li//a[text()='Login']")
	private WebElement loginButton;

	public LandingPage(WebDriver driver) {
		LandingPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage login() {
		myAccount.click();
		loginButton.click();
		LoginPage login = new LoginPage(driver);
		return login;
	}
}
