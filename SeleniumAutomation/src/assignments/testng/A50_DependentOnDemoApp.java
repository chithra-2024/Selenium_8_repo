package assignments.testng;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class A50_DependentOnDemoApp {
	
	@Test(invocationCount = 2,threadPoolSize = 2)
	public void createAccount() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/register");
		Reporter.log("Account created successfully.");
	}
	
	@Test(priority = 1,dependsOnMethods = "createAccount",invocationCount = 2,threadPoolSize = 2)
	public void editAccount() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/login");
		Reporter.log("Account edited successfully.");
	}
	
	@Test(dependsOnMethods = {"editAccount","createAccount"},invocationCount = 2,threadPoolSize = 2)
	public void deleteAccount() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/cart");
		Reporter.log("Account deleted successfully.");
	}
	
	

}
