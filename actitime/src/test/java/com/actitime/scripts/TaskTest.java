package com.actitime.scripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelLib;
import com.actitime.pageobjects.CompletedTasksPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.CreateNewProjPage;
import com.actitime.pageobjects.CreateNewTasksPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTaskPage;
import com.actitime.pageobjects.ProjectAndCustomerPage;

public class TaskTest extends BaseLib{
	
	@Test
	public void testCompletedTask() {
		
		ExcelLib elib=new ExcelLib("./testdata/testdata.xlsx");
		String username = elib.readData("Sheet1", 4, 1);
		String password = elib.readData("Sheet1", 4, 2);
		String customerName = elib.readData("Sheet1", 4, 3);
		String projectName = elib.readData("Sheet1", 4, 4);
		String taskName = elib.readData("Sheet1", 4, 5);
		String billingType = elib.readData("Sheet1", 4, 6);
		
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.getTask().click();
		
		OpenTaskPage otp=new OpenTaskPage(driver);
		otp.getProjCustLink().click();
		
		ProjectAndCustomerPage apcp=new ProjectAndCustomerPage(driver);
		apcp.getCreateNewCustBtn().click();
		
		CreateNewCustPage cncp=new CreateNewCustPage(driver);
		cncp.createCustomer(customerName);   //customer
		
		String actualCustMsg = apcp.getSuccessMsgEle().getText();
		String expectedCustMsg ="Customer \""+customerName+"\" has been successfully created.";
		Assert.assertEquals(actualCustMsg, expectedCustMsg);                                         //customer validation
		Reporter.log(expectedCustMsg, true);
		
		apcp.getCreateNewProjBtn().click();
		
		CreateNewProjPage cnpp=new CreateNewProjPage(driver);
		cnpp.createProject(customerName, projectName);    //project
		
		String actualProjectMsg = apcp.getSuccessMsgEle().getText();
		String expectedProjectMsg = "Project \""+projectName+"\" has been successfully created.";
		Assert.assertEquals(actualProjectMsg, expectedProjectMsg);                               //project validation
		Reporter.log(expectedProjectMsg, true);
		
		apcp.getOpenTaskLink().click();
		
		otp.getNewTaskBtn().click();
		
		CreateNewTasksPage cntp=new CreateNewTasksPage(driver);
		cntp.createTask(customerName, projectName, taskName, billingType); //task
		String actualTaskMsg = otp.getSuccessMsgEle().getText();
		String expectedTaskMsg = "1 new task was added to the customer \""+customerName+"\", project \""+projectName+"\".";
		Assert.assertEquals(actualTaskMsg, expectedTaskMsg);                                        //task validation
		
		otp.verifyCreatedTask(customerName, projectName, taskName);                                  //task validation
		Reporter.log(taskName+" task is created successfully", true);
		
		otp.getTimeTrack().click();
		
		ettp.verifyTaskInTimeTrack(customerName, projectName, taskName);                             //task validation in time track
		Reporter.log(taskName+" task is verified in time track", true);
		
		ettp.getTask().click();
		
		otp.openTaskToCompletedTask(customerName, projectName, taskName);  
		
		String actualCompletedTaskMsg = otp.getSuccessMsgEle().getText();
		String expectedCompletedTaskMsg = "Selected tasks have been successfully completed.";
		Assert.assertEquals(actualCompletedTaskMsg, expectedCompletedTaskMsg);                       //completed task msg validation
		
		otp.getCompleteTaskBtn().click();
		
		CompletedTasksPage ctp=new CompletedTasksPage(driver);
		ctp.verifyCompletedTask(customerName, projectName, taskName);                                //completed task validation
		Reporter.log(taskName+" is verified as a completed task", true);
		//shortcuts
		//Press CTRL and mouse hover on method and do mouse click
		//Press SHIFT and mouse hover on that method
	}
	
	
}
