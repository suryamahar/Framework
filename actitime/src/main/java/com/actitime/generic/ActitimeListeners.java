package com.actitime.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class ActitimeListeners implements ITestListener {

	public static int executionCount, passCount, failCount, skipCount = 0;

	
	public void onTestStart(ITestResult result) {
		executionCount++;
		Reporter.log(result.getName()+ "script execution starts: "+new Date(), true);
	}
	public void onTestSuccess(ITestResult result) {
		passCount++;
		Reporter.log(result.getName()+" script is passed", true);
	}

	public void onTestFailure(ITestResult result) {
		failCount++;
		Reporter.log(result.getName()+" script is failed", true);
		
		TakesScreenshot ts=(TakesScreenshot) new BaseLib().driver;
							//OR
		//TakesScreenshot ts=(TakesScreenshot) BaseLib.driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./screenshots/"+result.getName()+".png");
		try {
			Files.copy(srcFile, destFile);
			Reporter.log("Screenshot has been taken", true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		skipCount++;
		Reporter.log(result.getName()+" script is skipped", true);
	}

	
	public void onStart(ITestContext context) {
		Reporter.log("Suite Execution starts: "+new Date(), true);
	}

	public void onFinish(ITestContext context) {
		Reporter.log("Suite Execution ends: "+new Date(), true);
		Reporter.log("Total scripts executed: "+(executionCount-skipCount), true);
		Reporter.log("Total scripts passed: "+passCount, true);
		Reporter.log("Total scripts failed: "+failCount, true);
		Reporter.log("Total scripts skipped: "+skipCount, true);
	}
	
	
	
	
	
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
	}
}

