package assignments.test21_10_2024;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class TestSelenium {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://profile.oracle.com/myprofile/account/create-account.jspx");
		
		WebElement countryDropDown = driver.findElement(By.id("sView1:r1:0:country::content"));
		Select countrySelect = new Select(countryDropDown);
		List<WebElement> allOptions = countrySelect.getOptions();
		
		countrySelect.selectByIndex(allOptions.size()-1);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./oraclelogin/"+LocalDateTime.now().toString().replace(":", "-")+".png");
		FileHandler.copy(temp, dest);
		
		driver.findElement(By.linkText("Oracle.com Terms of Use")).click();
		
		Set<String> allwindowIds = driver.getWindowHandles();
		for(String windowId:allwindowIds) {
			driver.switchTo().window(windowId);
			if(driver.getCurrentUrl().contains("legal")) {
				break;
			}
		}		
		
		List<WebElement> headers = driver.findElements(By.xpath("//div[@aria-labelledby='uniqueListTitleID']/..//h3"));
		for(WebElement header : headers) {
			System.out.println(header.getText());
		}
		
		/*
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
		driver.switchTo().parentFrame();
		*/	
		
	}

}
