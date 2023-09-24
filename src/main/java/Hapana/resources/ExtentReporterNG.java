package Hapana.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Extent Report");

		
		ExtentReports extent = new ExtentReports();
	    extent.attachReporter(reporter);
	    extent.setSystemInfo("Name","Laxminarayan");
	    extent.createTest(path);
	    return extent;
	    
	    
	    
	}

}
