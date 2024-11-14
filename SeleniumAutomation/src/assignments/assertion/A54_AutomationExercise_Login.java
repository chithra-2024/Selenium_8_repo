package assignments.assertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class A54_AutomationExercise_Login {

	@Test
	public void login() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://automationexercise.com");
		Assert.assertEquals(driver.getTitle(), "Automation Exercise","Welcome page is not displayed");
		Reporter.log("Welcome page is displayed");
		
		driver.findElement(By.partialLinkText("Signup / Login")).click();
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("Test1015@gmail.com");
		driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Test123");
		
		driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),' Logged in as ')]")).isDisplayed(),"Logged in as user text is not visible");
		Reporter.log("Logged in as user text is visible");
		
		driver.findElement(By.xpath("//a[contains(text(),' Delete Account')]")).click();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).isDisplayed(), "ACCOUNT DELETED! text is not visible.");
		Reporter.log("ACCOUNT DELETED! text is visible.");
		
		
		
	}
}
