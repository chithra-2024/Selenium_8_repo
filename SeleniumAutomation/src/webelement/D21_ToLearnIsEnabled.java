package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D21_ToLearnIsEnabled {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.instagram.com/");
		System.out.println("====== before passing data========");
		WebElement logInbuttonElement = driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println(logInbuttonElement.isEnabled());
		driver.findElement(By.xpath("//input[contains(@aria-label,'Phone number, username, or email')]")).sendKeys("123456");
		driver.findElement(By.xpath("//input[contains(@aria-label,'Password')]")).sendKeys("123456");
		
		System.out.println("====== After passing data========");		
		System.out.println(logInbuttonElement.isEnabled());
		
	}

}
