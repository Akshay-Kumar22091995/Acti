package co.actitime.genricLib;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.elementRepository.HomePage;
import com.actitime.elementRepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver driverForFailure;
	public DataSuppier ds = new DataSuppier();
	
	@BeforeClass(alwaysRun = true)
	public void configBC() throws IOException {
		if(ds.getDataFromProperty("browser").equals("chrome")) {
			driver = new ChromeDriver();
		}else if (ds.getDataFromProperty("browser").equals("firefox")) {
			driver= new FirefoxDriver();
		}
		
		driverForFailure = driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws IOException {
		driver.get(ds.getDataFromProperty("url"));
		Set<String> childTabs = driver.getWindowHandles();
		String mainTab = driver.getWindowHandle();
		for (String child : childTabs) {
			if (!child.equals(mainTab)) {
				driver.switchTo().window(child);
				driver.close();
			}
		}
		driver.switchTo().window(mainTab);
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(ds.getDataFromProperty("username"));
		lp.getPassword().sendKeys(ds.getDataFromProperty("password"));
		lp.getLoginButton().click();
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM() {
		Actions action = new Actions(driver);
		HomePage hp = new HomePage(driver);
		action.moveToElement(hp.getlogoutDD()).perform();
		hp.getSignout().click();
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC() {
		driver.quit();
	}
	
}
