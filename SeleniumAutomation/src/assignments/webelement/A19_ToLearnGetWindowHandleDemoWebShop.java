package assignments.webelement;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A19_ToLearnGetWindowHandleDemoWebShop {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Facebook']")).click();
		Set<String> windowSessionIds = driver.getWindowHandles();
		
		for(String id:windowSessionIds)
		{
			System.out.println(id);
		}
	}

}
