package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsReader {

public static ExtentReports getExtentReportObject() {
		
		String path = System.getProperty("user.dir")+"/TestReport/index.html";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
		extentSparkReporter.config().setReportName("Website Automate Report");
		extentSparkReporter.config().setDocumentTitle("TestResults");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(extentSparkReporter);
		extent.setSystemInfo("Tester", "Javed Ali Shaikh");
		return extent;
		
	}
	
}
