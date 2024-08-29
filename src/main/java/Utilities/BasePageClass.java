package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageClass {

	static WebDriver driver;

	@FindBy(xpath = "//span[@id='cart-total']/..")
	static WebElement cartButton;

	public BasePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void visibilityOfElementLocated(By findBy) {
		WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(10));
		wdw.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		// above line means jbb tkk WebElement/WebElements visible nhi hote DOM ko tbb
		// tkk ye Explicit Wait rukega...BUT UNTIL 10 SECONDS
	}
	
	public static void clickOnCart() {
		cartButton.click();
	}
}
