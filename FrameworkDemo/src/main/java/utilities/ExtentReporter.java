package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	static ExtentReports extentReport;
	
	public static ExtentReports getExtentReport() {
		String extentreportpath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(extentreportpath);
		reporter.config().setReportName("First FrameWork result");
		reporter.config().setDocumentTitle("Test Results");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("OS", "windows 7");
		extentReport.setSystemInfo("Tested By", "Stalin");
		
		return extentReport;
	}

}
