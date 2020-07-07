package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {
	
	//public static WebDriver driver;   //parallel execution will not work because of static
	public WebDriver driver;            //for parallel execution
	
	@BeforeMethod(groups= {"Smoke","Functional"})
	@Parameters({"browser" , "baseurl"})
	public void preCondition(String browserName, String url)
	{
		driver=BrowserFactory.launchBrowser(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Reporter.log(url+ " url navigated", true);
	}
	
	@AfterMethod(groups= {"Smoke","Functional"})
	public void postCondition()
	{
		driver.close();
		Reporter.log("Browser Closed", true);
	}
	
}
