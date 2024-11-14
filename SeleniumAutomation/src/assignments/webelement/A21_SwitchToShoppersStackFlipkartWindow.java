package assignments.webelement;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A21_SwitchToShoppersStackFlipkartWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.shoppersstack.com/products_page/15");
		Thread.sleep(30000);
		
		driver.findElement(By.xpath("//button[@name='compare']")).click();
		
		switchToWindow(driver,"flipkart");
		Thread.sleep(15000);
		Point flipkartPosition = driver.manage().window().getPosition();
		
		switchToWindow(driver,"ebay");
		Thread.sleep(15000);
		Point ebayPosition = driver.manage().window().getPosition();

		driver.manage().window().setPosition(flipkartPosition);
		
		switchToWindow(driver,"flipkart");
		Thread.sleep(15000);
		driver.manage().window().setPosition(ebayPosition);	
		
		System.out.println("end of program");

	}
	
	public static void switchToWindow(WebDriver driver, String partOfUrl) 
	{		
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id: allWindowIds) {	
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains(partOfUrl)) {				
				break;
			}			
		}		
		
	}

}
