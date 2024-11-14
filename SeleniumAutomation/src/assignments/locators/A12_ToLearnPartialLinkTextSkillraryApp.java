package assignments.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A12_ToLearnPartialLinkTextSkillraryApp {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoapp.skillrary.com");
		driver.findElement(By.partialLinkText("SIGNUP")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("chithra");
		Thread.sleep(2000);
		driver.findElement(By.name("lastname")).sendKeys("kala");
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys("user123@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("user");
		Thread.sleep(2000);
		driver.findElement(By.name("confirmpassword")).sendKeys("user");
		Thread.sleep(2000);
		
		driver.findElement(By.name("signup")).click();
		
		//verify user is navigated to welcome page
		System.out.println(driver.getCurrentUrl());
		

	}

}
