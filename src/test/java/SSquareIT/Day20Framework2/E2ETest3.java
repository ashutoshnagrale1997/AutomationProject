package SSquareIT.Day20Framework2;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class E2ETest3 extends BaseTest {

	@Test
	public void endToEndTest() throws InterruptedException, IOException {

		WebDriver driver = initBrowser();

		// Landing page
		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = landingPage.login();
		HomePage homePage = loginPage.loginAction("ashutoshnagrale1998@gmail.com", "Ashu@9423");

		// 1st Validation
		String actual = driver.getCurrentUrl();
		String expected = "https://tutorialsninja.com/demo/index.php?route=account/account";
		Assert.assertEquals(actual, expected);

		ProductPage productPage = homePage.clickOnCameraTab();

		List<WebElement> products = productPage.getProducts();
		ProductDetailsPage productDetailsPage = productPage.addProductToCart("Nikon D300");
		// first validation
		Assert.assertEquals(productDetailsPage.getProductPrice(), "$98.00");
		CartPage cartPage = productDetailsPage.setQuantity("2");
		// second validation
		String totalPrice = cartPage.getPrice();
		Assert.assertEquals(totalPrice, "$196.00");
		CheckOutPage checkOutPage = cartPage.goToCheckoutPage();
		checkOutPage.clickCheckoutButton();
		checkOutPage.closeErrorMessage();
		// third validation
		boolean isSuccess = checkOutPage.getSuccessMessage().equalsIgnoreCase("***");
		Assert.assertTrue(isSuccess);

		tearDown();
	}

}
