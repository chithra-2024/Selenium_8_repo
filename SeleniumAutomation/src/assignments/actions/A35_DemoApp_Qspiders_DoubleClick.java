package assignments.actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A35_DemoApp_Qspiders_DoubleClick {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[contains(text(),'UI Testing Concepts')]")).click();
		driver.findElement(By.xpath("//section[contains(text(),'Button')][1]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Double Click"))));
		
		driver.findElement(By.linkText("Double Click")).click();
		Actions act = new Actions(driver);
		act.pause(2000);
		WebElement yesButton = driver.findElement(By.xpath("//button[contains(text(),'Yes')][1]"));		
		
		act.doubleClick(yesButton).perform();
		act.pause(2000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+LocalDateTime.now().toString().replace(":", "-")+".png");
		FileHandler.copy(temp, dest);
		
	}

}
