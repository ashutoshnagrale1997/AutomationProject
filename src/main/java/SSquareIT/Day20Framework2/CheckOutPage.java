package SSquareIT.Day20Framework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	@FindBy(xpath = "//a[text()='Checkout']")
	private WebElement checkoutButton;

	@FindBy(css = "button.close")
	private WebElement closeButton;

	@FindBy(css = "td.text-left span.text-danger")
	private WebElement text;

	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickCheckoutButton() {
		checkoutButton.click();
	}

	public void closeErrorMessage() {
		closeButton.click();
	}

	public String getSuccessMessage() {
		return text.getText();
	}
}
