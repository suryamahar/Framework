package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage extends BasePage{
	
	@FindBy(xpath= "//span[text()='Create New User']")
	private WebElement createNewUSerBtn;
	
	@FindBy(xpath="//td[@class='mainContentPadding rightPadding']")
	private WebElement tableBody;
	
	public UsersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUserBtn() {
		return createNewUSerBtn;
	}
	
	public WebElement getTableBody() {
		return tableBody;
	}
	
	

}
