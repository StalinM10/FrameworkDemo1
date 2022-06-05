package listners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener  {
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		String testname =result.getName();
		 extentTest = extentReport.createTest(testname);
		 extentTestThread.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname =result.getName();
		//extentTest.log(Status.PASS,testname+ "got passed"); 
		extentTestThread.get().log(Status.PASS,testname+ "got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		WebDriver driver = null;
		String testname = result.getName();
		
			//extentTest.fail(result.getThrowable());
			extentTestThread.get().fail(result.getThrowable());
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			 
			e.printStackTrace();
		}
		 try {
			String ssfilepath= takescreenshot(testname,driver);
			extentTestThread.get().addScreenCaptureFromPath(ssfilepath, testname);
			} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

}
