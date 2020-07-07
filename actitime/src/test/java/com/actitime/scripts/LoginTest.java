package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelLib;
import com.actitime.pageobjects.LoginPage;

public class LoginTest extends BaseLib{
	
	@Test(priority=1, groups= {"Smoke"})
	public void validLogin() {
		ExcelLib elib=new ExcelLib("./testdata/testdata.xlsx");
		String username = elib.readData("Sheet1", 1, 1);
		String password = elib.readData("Sheet1", 1, 2);
		
		LoginPage lp=new LoginPage(driver);
//		lp.getUnTxtBx().sendKeys(username);
//		lp.getPwdTxtBx().sendKeys(password);
//		lp.getLoginBtn().click();
					//OR
		lp.login(username, password);
		
	}
	
	@Test(priority=2, groups= {"Functional"})
	public void invalidLogin() {
		ExcelLib elib=new ExcelLib("./testdata/testdata.xlsx");
		String username = elib.readData("Sheet1", 2, 1);
		String password = elib.readData("Sheet1", 2, 2);
		
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
	}
	
}
