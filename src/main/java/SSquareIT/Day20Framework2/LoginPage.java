package SSquareIT.Day20Framework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	static WebDriver driver;

	@FindBy(css = "#input-email")
	WebElement emailBox;
	@FindBy(css = "#input-password")
	WebElement passwordBox;
	@FindBy(css = "input[type='submit']")
	WebElement submitButton;

	public LoginPage(WebDriver driver) {
		LoginPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage loginAction(String email, String password) {
		emailBox.sendKeys(email);
		passwordBox.sendKeys(password);
		submitButton.click();
		HomePage hp = new HomePage(driver);
		return hp;
	}
}
