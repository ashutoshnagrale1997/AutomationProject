package SSquareIT.Day20Framework2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BasePageClass;

public class ProductPage extends BasePageClass {

	static WebDriver driver;

	@FindBy(css = "div.product-grid")
	List<WebElement> products;
	By productDivLocation = By.cssSelector("div.caption h4");
	By exactProductLocation = By.cssSelector("a");

	public ProductPage(WebDriver driver) {
		super(driver);
		ProductPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getProducts() {
		// below line for Explicit Wait
		visibilityOfElementLocated(productDivLocation);
		// SEE BasePageClass visibilityOfElementLocated() method for explaination
		// written there
		// above line means jbb tkk WebElement/WebElements visible nhi hote DOM ko tbb
		// tkk ye Explicit Wait rukega...BUT UNTIL 10 SECONDS
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prodCamera = null;
		for (WebElement product : products) {
			// div.product-grid div.caption h4
			WebElement targetProduct = product.findElement(productDivLocation);
			String text = targetProduct.getText();
			System.out.println(text);
			if (text.equals(productName)) {
				// ProductDetails page
				prodCamera = targetProduct.findElement(exactProductLocation);

			}
		}
		return prodCamera;
	}

	public ProductDetailsPage addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.click();
		ProductDetailsPage productDetails = new ProductDetailsPage(driver);
		return productDetails;
	}
}
