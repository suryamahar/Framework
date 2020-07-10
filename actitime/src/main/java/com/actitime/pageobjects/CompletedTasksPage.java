package com.actitime.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CompletedTasksPage {
	@FindBy(xpath="//table[@class='listTable']")
	private WebElement taskTable;
	
	public CompletedTasksPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyCompletedTask(String customerName, String projectName, String taskName) {
		List<WebElement> rows = taskTable.findElements(By.tagName("tr"));
		for (int i = 2; i < rows.size(); i++) {//start of outer
			WebElement rw = rows.get(i);
			List<WebElement> cols = rw.findElements(By.tagName("td"));
			for (int j = 0; j < cols.size(); j++) {//start of inner
				if(j==0) {
					Assert.assertTrue(cols.get(j).getText().contains(customerName));
				} if(j==1) {
					Assert.assertTrue(cols.get(j).getText().contains(projectName));
				} if(j==2) {
					WebElement thirdCol = cols.get(j);
					Assert.assertTrue(thirdCol.findElement(By.cssSelector("a[href*='task_details']")).getText().contains(taskName));
					break;
				}
			}//end of inner
		}//end of outer
	}
	
	
	
}
