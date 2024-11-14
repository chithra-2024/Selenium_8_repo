package assignments.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A6_ToLearnDemoWebShopLogin {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/login");		
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("kala456@gmail.com");
		driver.findElement(By.cssSelector("input[name='Password']")).sendKeys("123456");
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

}
