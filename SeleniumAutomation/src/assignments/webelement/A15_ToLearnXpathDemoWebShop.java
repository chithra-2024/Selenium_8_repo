package assignments.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A15_ToLearnXpathDemoWebShop {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("kala456@gmail.com");
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Demo Web Shop")) {
			System.out.println("Verified welcome page");
		} else
		{
			System.out.println("User did not succeed to login.");
		}
		
	}

}
