package assignments.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class A24_ToLearnCssValueVtigerApp {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.vtiger.com/vtigercrm/");
		
		driver.findElement(By.xpath("//input[@name='username']")).clear();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Testing");
		
		driver.findElement(By.xpath("//input[@name='password']")).clear();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		WebElement validationMsg = driver.findElement(By.xpath("//span[@id='validationMessage']"));
		
		System.out.println(validationMsg.getCssValue("color"));
		String c = Color.fromString(validationMsg.getCssValue("color")).asHex();
		System.out.println(c);
		if(c.equals("#ff0000")) {
			System.out.println("Text Color is red");
		} else {
			System.out.println("Text color is not  red");
		}
		
		
	}

}
