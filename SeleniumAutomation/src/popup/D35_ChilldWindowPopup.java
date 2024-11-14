package popup;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D35_ChilldWindowPopup {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.get("https://www.shoppersstack.com/products_page/25");
		driver.findElement(By.id("compare")).click();
		
		Set<String> allwindowIds = driver.getWindowHandles();
		
		for(String id:allwindowIds) {
			driver.switchTo().window(id);			
			if(driver.getCurrentUrl().contains("flipkart")) {
				break;
			}
		}
		
		driver.manage().window().maximize();
		driver.close();
	}

}
