package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D19_ToLearnGetCssValue1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();		
		
		driver.get("https://demowebshop.tricentis.com/login");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		 WebElement errorMsg = driver.findElement(By.xpath("//div[@class='validation-summary-errors']"));
		 
		 System.out.println(errorMsg.getCssValue("color"));
		 System.out.println(errorMsg.getCssValue("font-size"));
		 System.out.println(errorMsg.getCssValue("font-family"));
		 
	}

}
