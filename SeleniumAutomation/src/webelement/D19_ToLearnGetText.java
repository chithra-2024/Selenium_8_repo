package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D19_ToLearnGetText {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/login");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		String errorMsg = driver.findElement(By.xpath("//div[@class='validation-summary-errors']")).getText();
		System.out.println(errorMsg);
		
		if(errorMsg.contains("Login was unsuccessful")) {
			System.out.println("Error msg is displayed");
		} else {
			System.out.println("Error msg is not displayed or incorrect.");
		}
	}

}
