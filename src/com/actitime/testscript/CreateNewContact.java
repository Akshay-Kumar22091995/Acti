package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.elementRepository.ContactInfoPage;
import com.actitime.elementRepository.ContactPage;
import com.actitime.elementRepository.CreateNewContactPage;
import com.actitime.elementRepository.HomePage;

import co.actitime.genricLib.BaseClass;

@Listeners(co.actitime.genricLib.ExectionMoniter.class)
public class CreateNewContact extends BaseClass {

	@Test
	public void createNewContact() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		ContactPage cp = new ContactPage(driver);
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ContactInfoPage cip = new ContactInfoPage(driver);
		
		hp.getContactButton().click();
		
		cp.getCreateContactImg().click();
		
		ccp.getLastnameTextBox().sendKeys(ds.getDataFromExcel("TC_Data", 2, 3));
		ccp.getSaveButton().click();
		
		String actualResult = cip.getContactInfoText().getText();
		
		if (actualResult.contains(ds.getDataFromExcel("TC_Data", 2, 4))) {
			Reporter.log("Contact created sucessfully.",true);
		} else {
			Reporter.log("Contact Not Created", true);
		}
		
		
	}
}
