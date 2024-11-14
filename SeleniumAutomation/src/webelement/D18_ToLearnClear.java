package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D18_ToLearnClear {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.vtiger.com/vtigercrm/");
		WebElement usernameTF = driver.findElement(By.id("username"));
		Thread.sleep(2000);
		
		usernameTF.clear();
		Thread.sleep(2000);
		
		usernameTF.sendKeys("Testing");
		
		WebElement passwordTF = driver.findElement(By.id("password"));
		Thread.sleep(2000);
		passwordTF.clear();
		Thread.sleep(2000);
		passwordTF.sendKeys("admin");
	}

}
