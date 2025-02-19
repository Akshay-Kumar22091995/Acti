package co.actitime.genricLib;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExectionMoniter implements ITestListener {
	
	public void onTestFailure(ITestResult arg) {
		
		String name = arg.getName();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String timeSamp = sdf.format(Calendar.getInstance().getTime()).replace("/", "-").replace(" ", "_").replace(":", "-");
		EventFiringWebDriver efwd = new EventFiringWebDriver(BaseClass.driverForFailure);
		File screenshoot = efwd.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenshoot, new File("./ScreenShot/"+name+" "+timeSamp +".png"));
		} catch (IOException e) {
		
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
