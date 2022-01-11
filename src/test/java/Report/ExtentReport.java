package Report;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void setReport() {
		htmlReporter = new ExtentSparkReporter("./reports/extentReport.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("ExtentReport");
		htmlReporter.config().setReportName("Hackathon-Extent-Report");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation tester", "Dhanush");
		extent.setSystemInfo("browser", "chrome");

	}

	@Test
	public void testPass() {
		test = extent.createTest("testPass");
	}

	@Test
	public void testFail() {
		test = extent.createTest("test fail");
		Assert.fail();
	}

	@Test
	public void testSkip() {
		test = extent.createTest("Skip test");
		throw new SkipException("Skipping the test");
	}

	@AfterMethod
	public void updateResults(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			Markup m = MarkupHelper.createLabel("Test case passed", ExtentColor.GREEN);
			test.pass(m);
		}
		if (result.getStatus() == ITestResult.FAILURE) {
			String methodName = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel("Test case failed: " + methodName.toUpperCase(), ExtentColor.RED);
			test.fail(m);		}
		if (result.getStatus() == ITestResult.SKIP) {
			String methodName = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel("Test case Skipped: " + methodName.toUpperCase(), ExtentColor.ORANGE);
			test.skip(m);		}

	}
	
	@AfterTest
	public void flushReport() {
		extent.flush();
	}

}
