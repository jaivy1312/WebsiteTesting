package POMproject.websiteTestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class ListenerTest extends BaseTest implements ITestListener
{
	ExtentReports extent=ExtentReported.getextentreport();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentlocal=new ThreadLocal<ExtentTest>();
    @Override		
    public void onTestStart(ITestResult Result)					
    {		
    System.out.println(Result.getName()+" test case started");		
   test= extent.createTest(Result.getMethod().getMethodName());
   extentlocal.set(test);
    
    }		

    // When Test case get passed, this method is called.		
    @Override		
    public void onTestSuccess(ITestResult Result)					
    {		
    System.out.println("The name of the testcase passed is :"+Result.getName());	
    test.log(Status.PASS, "Test Passed");
    }
	@Override		
    public void onFinish(ITestContext Result) 					
    {		
            extent.flush();    		
    }	

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
    {		
    		
    }		

    // When Test case get failed, this method is called.		
    @Override		
    public void onTestFailure(ITestResult Result) 					
    {		
    //System.out.println("The name of the testcase failed is :"+Result.getName());	
    extentlocal.get().fail(Result.getThrowable());
    System.out.println("test work here 2");
    try {
		driver=(WebDriver) Result.getTestClass().getRealClass().getField("driver").get(Result.getInstance());
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    String  filepath = null;
 try {
	 filepath= getscreenshot(Result.getMethod().getMethodName(),driver);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    test.addScreenCaptureFromPath(filepath, Result.getMethod().getMethodName());
    }		

    // When Test case get Skipped, this method is called.		
    @Override		
    public void onTestSkipped(ITestResult Result)					
    {		
    System.out.println("The name of the testcase Skipped is :"+Result.getName());					
    }		

    // When Test case get Started, this method is called.		
	

    @Override		
    public void onStart(ITestContext Result)					
    {		
            		
    }	
}