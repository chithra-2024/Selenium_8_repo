package assignments.popup;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A43_ChildWindowPopupShoppersStackApp {
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.get("https://www.shoppersstack.com/products_page/25");
		driver.findElement(By.id("compare")).click();
		
		Set<String> allwindowIds = driver.getWindowHandles();
		
		for(String id:allwindowIds) {
			driver.switchTo().window(id);			
			if(driver.getCurrentUrl().contains("amazon")) {
				break;
			}
		}
		
		Actions actions = new Actions(driver);
		actions.scrollByAmount(300, 500).perform();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp =ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+LocalDateTime.now().toString().replace(":", "-")+".png");
		FileHandler.copy(temp, dest);
		
	}



}
