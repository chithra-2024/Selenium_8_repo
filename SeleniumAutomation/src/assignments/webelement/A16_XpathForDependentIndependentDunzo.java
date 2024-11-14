package assignments.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A16_XpathForDependentIndependentDunzo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.dunzo.com/bangalore");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Search']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search for item')]")).sendKeys("apple");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Apple - Kashmiri']/../..//button[text()='ADD'][1]")).click();
		
		
	}

}
