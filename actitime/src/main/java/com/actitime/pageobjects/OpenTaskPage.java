package com.actitime.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenTaskPage extends BasePage {
	
	@FindBy(linkText = "Completed Tasks")
	private WebElement completedTaskLink;
	
	@FindBy(linkText = "Projects & Customers")
	private WebElement projCustLink;

	@FindBy(xpath = "//input[@value='Create New Tasks']")
	private WebElement newTaskBtn;
	
	@FindBy(xpath = "//input[@value='Complete Selected Tasks']")
	private WebElement completedTaskBtn;
	
	@FindBy(xpath = "//table[@class='listTable']")
	private WebElement taskTable;
	
	@FindBy(xpath="//table[@id='SuccessMessages']//span")
	private WebElement successMsgEle;   //same element for creating task and completed task msg
	
	public OpenTaskPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCompleteTaskLink() {
		return completedTaskLink;
	}
	public WebElement getProjCustLink() {
		return projCustLink;
	}
	public WebElement getNewTaskBtn() {
		return newTaskBtn;
	}
	public WebElement getCompleteTaskBtn() {
		return completedTaskBtn;
	}
	public WebElement getTaskTable() {
		return taskTable;
	}
	public WebElement getSuccessMsgEle() {
		return successMsgEle;
	}
	
	public void verifyCreatedTask(String cutomerName, String projectName, String taskName) {
		List<WebElement> rows = taskTable.findElements(By.tagName("tr"));
		
		for(int i=2;i<=rows.size();i++) {
			WebElement rw= rows.get(i);
			
			List<WebElement> cols = rw.findElements(By.tagName("td"));
			
			for(int j=1; j<=cols.size();j++) {
				if(j==1) {
					Assert.assertTrue(cols.get(j).getText().contains(cutomerName));
				}
				if(j==2) {
					Assert.assertTrue(cols.get(j).getText().contains(projectName));
				}
				if(j==3) {
					WebElement thirdCol= cols.get(j);
					Assert.assertTrue(thirdCol.findElement(By.cssSelector("a[href*='task_details']")).getText().contains(taskName));
					break;
				}
			}
		}
	}
	
	public void openTaskToCompletedTask(String customerName, String projectName, String taskName) {
		
		List<WebElement> rows = taskTable.findElements(By.tagName("tr"));
		
		for (int i=2;i<=rows.size();i++) {
			WebElement rw = rows.get(i);
			
			List<WebElement> cols = rw.findElements(By.tagName("td"));
			
			for(int j=1;j<cols.size();j++) {
				if(j==1) {
					cols.get(j).getText().contains(customerName);
				}
				if(j==2) {
					cols.get(j).getText().contains(projectName);
				}
				if(j==3) {
					
					WebElement thirdCol = cols.get(j);
					thirdCol.findElement(By.cssSelector("a[href*='task_details']")).getText().contains(taskName);
					cols.get(6).findElement(By.cssSelector("input[name^='taskSelected']")).click();
					break;
				}
			}
		}
		
		completedTaskBtn.click();
	}
	
}
