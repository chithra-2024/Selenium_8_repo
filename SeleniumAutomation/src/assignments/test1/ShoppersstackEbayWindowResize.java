package assignments.test1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppersstackEbayWindowResize {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.get("https://www.shoppersstack.com/");
		
		driver.findElement(By.xpath("//img[@alt='PONDs Bright Beauty Serum Cream Anti Spot Fairness SPF']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("compare")).click();
		switchToWIndow(driver,"ebay");
		
		driver.manage().window().setSize(new Dimension(150, 150));
		
	}
	
	public static void switchToWIndow(WebDriver driver,String url) {
		Set<String> windowIds = driver.getWindowHandles();
		
		for(String id:windowIds) {
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains(url)) {
				break;
			}
		}
	}

}
