package listenrs;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Mylisterrs implements ITestListener {
	WebDriver driver;
	
	public static ExtentReports reports;
	public static ExtentTest test;
	

	public void onTestStart(ITestResult result) {
		
		System.out.println("on test start");
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + " id started");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("on test Success"); 
		//test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + " is Success");
		
	}

	public void onTestFailure(ITestResult result) {
		
		//test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " is Failed");
		System.out.println("on test failure");
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
		File src=TakeScreenShot.takescreenshot();
		File destination= new File("/Users/anamulhoque/eclipse-workspace/ExtendReportPractice/MyScreenShot/"+ result.getMethod().getMethodName()+".png");

		try {
			FileUtils.copyFile(src, destination);
			String path=destination.getAbsolutePath();
			String file=test.addScreenCapture(path);
			test.log(LogStatus.FAIL, result.getMethod().getMethodName()+" is failed"+file);
			test.log(LogStatus.FAIL, result.getMethod().getMethodName()+" message"+result.getThrowable().getMessage());
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

	public void onTestSkipped(ITestResult result) {
		
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + " is Skip");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		 System.out.println("on start");
		
		reports = new ExtentReports("/Users/anamulhoque/eclipse-workspace/ExtendReportPractice/extentreportfolder/extent.html");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("of finnish");
		reports.endTest(test);
		reports.flush();
		
	}

}
