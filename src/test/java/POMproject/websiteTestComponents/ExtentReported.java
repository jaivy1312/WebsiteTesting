package POMproject.websiteTestComponents;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;



import com.aventstack.extentreports.ExtentReports;
public class ExtentReported {
	
	public static ExtentReports getextentreport()
	{	
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("websiteTesting");
		reporter.config().setDocumentTitle("Test Results");
		
	ExtentReports extent =new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Jaivy");
	
	return extent;
		}

		
		
		
	

}
