package assignments.synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A31_DemoWebShopExplicitWait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		//1. open demowebshop url
		driver.get("https://demowebshop.tricentis.com/");
		
		//2. click on "14 inch laptop" Add to Cart button
		driver.findElement(By.xpath("//a[contains(text(),'14.1-inch Laptop')]/../..//input[@type='button']")).click();
		
		//3.capture success message and back ground color of success message
		WebElement successMessage = driver.findElement(By.xpath("//p[@class='content']"));
		System.out.println("Success Message is "+successMessage.getText());
		//rgba(0, 0, 0, 0) none repeat scroll 0% 0% / auto padding-box border-box
		System.out.println(successMessage.getCssValue("background"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfAllElements(successMessage));
		
		//4. click on Login link
		driver.findElement(By.linkText("Log in")).click();
		
		

	}

}
