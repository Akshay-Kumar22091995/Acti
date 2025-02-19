package com.actitime.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
* @Author Akshay
*/
public class HomePage {
	@FindBy(xpath="//span[text()=' Administrator']/../following-sibling::td[1]/img")
	private WebElement logoutDD;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	
	@FindBy(linkText ="Contacts")
	private WebElement contactButton;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver	, this);
	}
	
	public WebElement getSignout() {
		return signOut;
	}
	
	public WebElement getlogoutDD() {
		return logoutDD;
	}

	public WebElement getContactButton() {
		return contactButton;
	}
}
