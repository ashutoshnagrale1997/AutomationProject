package SSquareIT.Day20Framework2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testComponents.BaseTest;

public class VerifyInvalidLogin extends BaseTest {

	@Test
	public void verifyLoginWithInvalidCredentials() throws IOException {

		WebDriver driver = initBrowser();
		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = landingPage.login();
		HomePage homePage = loginPage.loginAction("wrongemail@gmail.com", "Wrong@Password");

		SoftAssert sa = new SoftAssert();

		String actual = driver.getCurrentUrl();
		String expected = "https://tutorialsninja.com/demo/index.php?route=account/account";

		sa.assertEquals(actual, expected);
		tearDown();

		sa.assertAll();
	}
}
