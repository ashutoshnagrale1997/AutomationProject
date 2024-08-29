package SSquareIT.Day20Framework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	static WebDriver driver;

	@FindBy(xpath = "//strong[text()='Total']/../following-sibling::td")
	private WebElement totalPrice;

	@FindBy(xpath = "//strong[text()='Checkout']")
	private WebElement checkoutButton;

	public CartPage(WebDriver driver) {
		CartPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPrice() {
		return totalPrice.getText();
	}

	public CheckOutPage goToCheckoutPage() {
		checkoutButton.click();
		CheckOutPage checkoutPage = new CheckOutPage(driver);
		return checkoutPage;
	}
}
