package com.actitime.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelLib;
import com.actitime.pageobjects.CreateNewUserPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.UsersPage;

public class CreateUserTest extends BaseLib {
	
	@Test(groups= {"smoke"})
	public void userCreation() {
		
		ExcelLib el= new ExcelLib("./testdata/testdata.xlsx");
		String username = el.readData("sheet1", 1, 1);
		String password=el.readData("sheet1", 1, 2);
		
		String newUserName= el.readData("sheet1", 5, 3);
		String newPass= el.readData("sheet1", 5, 4);
		String rePass= el.readData("sheet1", 5, 5);
	
		String firstName= el.readData("sheet1", 5, 6);
		String lastName= el.readData("sheet1", 5, 7);
		String email=el.readData("sheet1", 5, 8);
		String duration=el.readData("sheet1", 5, 9);
		
		LoginPage lp= new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.getUsers().click();;
		
		UsersPage up= new UsersPage(driver);
		up.getUserBtn().click();;
		
		CreateNewUserPage cnup= new CreateNewUserPage(driver);
		cnup.createUser(newUserName, newPass, rePass, firstName, lastName, email, duration);
		
		
		
		
	}

}
