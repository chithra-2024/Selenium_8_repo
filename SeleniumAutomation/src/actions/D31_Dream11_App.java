package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class D31_Dream11_App {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.dream11.com/");
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(By.xpath("//input[@id='regEmail']"))).perform();
		//driver.findElement(By.xpath("//input[@id='regEmail']")).sendKeys("1234567890");
	}

}
