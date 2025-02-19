package com.actitime.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

	@FindBy(name = "lastname")
	private WebElement lastName;
	
	@FindBy(css  = "input.save")
	private WebElement saveButton;
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver	, this);
	}
	
	public WebElement getLastnameTextBox() {
		return lastName;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
}
