package com.actitime.testscript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GettingSuggestionListLufthansa {
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.lufthansa.com/in/en/homepage");
		driver.findElement(By.id("cm-acceptAll")).click();
//		Thread.sleep(2000);
//		WebElement from=driver.findElement(By.xpath("//input[@placeholder='From']"));
//		Thread.sleep(2000);
//		from.click();
//		Thread.sleep(2000);
//		from.sendKeys(Keys.CONTROL,"a");
//		from.sendKeys(Keys.DELETE);
//		from.sendKeys("Delhi"); 
//		Thread.sleep(3000);
//		  List<WebElement>origin=driver.findElements(By.xpath("//ul[contains(@id,'originCode')]"));
//		  System.out.println(origin.get(0).getText());
//		 
	}

}
