package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D32_ToLearnDragAndDrop {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://www.globalsqa.com/demo-site/draganddrop");
		WebElement photoFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(photoFrame);
		
		WebElement image1 = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
		WebElement image2 = driver.findElement(By.xpath("//img[@alt='The chalet at the Green mountain lake']"));
		WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(image1, trash).perform();
		action.dragAndDrop(image2, trash).perform();
		
		WebElement gallery = driver.findElement(By.id("gallery"));
		action.pause(2000);
		action.dragAndDrop(image1,gallery).perform();
		action.dragAndDrop(image2,gallery).perform();

		
		
		
		
		
	}

}
