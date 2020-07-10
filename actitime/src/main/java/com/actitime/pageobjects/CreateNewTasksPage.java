package com.actitime.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewTasksPage {
	@FindBy(name="customerId")
	private WebElement customerDrpDwn;
	@FindBy(name="projectId")
	private WebElement projectDrpDwn;
	
	@FindBy(css="input[name*='.name']")
	private List<WebElement> all_TaskTxtBx;
	@FindBy(css="select[name*='.billingType']")
	private List<WebElement> all_BillingTypeDrpDwn;
	@FindBy(css="input[name*='.markedToBeAddedToUserTasks']")
	private List<WebElement> all_addToMyTimeTrack_ChkBx;
	
	@FindBy(css="input[value='Create Tasks']")
	private WebElement createTasksBtn;
	
	public CreateNewTasksPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustomerDrpDwn() {
		return customerDrpDwn;
	}

	public WebElement getProjectDrpDwn() {
		return projectDrpDwn;
	}

	public List<WebElement> getAll_TaskTxtBx() {
		return all_TaskTxtBx;
	}

	public List<WebElement> getAll_BillingTypeDrpDwn() {
		return all_BillingTypeDrpDwn;
	}

	public List<WebElement> getAll_addToMyTimeTrack_ChkBx() {
		return all_addToMyTimeTrack_ChkBx;
	}

	public WebElement getCreateTasksBtn() {
		return createTasksBtn;
	}
	
	//reusable method
	public void createTask(String customerName, String projectName, String taskName, String billingType) {
		Select sel1=new Select(customerDrpDwn);
		sel1.selectByVisibleText(customerName);
		
		Select sel2=new Select(projectDrpDwn);
		sel2.selectByVisibleText(projectName);
		
		all_TaskTxtBx.get(0).sendKeys(taskName);
		
		Select sel3=new Select(all_BillingTypeDrpDwn.get(0));
		sel3.selectByVisibleText(billingType);
		
		WebElement chkBx = all_addToMyTimeTrack_ChkBx.get(0);
		if (chkBx.isSelected()) {
		} else {
			chkBx.click();
		}
		
		createTasksBtn.click();
	}
	
}
