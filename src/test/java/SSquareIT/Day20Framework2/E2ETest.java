package SSquareIT.Day20Framework2;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class E2ETest extends BaseTest {

	@Test(dataProvider = "getData")
	public void endToEndTest(String username, String password) throws InterruptedException, IOException {

		
		//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");

		
		WebDriver driver = initBrowser();
		
		// Landing page
		LandingPage landingPage = new LandingPage(driver);
		landingPage.login();

		// Login page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginAction(username, password);

		// 1st Validation
		String actual = driver.getCurrentUrl();
		String expected = "https://tutorialsninja.com/demo/index.php?route=account/account";
		Assert.assertEquals(actual, expected);

		
		// Home page
		HomePage homePage = new HomePage(driver);
		homePage.clickOnCameraTab();

		// Product Page
		ProductPage productPage = new ProductPage(driver);
		List<WebElement> products = productPage.getProducts();
		productPage.addProductToCart("Nikon D300");

		// product details page
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		String productPrice = productDetailsPage.getProductPrice();
		// first validation
		Assert.assertEquals(productPrice, "$98.00");
		productDetailsPage.setQuantity("2");

		// cart page
		CartPage cartPage = new CartPage(driver);
		String totalPrice = cartPage.getPrice();
		Assert.assertEquals(totalPrice, "$196.00");
		cartPage.goToCheckoutPage();

		// Checkout page
		CheckOutPage checkoutPage = new CheckOutPage(driver);
		checkoutPage.clickCheckoutButton();
		checkoutPage.closeErrorMessage();
		String actualMessage = checkoutPage.getSuccessMessage();
		String expectedText = "***";

		Assert.assertEquals(actualMessage, expectedText);

		// Thread.sleep(1500);
		driver.close();

	}

	@DataProvider(name = "getData")
	public Object[][] getData() {
		return new Object[][] { { "ashutoshnagrale1998@gmail.com", "Ashu@9423" },
				{ "ashutoshnagrale1998@gmail.com", "Ashu@9423" } };
	}
}
