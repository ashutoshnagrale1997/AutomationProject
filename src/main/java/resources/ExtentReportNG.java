package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports ExtentReporting() {
		String path = System.getProperty("user.dir") + "//reports//index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);// to configure report
		reporter.config().setDocumentTitle("Test Reports");
		reporter.config().setReportName("Automation Test Report");

		ExtentReports extent = new ExtentReports(); // to create report from testcases
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ashutosh");
		extent.createTest(path); // this ExtentReports object we need in every testcase bcs ExtentReports object
									// will keep on listening every testcase and will save all the info about the
									// testcase, whether testcase fail or passes, that report can be finally seen by
									// managers, etc.

		return extent;
	}
}
