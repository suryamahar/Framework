package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewUserPage{
	
	@FindBy(name = "username")
	private WebElement newUserTxtBx;
	
	@FindBy(name = "passwordText")
	private WebElement newPassTextBx;
	
	@FindBy(name = "passwordTextRetype")
	private WebElement rePassTextBx;
	
	@FindBy(name = "firstName")
	private WebElement firstNameTxtBx;
	
	@FindBy(name = "lastName")
	private WebElement lastNameTxtBx;
	
	@FindBy(name = "email")
	private WebElement emailTxtBx;
	
	@FindBy(name = "workdayDurationStr")
	private WebElement workDurationTxtBx;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitBtn;
	
	public CreateNewUserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getNewUserName() {
		return newUserTxtBx;
	}
	
	public WebElement getNewPass() {
		return newPassTextBx;
	}
	public WebElement getRePass() {
		return rePassTextBx;
	}
	public WebElement getFirstName() {
		return firstNameTxtBx;
	}
	public WebElement getLastName() {
		return lastNameTxtBx;
	}
	public WebElement getEmail() {
		return emailTxtBx;
	}
	public WebElement getDuration() {
		return workDurationTxtBx;
	}
	
	public WebElement getSubmitBtn(){
		return submitBtn;
	}
	
	public void createUser(String username, String password, String rePassword, String firstName, String lastName, String email, String duration) {
		newUserTxtBx.sendKeys(username);
		newPassTextBx.sendKeys(password);
		rePassTextBx.sendKeys(rePassword);
		firstNameTxtBx.sendKeys(firstName);
		 lastNameTxtBx.sendKeys(lastName);
		 emailTxtBx.sendKeys(email);
		 workDurationTxtBx.sendKeys(duration);
		 
		
		 
		 submitBtn.click();
		 
		 
	}
	
}


