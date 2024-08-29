package SSquareIT.Day20Framework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BasePageClass;

public class ProductDetailsPage extends BasePageClass {

	static WebDriver driver;

	@FindBy(xpath = "(//h1[text()='Nikon D300']/..//following-sibling::ul[@class='list-unstyled'])[2]//li//h2")
	WebElement productPrice;

	@FindBy(css = "input[name='quantity']")
	WebElement qty;

	@FindBy(id = "button-cart")
	WebElement addToCart;

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		ProductDetailsPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProductPrice() {
		return productPrice.getText();
	}

	public CartPage setQuantity(String quantity) {
		qty.clear();
		qty.sendKeys(quantity);
		addToCart.click();
		clickOnCart();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
}
