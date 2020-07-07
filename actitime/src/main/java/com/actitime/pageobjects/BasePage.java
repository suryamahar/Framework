package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {
	
	@FindBy(xpath = "//div[text()='Time-Track']")
	private WebElement timeTrkEle;
	
	@FindBy(xpath = "//div[text()='Tasks']")
	private WebElement taskEle;
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getTimeTrack() {
		return timeTrkEle;
		
	}
	public WebElement getTask() {
		return taskEle;
		
	}
}
