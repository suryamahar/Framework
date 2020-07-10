package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewProjPage {
	@FindBy(name="customerId")
	private WebElement customerDrpDwn;
	@FindBy(name="name")
	private WebElement projectTxtBx;
	@FindBy(name="createProjectSubmit")
	private WebElement createProjectBtn;
	
	public CreateNewProjPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustomerDrpDwn() {
		return customerDrpDwn;
	}

	public WebElement getProjectTxtBx() {
		return projectTxtBx;
	}

	public WebElement getCreateProjectBtn() {
		return createProjectBtn;
	}
	
	//reusable method
	public void createProject(String customerName, String projectName) {
		Select sel=new Select(customerDrpDwn);
		sel.selectByVisibleText(customerName);
		projectTxtBx.sendKeys(projectName);
		createProjectBtn.click();
	}
}
