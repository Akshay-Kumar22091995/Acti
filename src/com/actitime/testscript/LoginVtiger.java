package com.actitime.testscript;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import co.actitime.genricLib.BaseClass;

@Listeners(co.actitime.genricLib.ExectionMoniter.class)
public class LoginVtiger extends BaseClass {

		@Test
		public void loginTest() throws IOException {
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.titleContains("Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM"));
			
			if (driver.getTitle().equals(ds.getDataFromExcel("TC_Data", 1, 2))) {
				Reporter.log("Login Sucessfull.",true);
			} else {
				Reporter.log("Login Fail.",true);
			}
			
	}

}
