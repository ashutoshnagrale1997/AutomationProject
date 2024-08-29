package SSquareIT.Day20Framework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	static WebDriver driver;

	@FindBy(xpath = "//li//a[text()='Cameras']")
	WebElement cameraTab;

	public HomePage(WebDriver driver) {
		HomePage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ProductPage clickOnCameraTab() {
		cameraTab.click();
		ProductPage pp = new ProductPage(driver);
		return pp;
	}
}
