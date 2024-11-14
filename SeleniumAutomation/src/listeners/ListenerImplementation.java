package listeners;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplementation extends BaseClass implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getName();
		String time = LocalDateTime.now().toString().replace(":", "-");
		
		Reporter.log("Test script is failed",true);
		
		TakesScreenshot ts = (TakesScreenshot) sdriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+methodName+time+".png");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}
}
