package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D30_ToLearnMoveByOffSet {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		driver.get("https://www.myntra.com");
		Actions action = new Actions(driver);
		
		action.moveByOffset(141, 40).perform();
		
		driver.findElement(By.xpath("//a[contains(text(),'T-Shirts')]")).click();
	}

}
