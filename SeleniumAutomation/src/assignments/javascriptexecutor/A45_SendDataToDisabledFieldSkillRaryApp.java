package assignments.javascriptexecutor;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A45_SendDataToDisabledFieldSkillRaryApp {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://demoapp.skillrary.com/");
		WebElement subscribeEmailTF = driver.findElement(By.xpath("//input[@class='form-control']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='test123@gmail.com'", subscribeEmailTF);
		
		File temp = subscribeEmailTF.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+LocalDateTime.now().toString().replace(":", "-")+".png");
		FileHandler.copy(temp, dest);
		
	}

}
