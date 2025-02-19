package com.actitime.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	
	@FindBy(className = "dvHeaderText")
	private WebElement contactInfoText;
	
	
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver	, this);
	}
	
	public WebElement getContactInfoText() {
		return contactInfoText;
	}
}
