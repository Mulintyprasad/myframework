package dp.Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import dp.utils.ExtentReporter;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReporter.getReport();
	ThreadLocal<ExtentTest> threadLocal=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		threadLocal.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		threadLocal.get().log(Status.PASS, "Test passed eeeyyuuu");
	}

	public void onTestFailure(ITestResult result) {
		threadLocal.get().fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		threadLocal.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
