package com.actitime.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EnterTimeTrackPage extends BasePage{
	@FindBy(xpath="//table[@id='tt-table']/tbody[@id='actualTTRows']")
	private WebElement timeTrackTableBody;
	
	public EnterTimeTrackPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getTimeTrackTableBody() {
		return timeTrackTableBody;
	}
	
	public void verifyTaskInTimeTrack(String customerName, String projectName, String taskName) {
		List<WebElement> rows = timeTrackTableBody.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size(); i++) {
			WebElement rw = rows.get(i);
			Assert.assertTrue(rw.findElement(By.cssSelector("td[id^='customerNameCell']")).getText().contains(customerName));
			Assert.assertTrue(rw.findElement(By.cssSelector("td[id^='projectNameCell']")).getText().contains(projectName));
			if (rw.findElement(By.cssSelector("td[id^='taskNameCell']")).getText().contains(taskName)) {
				Assert.assertTrue(true);
				break;
			}
			
		}
	}
	
	
}
