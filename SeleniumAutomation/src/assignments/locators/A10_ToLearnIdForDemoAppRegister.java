package assignments.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A10_ToLearnIdForDemoAppRegister {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Register")).click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Chithra");
		driver.findElement(By.id("LastName")).sendKeys("kala");
		driver.findElement(By.id("Email")).sendKeys("kala456@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
		
		driver.findElement(By.name("register-button")).click();
		
		Thread.sleep(3000);
		driver.close();

	}

}
