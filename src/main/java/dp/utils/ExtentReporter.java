package dp.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
    private static ExtentReports extent;

	public  static ExtentReports getReport() {
		
		
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter esr = new ExtentSparkReporter(path);
		esr.config().setReportName("Automation results");
		esr.config().setDocumentTitle("Test results");
		
		extent =new ExtentReports();
		extent.attachReporter(esr);
		extent.setSystemInfo("Tester", "Durga prasad");
		return extent;
	}

}
