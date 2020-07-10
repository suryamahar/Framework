package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCustPage {
	@FindBy(name="name")
	private WebElement customerTxtBx;
	@FindBy(id="active_customers_action")
	private WebElement show_Active_ProjCust_RadioBtn;
	@FindBy(name="createCustomerSubmit")
	private WebElement createCustomerBtn;
	
	public CreateNewCustPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustomerTxtBx() {
		return customerTxtBx;
	}

	public WebElement getShow_Active_ProjCust_RadioBtn() {
		return show_Active_ProjCust_RadioBtn;
	}

	public WebElement getCreateCustomerBtn() {
		return createCustomerBtn;
	}
	
	//reusable method
	public void createCustomer(String customerName) {
		customerTxtBx.sendKeys(customerName);
		if (show_Active_ProjCust_RadioBtn.isSelected()) {
		} else {
			show_Active_ProjCust_RadioBtn.click();
		}
		createCustomerBtn.click();
	}
}
