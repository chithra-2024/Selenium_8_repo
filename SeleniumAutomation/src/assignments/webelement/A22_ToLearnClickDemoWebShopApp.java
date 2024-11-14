package assignments.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import assignments.utility.SwitchToWindowUtility;

public class A22_ToLearnClickDemoWebShopApp {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		if(driver.getCurrentUrl().equals("https://demowebshop.tricentis.com/"))
			System.out.println("User navigated to Welcome page");
		
		driver.findElement(By.xpath("//a[text()='Facebook']")).click();
		
		SwitchToWindowUtility.switchToWindow(driver, "https://www.facebook.com/nopCommerce");
		System.out.println(driver.getCurrentUrl());

		if(driver.getCurrentUrl().equals("https://www.facebook.com/nopCommerce"))
			System.out.println("User navigated to Facebook Login page");
		
		driver.findElement(By.xpath("//span[contains(text(),'Create')]")).click();
		
		SwitchToWindowUtility.switchToWindow(driver, "https://www.facebook.com/reg/?next=%2FnopCommerce");
		if(driver.getCurrentUrl().equals("https://www.facebook.com/reg/?next=%2FnopCommerce"))
			System.out.println("User navigated to Sign Up Page");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@name,'firstname')]")).sendKeys("CHITHRA");
		
	}

}
