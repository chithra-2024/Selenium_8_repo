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
import org.openqa.selenium.support.ui.WebDriverWait;
import assignments.utility.SwitchToWindowUtility;

public class A38_Global_Sqa_App_Drag_And_Drop {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		WebElement iframeGallery = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));		
		driver.switchTo().frame(iframeGallery);
		
		WebElement image1 = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
		WebElement image2 = driver.findElement(By.xpath("//img[@alt='The chalet at the Green mountain lake']"));
		
		WebElement trash = driver.findElement(By.id("trash"));
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(image1, trash).perform();
		action.dragAndDrop(image2, trash).perform();
		
		driver.switchTo().parentFrame();
		
		
		action = new Actions(driver);
		
		action.click(driver.findElement(By.xpath("//a[contains(text(),'CheatSheets')]"))).perform();
		driver.navigate().back();
		driver.navigate().forward();
		action.pause(2000);
		action.click(driver.findElement(By.xpath("//a[contains(text(),'SQL Cheat Sheet')]"))).perform();
		action.pause(2000);
		SwitchToWindowUtility.switchToWindow(driver, "sql-cheat-sheet");
		WebElement sqlImage = driver.findElement(By.xpath("//div[contains(@class,'wp-block-jetpack-slideshow aligncenter')][2]"));
		action.scrollToElement(sqlImage).perform();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp =ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+LocalDateTime.now().toString().replace(":", "-")+".png");
		FileHandler.copy(temp, dest);	
		
	}

}
