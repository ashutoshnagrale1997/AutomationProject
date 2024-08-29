package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BaseTest {

	static WebDriver driver;

	public WebDriver initBrowser() throws IOException {
//		if browser --> chrome --> chromedriver --> firefox --> firefoxdriver

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Ashutosh Nagrale\\eclipse-workspace\\Day23Framework5\\src\\main\\java\\resources\\Properties.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		// Above line ka matlab hai agar hmm System se (cmd se) property set krr rahe
		// hai to System ki property use karo nhi to Properties file wali property use
		// karo.

		// String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		// driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String baseUrl = prop.getProperty("baseUrl");
		driver.get(baseUrl);
		return driver;
	}

	public void tearDown() {
		driver.quit();
	}

	public static String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String path = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

		File source = new File(path);
		File destination = new File(path);
		FileHandler.copy(source, destination);

		return path;
	}
}
