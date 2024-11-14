package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D32_ToLearnCopyAndPaste {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/register");
		
		driver.findElement(By.id("FirstName")).sendKeys("John");
		
		Actions action = new Actions(driver);
		
		action.keyDown(Keys.CONTROL).keyDown("a").perform();
		action.keyUp(Keys.CONTROL).keyUp("a").perform();
		
		action.keyDown(Keys.CONTROL).keyDown("c").perform();
		action.keyUp(Keys.CONTROL).keyUp("c").perform();
		
		action.keyDown(Keys.TAB).perform();
		action.keyUp(Keys.TAB).perform();
		
		action.keyDown(Keys.TAB).perform();
		action.keyUp(Keys.TAB).perform();
		
		action.keyDown(Keys.CONTROL).keyDown("v").perform();
		action.keyUp(Keys.CONTROL).keyUp("v").perform();
		
		
	}

}
